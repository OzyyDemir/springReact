import { createStore, applyMiddleware, compose} from 'redux';
import authReducer from './authReducer';
import SecureLS from 'secure-ls';
import thunk from 'redux-thunk';

const secureLs = new SecureLS()

const getStateFromStorage = () => {
  const appAuth = secureLs.get('app-auth')

  let stateInLocalStorage = {
    isLoggedIn: false,
    userName : undefined,
    password : undefined,
    userFirstName: undefined,
    userLastName: undefined,
    userTelNo: undefined,
    userEmail: undefined,

  }

  if(appAuth){
  return appAuth
  }
  return stateInLocalStorage
}

const updateStateInStorage = newState => {
  secureLs.set('app-auth',newState)
}

const configureStore = () => {
   const composeEnhancers = window.__REDUX_DEVTOOLS_EXTENSION_COMPOSE__ || compose;
   const store =createStore(authReducer,getStateFromStorage(),composeEnhancers(applyMiddleware(thunk)));
   
   store.subscribe(() => {
    updateStateInStorage(store.getState())
     })
   
     return store;
  }


export default configureStore