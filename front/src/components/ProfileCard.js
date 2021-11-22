import React from "react";
import { useParams } from "react-router";
import { useSelector } from "react-redux";


const ProfileCard = props => {

    const {userName: loggedInUsername} = useSelector((store) => ({userName: store.userName}))
    const rauteParams = useParams()
    const pathUsername = rauteParams.userName
    let message = "We cannot edit"
    console.log(pathUsername)
    if (pathUsername === loggedInUsername) {
        message = "We can edit"
    }
    return <div>{message}</div>
}

export default ProfileCard
