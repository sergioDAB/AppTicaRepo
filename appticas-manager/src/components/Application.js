import React, { Component } from 'react';

import store from "./store.js";
import '../css/Application.css';


class Application extends Component {

    constructor(props){
        super(props);
        this.state={
            user: store.getState().user,
            view: store.getState().view
        };

        store.subscribe(()=>{
            this.setState({
                user: store.getState().user,
                view: store.getState().view
            });
        })

    }

    render() {
        return (
            <tr>
                <th className="rowlabel">{this.props.id}</th>
                <th className="rowlabel">{this.props.nombre}</th>
                <th className="rowlabel">{this.props.stars}</th>
            </tr>
        );
    }
}


export default Application;