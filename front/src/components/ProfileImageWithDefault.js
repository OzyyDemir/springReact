import React from "react";
import defaultPicture from "../assests/user.png"

const ProfileImageWithDefault = (props) => {

    const {userImage} = props

    let imageSource = defaultPicture
    if(userImage){
        imageSource = userImage
    }
    return <img alt={`Profile`} src={imageSource} {...props}/>
    
}


export default ProfileImageWithDefault