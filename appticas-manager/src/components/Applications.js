import React, { Component } from 'react';
import Application from './Application';
import store from "./store.js";


class Applications extends Component {
    constructor(){
        super();
        this.state= {
            view: "apps",
            user: "user",
            appRows: [{"idApp":1,"nombre":"ap1", "stars":1},{"idApp":2,"nombre":"ap2", "stars":2}]

        };

        this.renderRows=this.renderRows.bind(this);

        store.subscribe(()=>{
            this.setState({
                view: store.getState().view,
                user: store.getState().user,
                appRows:store.getState().appRows
            });
        });
    }

    putApp(id,nombre,stars){
        return(
            <Application id = {id} nombre = {nombre} stars = {stars} key = {id}/>
        )
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
            <label> Applications</label>
            <button onClick={this.getApps}>get apps</button>
            <table>
                <tbody>
                {this.renderRows(this.state.appRows)}
                </tbody>
            </table>
        </div>

        );
    }
}

export default Applications;