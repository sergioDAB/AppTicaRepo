import React, { Component } from 'react';
import store from "./store.js";

import '../css/Application.css';


class Appuser extends Component {

    constructor(props){
        super(props);
        this.state={
            user: store.getState().user,
            view: store.getState().view,
            typeUser:store.getState().typeUser,
            userId:store.getState().userId
        };

        store.subscribe(()=>{
            this.setState({
                user: store.getState().user,
                view: store.getState().view,
                typeUser:store.getState().typeUser,
                userId:store.getState().userId
            });
        });
        this.set1 = this.set1.bind(this);
        this.set2 = this.set2.bind(this);
        this.set3 = this.set3.bind(this);
        this.set4 = this.set4.bind(this);
        this.set5 = this.set5.bind(this);
        this.calificateApp = this.calificateApp.bind(this);

    }

    set1(){
        this.calificateApp(1);
    }
    set2(){
        this.calificateApp(2);
    }
    set3(){
        this.calificateApp(3);
    }
    set4(){
        this.calificateApp(4);
    }
    set5(){
        this.calificateApp(5);
    }

    calificateApp(puntuacion){
        let app = this.props.id;
        let user= store.getState().userId;
        console.log("calificar con "+ puntuacion +" user"+ user + " app "+ app );

        let url = "http://localhost:8080/calificate?points="+puntuacion+"&app="+app+"&user="+user;

        fetch(url
        ).then(res => res.json())
            .catch(error => console.error('Error:', error))
            .then(response =>{
                if(response.body !== 200 && response.body !== "200"){
                    window.alert("error con la calificacion");
                }else{
                    console.log(response);
                    window.alert("la app fue calificada");
                }

                console.log(response.body)
            });
    }

    render() {
        return (
            <tr>
                <th className="rowlabel">{this.props.id}</th>
                <th className="rowlabel">{this.props.nombre}</th>
                <th className="rowlabel">{this.props.stars}</th>
                <button onClick={this.set1}> 1 </button>
                <button onClick={this.set2}> 2 </button>
                <button onClick={this.set3}> 3 </button>
                <button onClick={this.set4}> 4 </button>
                <button onClick={this.set5}> 5 </button>

            </tr>
        );
    }
}


export default Appuser;