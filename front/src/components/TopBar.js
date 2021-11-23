import React from 'react'
import logo from '../assests/logo.png'
import { Link } from 'react-router-dom'
import { useDispatch, useSelector } from 'react-redux'
import logoutSuccess from '../redux/authActions'


const TopBar = (props) => {
   

    const {username, isLoggedIn} = useSelector((store)=>{
        return {
            isLoggedIn: store.isLoggedIn,
            username: store.username
        }
    })

    const dispatch = useDispatch()

    const onLogoutSuccess = () => {
        dispatch(logoutSuccess())
    }

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
    if (isLoggedIn) {
        links = (
            <ul className="navbar-nav ms-auto">
                <li>
                    <Link className="nav-link" to={`/user/${username}`}>
                        {username}
                    </Link>

                </li>
                <li> <Link className="nav-link" onClick={onLogoutSuccess}
                    style={{ cursor: 'pointer' }} to={`/login`} >
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

export default TopBar

