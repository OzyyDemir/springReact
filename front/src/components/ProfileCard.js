import React, { useState, useEffect } from "react";
import { useParams } from "react-router";
import { useSelector } from "react-redux";
import defaultPicture from "../assests/user.png"
import ProfileImageWithDefault from "./ProfileImageWithDefault";
import Input from "./Input";
import { updateUser } from "../api/apiCalls";
import { useApiProgress } from "../shared/ApiProgress";
import ButtonWithProgress from "./ButtonWithProgress";

const ProfileCard = props => {

    const [inEditMode, setInEditMode] = useState(false);
    const [updatedUserFirstName, setUpdatedUserFirstName] = useState()
    const { userName: loggedInUserName } = useSelector((store) => ({ userName: store.userName }))
    const routeParams = useParams()
    const pathUserName = routeParams.userName
    const [user, setUser] = useState({})
    const [editable, setEditable] = useState(false)

    useEffect(() =>{
        setUser(props.user)
    }, [props.user])

    useEffect(() => {
       setEditable(pathUserName === loggedInUserName)
    }, [pathUserName, loggedInUserName])

    const { userName, userFirstName, image } = user

    useEffect(() => {
        if(!inEditMode){
        setUpdatedUserFirstName(undefined)
        } else {
        setUpdatedUserFirstName(userFirstName)
        }
    }, [inEditMode, userFirstName])

    const onClickSave = async () => {
       const body = {
           userFirstName: updatedUserFirstName
       }
       try{
        const response = await updateUser(userName, body)
        setInEditMode(false)
        setUser(response.data)
       } catch (error){

       }
    }

    const pendingApiCall = useApiProgress('put', '/api/users/'+ userName)




    return (
        <div className="card text-center">
            <div className="card-header">
                <ProfileImageWithDefault
                    className="rounded-circle shadow"
                    width="200"
                    height="200"
                    alt={`${userName} profile`}
                    image={image} />
            </div>
            <div className="card-body ">
            {!inEditMode &&
                (
                    <>
                        <h3>{userFirstName}@{userName}</h3>
                        {editable && (<button className="btn btn-success d-inline-flex" onClick={() => setInEditMode(true)}>
                            <span className="material-icons">
                                edit
                            </span>Edit
                        </button>)}
                    </>
                )
            }
                {inEditMode && (
                    <div>
                        <Input label="Change name" defaultValue={userFirstName}
                        onChange= {(event) => {setUpdatedUserFirstName(event.target.value)}} />
                        <div>
                            <ButtonWithProgress 
                            className="btn btn-primary  d-inline-flex" 
                            onClick={onClickSave}
                            disabled={pendingApiCall}
                            pendingApiCall={pendingApiCall}
                            text={
                                <span className="material-icons">
                                    save_as
                                </span>
                            }Save
                            />
                            <button 
                             className="btn btn-light d-inline-flex ml-1"
                             onClick={() => setInEditMode(false)}
                             disabled={pendingApiCall}
                             >
                                <span className="material-icons">
                                    close
                                </span> Cancel
                            </button>
                        </div>
                    </div>
                )}
            </div>

        </div>
    )
}

export default ProfileCard
