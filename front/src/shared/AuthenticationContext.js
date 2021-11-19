import React, { Component } from 'react'

export const Authentication = React.createContext();

export default class AuthenticationContext extends Component {
      
  state = {
    isLoggedIn: true,
    userName: undefined,
    password: undefined

}

  onLoginSuccess= authState => {
    this.setState({
      ...authState,
      isLoggedIn:true
    })
  }

  onLogoutSuccess = () =>{
    this.setState({
      isLoggedIn:false,
      userName: undefined
    })
  }


    render() {
        return (
            <Authentication.Provider value={{
                state: {...this.state },
                onLoginSuccess: this.onLoginSuccess,
                onLogoutSuccess : this.onLogoutSuccess
            }}>
                {this.props.children}
            </Authentication.Provider>
        )
    }
}
