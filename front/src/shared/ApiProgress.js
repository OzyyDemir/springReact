import axios from 'axios'
import React, { Component } from 'react'

export function WithApiProgress(WrappedComponent, apiPath){
  return   class  extends Component {
        state = {
            pendingApiCall: false
        }
    
        componentDidMount(){
            this.requestInterceptor = axios.interceptors.request.use(
                request=>{
                    this.updateApiCallFor(request.url, true)
                return request
            })
    
            this.responseInterceptor = axios.interceptors.response.use(
                response=>{
                    this.updateApiCallFor(response.config.url, false)
                    return response
                },
                error=>{
                    this.updateApiCallFor(error.config.url, false)
                    throw error
                }
            )
        }

        componentWillUnmount(){
            axios.interceptors.request.eject(this.requestInterceptor)
            axios.interceptors.response.eject(this.responseInterceptor)
        }
    
        updateApiCallFor = (url, inProgress)=>{
            if(url === apiPath){        
                this.setState({pendingApiCall:inProgress})
            }
        } 
    
    
        render() {
    
            const {pendingApiCall} = this.state
            return <WrappedComponent pendingApiCall={pendingApiCall} {...this.props}/>
        }
    }
}

