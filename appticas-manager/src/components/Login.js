import React, {Component} from 'react';
import  store from "./store.js";

class  Login extends Component {
    constructor(props){
        super(props);
        this.state={
            view: 'login',
            user:''
        };

    }

    goApps(){
        store.dispatch({
            type: "SET_VIEW",
            view : 'apps'
        })
    }


    render(){
        return (
            <div>
                <label> Ingrese sus credenciales</label>
                <input placeholder="user name"/>
                <input placeholder="password" type="password"/>
                <button onClick={this.goApps}> Go my apps</button>
            </div>
        );
    }

}

export default Login;