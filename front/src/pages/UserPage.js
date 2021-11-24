import React, { useEffect, useState } from "react";
import ProfileCard from "../components/ProfileCard";
import { getUser } from "../api/apiCalls";
import { useParams } from "react-router";
import {useApiProgress} from '../shared/ApiProgress'
import Spinner from "../components/Spinner";

const UserPage = () => {

    const [user, setUser] = useState({})
    const [notFound, setNotFound] = useState(false)

    const {userName} = useParams()

    const  pendingApiCall = useApiProgress('get', '/api/users/' + userName)

    useEffect(() => {
        setNotFound(false)
    }, [user])

    useEffect(() => {
        const loadUser = async () => {
            try {
                const response = await getUser(userName)
                setUser(response.data)   
            } catch (error) { 
                setNotFound(true)
            }
        }
        loadUser()
    }, [userName])

    if(pendingApiCall){
        return(
           <Spinner />
        )
    }

    if(notFound){
        return (
        <div className="container">
            <div className="alert alert-danger text-center" >
                <div>
                    <i className="material-icons" style={{fontSize: '48px'}}>error</i>
                </div>
                User not Found
            </div>
        </div>
        )
    }


    return (
        <div className="container">
            <ProfileCard user={user}/>
        </div>
    )
}

export default UserPage