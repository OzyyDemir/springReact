import React, { Component } from 'react'
import { getUsers } from '../api/apiCalls'

class UserList extends Component {

    state = {
        users: []
    };

    componentDidMount(){
        getUsers().then(response => {
            this.setState({
                users : Array.from(response.data)
            })
        })
    }

    render() {
        const { users } = this.state
        return (
            <div>
            {users.map((user, index) => (
                 <div> {user.userName} </div>
                ))}
            </div>
        )
    }
}

export default UserList
