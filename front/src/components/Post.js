import React, { Component } from 'react'
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome'
import { faComment,faThumbsDown,faThumbsUp } from '@fortawesome/free-solid-svg-icons'  
import foto from '../assests/logo.png'
import "../assests/home.css"


 

export default class Post extends Component {
    render() {
        return (
        <div className="container  center-image">
            <div className="card mt-0">
                <img src={foto} className="card-img-top image" alt="..." />
                <div className="card-body"  >
                    <h5 className="card-title" >Card title</h5>
                    <p className="card-text">This is a wider card with supporting text</p>                   
                </div>
                <span className="button" >
                    <FontAwesomeIcon onClick ={()=>console.log("asdasd")} cursor="pointer"  href="#" size="3x" transform="shrink-3 left-1" icon={faThumbsUp} /> 
                    <FontAwesomeIcon onClick ={()=>console.log("asdasd")} cursor="pointer" href="#" size="3x" transform="shrink-3 left-1"  icon={faThumbsDown} /> 
                    <FontAwesomeIcon onClick ={()=>console.log("asdasd")} cursor="pointer" href="#" size="3x" transform="shrink-3 left-1"  icon={faComment} /> 
                </span>
            </div>
        </div>
        )
    }
}
