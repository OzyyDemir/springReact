import { createStore, applyMiddleware, compose} from 'redux';
import authReducer from './authReducer';
import SecureLS from 'secure-ls';
import thunk from 'redux-thunk';
import { setAuthorizationHeader } from '../api/apiCalls';

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
    userImage: undefined

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
  const initialState = getStateFromStorage()
  setAuthorizationHeader(initialState)
   const composeEnhancers = window.__REDUX_DEVTOOLS_EXTENSION_COMPOSE__ || compose;
   const store =createStore(authReducer,initialState,composeEnhancers(applyMiddleware(thunk)));
   
   store.subscribe(() => {
    updateStateInStorage(store.getState())
    setAuthorizationHeader(store.getState())
     })
   
     return store;
  }


export default configureStore