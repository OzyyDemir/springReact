import React from "react";
import { withRouter } from "react-router";
import { connect } from "react-redux";
// import { Authentication } from "../shared/AuthenticationContext";

const  ProfileCard = props => {
                const pathUsername = props.match.params.username
                let message = "We cannot edit"
                console.log(pathUsername)
                if(pathUsername === props.loggedInUsername){
                    message = "We can edit"
                }
                return <div>{message}</div>
            }

// class ProfileCardContextWrapper extends React.Component {
//     // static contextType = Authentication
//     render() {
//         return (
//             <ProfileCard {...this.props} userName= {this.context.state.userName}/>
//         )
//     }
// }

const mapStateToProps = (store) => {
    return {
        loggedInUsername: store.userName
    }
}

export default connect(mapStateToProps)(withRouter(ProfileCard))