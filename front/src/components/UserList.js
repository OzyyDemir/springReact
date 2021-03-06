import React, { useEffect, useState } from 'react'
import { getUsers } from '../api/apiCalls'
import { useApiProgress } from '../shared/ApiProgress';
import Spinner from "../components/Spinner";
import UserListItem from './UserListItem';


const UserList = () => {

    const [page, setPage] =  useState({
        content: [], 
        size: 3,
        number: 0
    })

    const [loadFailure, setLoadFailure] = useState(false)
    const pendingApiCall = useApiProgress('get', 'api/users/getall?page')

    useEffect(() => {
        loadUsers()
    }, [])

    const onClickNext = () => {
        const nextPage = page.number +1
        loadUsers(nextPage)
    }

    const onClickPrevious = () => {
        const previousPage = page.number -1
        loadUsers(previousPage)
    }

    const loadUsers = async (page) => {
        setLoadFailure(false)
        try {
            const response = await getUsers(page)
            setPage(response.data)
        } catch (error) {
            setLoadFailure(true)
        }
    }

       

        const { content : users, last, first } = page

        let actionDiv = (
            <div>
                {first === false && (<button className="btn btn-sm btn-light" onClick={onClickPrevious}
                    >Previous
                </button>)}
                {last === false && (<button className="btn btn-sm btn-light float-end" onClick={onClickNext}
                    >Next
                </button>)}
             </div>
        )
        if(pendingApiCall){
            actionDiv = (
                <Spinner />
            )
        }

        return (
            <div className="card">
                <h3 className="card-header text-center">Users</h3>
                <div className = "list-group">
                    {users.map(user => (
                    <UserListItem key={user.userName} user = {user} />
                    ))}
                </div>
                 {actionDiv}
                 {loadFailure && <div className="text-center text-danger">Load Failure</div>}
            </div>
        )
    
}

export default UserList
