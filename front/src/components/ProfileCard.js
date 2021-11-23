import React from "react";
import { useParams } from "react-router";
import { useSelector } from "react-redux";


const ProfileCard = props => {

    const {username: loggedInUsername} = useSelector((store) => ({username: store.username}))
    const rauteParams = useParams()
    const pathUsername = rauteParams.username
    let message = "We cannot edit"
    console.log(pathUsername)
    if (pathUsername === loggedInUsername) {
        message = "We can edit"
    }
    return <div>{message}</div>
}

export default ProfileCard
