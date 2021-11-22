import React, { useEffect, useState } from 'react'
import Input from '../components/input'
import ButtonWithProgress from '../components/ButtonWithProgress'
import { useDispatch } from 'react-redux'
import { loginHandler} from '../redux/authActions'
import { Link } from 'react-router-dom'
import '../assests/home.css'
import {useApiProgress} from '../shared/ApiProgress'

 const LoginPage = (props) => {

    const[username, setUsername] = useState()
    const[password, setPassword] = useState()
    const[error, setError] = useState()
    const dispatch = useDispatch()

    useEffect (() => {
        setError(undefined)
    }, [username, password])

    const  onClickLogin  = async event => {
            event.preventDefault()
            const creds={
                username,
                password
            }
            const {history} = props 
            const{ push } = history

            setError(undefined)
            try{
               await dispatch(loginHandler(creds))
                push('/')
            }catch(apiError){
                setError(apiError.response.data.message)
            }
        }
   
        const pendingApiCall = useApiProgress('/api/auth')

        const buttonEnabled = username && password;

    return (
        <div className="container">
            <form>
                    <h1 className="text-center">Login</h1>
                    <Input label="Username"onChange={(event)=> setUsername(event.target.value)}/>
                    <Input label="Password" type="password" onChange={(event)=>setPassword(event.target.value)} />
                    {error && <div className="alert alert-danger">{error}</div>}
                    <div className="text-center">
                    <ButtonWithProgress 
                    onClick={onClickLogin}
                    disabled={!buttonEnabled || pendingApiCall}
                    pendingApiCall={pendingApiCall}
                    >
                        Login
                    </ButtonWithProgress>
                    </div>
                    
                </form>
                <button className="btn btn-secondary " >
                   <Link  to={`/signup`} >Hala kayıt olmadın mı?</Link>
                </button>
        </div>
    )
 
        }
        export  default LoginPage
 
 

