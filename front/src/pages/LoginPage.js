import React, { Component } from 'react'
import Input from '../components/input'
import ButtonWithProgress from '../components/ButtonWithProgress'
import { connect } from 'react-redux'
import { loginHandler} from '../redux/authActions'
import { Link } from 'react-router-dom'
import '../assests/home.css'
// import { Authentication } from '../shared/AuthenticationContext'

 class LoginPage extends Component {
    //  static contextType = Authentication

    state ={
        username : null,
        password : null,
        error: null
    }

    onChange = event => {
        const {name,value}  = event.target
        this.setState({
            [name]: value,
            error: null
        })

    }
        onClickLogin  = async event => {
            event.preventDefault()
            const {username,password} = this.state;
            const creds={
                username,
                password
            }
            const {history,dispatch} = this.props 
            const{ push } = history
            console.log(this.props)
            this.setState({
                error: null
            })
            try{
               await dispatch(loginHandler(creds))
                push('/')
            }catch(apiError){
                this.setState({
                    error: apiError.response.data.message
                   
                })
            }
        }
    
    render() {

        const{pendingApiCall} = this.props

        const{username ,password,  error} = this.state

        const buttonEnabled = username && password;

        return (
            <div className="container">
                <form>
                    <h1 className="text-center">Login</h1>
                    <Input label="Username" name="username" onChange={this.onChange}/>
                    <Input label="Password" name="password" type="password" onChange={this.onChange}/>
                    {error && <div className="alert alert-danger">{error}</div>}
                    <div className="text-center">
                    <ButtonWithProgress 
                    onClick={this.onClickLogin}
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
}

// const LoginPageWithApiProgress = WithApiProgress(LoginPage, '/api/auth')

// export default LoginPageWithApiProgress;


export default connect()((LoginPage,'/api/auth'))

