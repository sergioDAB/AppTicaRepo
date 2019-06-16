import React, { Component } from 'react';
import Application from './Application';
import Appuser from './Appuser';
import store from "./store.js";
import '../css/Application.css';


class Applications extends Component {
    constructor(){
        super();
        this.state= {
            view: "apps",
            user: "user",
            appRows: [{"idApp":1,"nombre":"ap1", "stars":1}],
            typeUser: store.getState().typeUser

        };

        this.renderRows=this.renderRows.bind(this);
        this.getApps = this.getApps.bind(this);

        this.getApps();

        store.subscribe(()=>{
            this.setState({
                view: store.getState().view,
                user: store.getState().user,
                appRows:store.getState().appRows,
                typeUser:store.getState().typeUser
            });
        });
    }

    putApp(id,nombre,stars){
        if(store.getState().typeUser === "1"){
            return(
                <Appuser id = {id} nombre = {nombre} stars = {stars} key = {id}/>
            )
        }else{
            return(
                <Application id = {id} nombre = {nombre} stars = {stars} key = {id}/>
            )
        }

    }

    getApps(){
        let url = 'http://localhost:8080/apps';

        fetch(url
        ).then(res => res.json())
            .catch(error => console.error('Error:', error))
            .then(response =>{store.dispatch({
                type:"SET_APPS",
                appRows: response.body
            });
            console.log(response.body)
            });//this.dataRows = response )

    }

    renderRows(dataRows) {

        let applicationList = [];
        for (let i = 0; i < dataRows.length; i++) {
            console.log(dataRows[i].idApp+ dataRows[i].nombre+ dataRows[i].stars);
            applicationList.push(this.putApp(dataRows[i].idApp, dataRows[i].nombre, dataRows[i].stars))
        }

        return applicationList;
    }


    render(){
    return(
        <div>
            <h2> Applications</h2>
            <table>
                <thead>
                <tr className="tabHeader">
                    <th> Id app</th>
                    <th> nombre</th>
                    <th> estrellas</th>
                </tr>
                </thead>
                <tbody>
                {this.renderRows(this.state.appRows)}
                </tbody>
            </table>
        </div>

        );
    }
}

export default Applications;