import React from 'react'
import { signup } from '../api/apiCalls'
import Input from '../components/input'
import ButtonWithProgress from '../components/ButtonWithProgress'
import { WithApiProgress } from '../shared/ApiProgress'
import { connect } from 'react-redux'


class UserSignUpPage extends React.Component {


    state = {
        userFirstName: null,
        userLastName: null,
        userTelNo: null,
        userEmail: null,
        userName: null,
        userPassword: null,
        passwordRepeat: null,
        errors: {}
    }

    onChange = event => {
        const { name, value } = event.target
        const errors = { ...this.state.errors }
        errors[name] = undefined
        if (name === 'userPassword' || name === 'passwordRepeat') {
            if (name === 'userPassword' && value !== this.state.passwordRepeat) {
                errors.passwordRepeat = 'Password mismatch'
            } else if (name === 'passwordRepeat' && value !== this.state.userPassword) {
                errors.passwordRepeat = 'Password mismatch'
            } else {
                errors.passwordRepeat = undefined
            }
        }
        this.setState({
            [name]: value,
            errors
        })
        console.log(errors)
    }

    onClickSignUp = async event => {
        event.preventDefault()
        
    const { history} = this.props
    const { push } = history
    const { userFirstName, userLastName, userTelNo, userEmail, userName, userPassword } = this.state;

        const body = {
            userFirstName,
            userLastName,
            userTelNo,
            userEmail,
            userName,
            userPassword
            }
        try {
            const response= await signup(body)
            push('/')
        } catch (error) {
            if (error.response.data.validationErrors) {
                this.setState({ errors: error.response.data.validationErrors })
            }

        }
    }

    render() {

        const { pendingApiCall } = this.props
        const { errors } = this.state
        const { userFirstName, userEmail, userPassword, userLastName, userTelNo, userName, passwordRepeat } = errors
        return (
            <div className="container">
                <form>
                    <h1 className="text-center">Sign up</h1>
                    <Input name="userFirstName" label="User First Name" error={userFirstName} onChange={this.onChange} />
                    <Input name="userLastName" label="User Last Name" error={userLastName} onChange={this.onChange} />
                    <Input name="userTelNo" label="User TelNo" error={userTelNo} onChange={this.onChange} />
                    <Input name="userEmail" label="User Email" error={userEmail} onChange={this.onChange} />
                    <Input name="userName" label="UserName" error={userName} onChange={this.onChange} />
                    <Input name="userPassword" label="User Password" error={userPassword} onChange={this.onChange} type="password" />
                    <Input name="passwordRepeat" label="Password Repeat" error={passwordRepeat} onChange={this.onChange} type="password" />
                    <div className="text-center">
                        <ButtonWithProgress
                            disabled={pendingApiCall || passwordRepeat !== undefined}
                            onClick={this.onClickSignUp}
                            pendingApiCall={pendingApiCall}>
                            Kaydol</ButtonWithProgress>
                    </div>
                </form>
            </div>
        )
    }
}
const UserSignUpPageWithApiProgressForSignupRequest = WithApiProgress(UserSignUpPage, '/api/users')
const UserSignUpPageWithApiProgressForAuthRequest = WithApiProgress(UserSignUpPageWithApiProgressForSignupRequest,'/api/auth')


export default connect()(UserSignUpPageWithApiProgressForAuthRequest)