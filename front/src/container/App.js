import React from "react";
import UserSignUpPage from '../pages/UserSignUpPage';
import LoginPage from '../pages/LoginPage'
import HomePage from '../pages/HomePage'
import UserPage from '../pages/UserPage'
import {Route, Redirect, Switch, Router} from 'react-router-dom'
import TopBar from "../components/TopBar";
import { connect } from "react-redux";
// import { Authentication } from "../shared/AuthenticationContext";


class App extends React.Component {
  // static contextType = Authentication
  render(){
    const {isLoggedIn} = this.props

return (
    <div >
    <Router>
      <TopBar />
      <Switch>
        <Route exact path="/" component={HomePage} />
        {!isLoggedIn && <Route path="/login" component={LoginPage} /> }
        <Route path="/signup" component={UserSignUpPage} /> 
        <Route path="/user/:username" component={UserPage} /> 
        <Redirect to="/" />
      </Switch>
    </Router>
    </div>
  );
 }
  }

  const mapStateToProps = (store) => {
    return {
        isLoggedIn : store.isLoggedIn
    }
}
  

export default connect(mapStateToProps)(App);
