import React, { Component } from 'react'
import logo from '../assests/logo.png'
import { Link } from 'react-router-dom'
import { connect } from 'react-redux'
import logoutSuccess from '../redux/authActions'
// import { Authentication } from '../shared/AuthenticationContext'


class TopBar extends Component {

    // static contextType = Authentication
    render() {
            const {userName, isLoggedIn, onLogoutSuccess} = this.props
                        let links = (
                            <ul className="navbar-nav ms-auto">
                                <li>
                                    <Link className="nav-link" to="/login">
                                        Login
                                    </Link>
                                </li>
                                <li>
                                    <Link className="nav-link" to="/signup">
                                        Signup
                                    </Link>
                                </li>
                            </ul>
                    )
                    if(isLoggedIn){
                    links = (
                        <ul className="navbar-nav ms-auto">
                            <li>
                                <Link className="nav-link" to={`/user/${userName}`}>
                                {userName}
                                </Link>
                                
                            </li>
                            <li> <Link className="nav-link" onClick={onLogoutSuccess} 
                            style={{cursor:'pointer'}}  to={`/login`} >
                                Logout
                                </Link>
                            </li>
                        </ul>
                    )
                    }
        
                    return (
                    <div className="shadow-sm bg-light mb-2">
                        <nav className="navbar navbar-light container navbar-expand">
                            <Link className="navbar-brand" to="/">
                                <img src={logo} width='60' alt="My logo" />
                                MyApp
                            </Link>
                            {links} 
                        </nav>
                    </div>
                    )
                    }
}

const mapStateToProps = (store) => {
    return {
        isLoggedIn : store.isLoggedIn,
        userName: store.userName
    }
}

const mapDispatchToProps = (dispatch) => {
    return{
        onLogoutSuccess: () => dispatch(logoutSuccess())
        }
    }

export default connect(mapStateToProps, mapDispatchToProps)(TopBar)

