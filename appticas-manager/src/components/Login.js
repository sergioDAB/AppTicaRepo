import React, {Component} from 'react';
import  store from "./store.js";

class  Login extends Component {
    constructor(props){
        super(props);
        this.state={
            view: 'login',
            user:'us',
            userType: "us"
        };

        store.subscribe(()=>{
            this.setState({
                view:store.getState().view,
                user:store.getState().user,
                userType:store.getState().typeUser
            })
        });

        this.validateUser=this.validateUser.bind(this);

        this.user = React.createRef();
        this.password = React.createRef();

    }

    goApps(){
        store.dispatch({
            type: "SET_VIEW",
            view : 'apps'
        })
    }

    validateUser(){
        let user = this.user.current.value;
        let pass = this.password.current.value;

        let url = "http://localhost:8080/login?user="+user+"&password="+pass;

        fetch(url
        ).then(res => res.json())
            .catch(error => console.error('Error:', error))
            .then(response =>{
                if(response.body.id === -1){
                    window.alert("datos invalidos")
                }else{
                    console.log(response)
                    store.dispatch({
                        type:"SET_VIEW",
                        view: "apps",
                        user: response.body.user,
                        typeUser: response.body.userType,
                        userId:response.body.id
                    });
                }

                console.log(response.body)
            });
    }


    render(){
        return (
            <div>
                <label> Ingrese sus credenciales</label>
                <input placeholder="user name" ref={this.user}/>
                <input placeholder="password" type="password" ref={this.password}/>
                <button onClick={this.validateUser}> Go my apps</button>
            </div>
        );
    }

}

export default Login;