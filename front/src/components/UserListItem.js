import React from "react";
import { Link } from "react-router-dom";
import ProfileImageWithDefault from "./ProfileImageWithDefault";

const UserListItem = (props) => {

    const {user } = props
    const {userName, userFirstName, userImage } = user
  
    return(
        <Link to = {`/user/${userName}`} className="list-group-item list-group-item-action">
        <ProfileImageWithDefault
        className="rounded-circle"  
        width="32" 
        height ="32"
        alt={`${userName} profile`} 
        image={userImage} />
        <span className="pl-2"> {userFirstName}@{userName} </span>
        </Link>
    )
}

export default UserListItem