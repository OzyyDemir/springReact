import React from "react";

const ButtonWithProgress = (props) => {

    const {onClick, pendingApiCall, disabled, className, text} = props


    return(
        <button
        disabled={disabled}
        className={className || "btn btn-primary"}
        onClick={onClick}>
        {pendingApiCall && <span className="spinner-border spinner-border-sm"></span>}
        Kaydol</button>

    )
}

export default ButtonWithProgress