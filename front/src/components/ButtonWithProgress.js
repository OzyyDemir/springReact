import React from "react";

const ButtonWithProgress = (props) => {

    const {onClick, pendingApiCall, disabled} = props


    return(
        <button
        disabled={disabled}
        className="btn btn-primary"
        onClick={onClick}>
        {pendingApiCall && <span className="spinner-border spinner-border-sm"></span>}
        Kaydol</button>

    )
}

export default ButtonWithProgress