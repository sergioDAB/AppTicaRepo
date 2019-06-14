import React, { Component } from 'react';

import store from "./store.js";


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
            <div>
                <label>{this.props.id}</label>
                <label>{this.props.nombre}</label>
                <label>{this.props.stars}</label>

            </div>
        );
    }
}


export default Application;