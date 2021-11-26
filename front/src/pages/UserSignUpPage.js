import React, { useEffect, useState } from 'react'
import { signup } from '../api/apiCalls'
import Input from '../components/Input'
import ButtonWithProgress from '../components/ButtonWithProgress'
import { useApiProgress, WithApiProgress } from '../shared/ApiProgress'
import { connect } from 'react-redux'


const UserSignUpPage = (props) => {

    const [form, setForm] = useState({
        userFirstName: null,
        userLastName: null,
        userTelNo: null,
        userEmail: null,
        userName: null,
        userPassword: null,
        userPasswordRepeat: null,
    })
    
    const [errors, setErrors] = useState({})


    const onChange = event => {
        const { name, value } = event.target
        setErrors((previousErrors) => ({...previousErrors, [name]: undefined}) )
        setForm((previousForm) => ({...previousForm, [name]:value}))
    }

   const onClickSignUp = async event => {
        event.preventDefault()
        
    const { history} = props
    const { push } = history
    const { userFirstName, userLastName, userTelNo, userEmail, userName, userPassword } = form

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
                setErrors(error.response.data.validationErrors)
            }

        }
    }

      
         // const { errorsCopy } = this.state

        const { 
            userFirstName: userFirstNameError, userEmail:userEmailError, 
            userPassword: userPasswordError, userLastName:userLastNameError,
            userTelNo:userTelNoError, userName:usernameError
         } = errors
         const  pendingApiCallSignup = useApiProgress('post', '/api/users') 
         const pendingApiCalLogin = useApiProgress('post', '/api/auth')
        
         const pendingApiCall = pendingApiCalLogin || pendingApiCallSignup

         let userPasswordRepeatError;
         if(form.userPassword !== form.userPasswordRepeat){
             userPasswordRepeatError = 'Password mismatch'
         }

        return (
            <div className="container">
                <form>
                    <h1 className="text-center">Sign up</h1>
                    <Input name="userFirstName" label="User First Name" error={userFirstNameError} onChange={onChange} />
                    <Input name="userLastName" label="User Last Name" error={userLastNameError} onChange={onChange} />
                    <Input name="userTelNo" label="User TelNo" error={userTelNoError} onChange={onChange} />
                    <Input name="userEmail" label="User Email" error={userEmailError} onChange={onChange} />
                    <Input name="userName" label="userName" error={usernameError} onChange={onChange} />
                    <Input name="userPassword" label="User Password" error={userPasswordError} onChange={onChange} type="password" />
                    <Input name="userPasswordRepeat" label="Password Repeat" error={userPasswordRepeatError} onChange={onChange} type="password" />
                    <div className="text-center">
                        <ButtonWithProgress
                            disabled={pendingApiCall || userPasswordRepeatError !== undefined}
                            onClick={onClickSignUp}
                            pendingApiCall={pendingApiCall}>
                            Kaydol</ButtonWithProgress>
                    </div>
                </form>
            </div>
        )
   
}

export default UserSignUpPage