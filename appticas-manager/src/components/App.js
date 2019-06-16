import React, {Component} from 'react';


import '../css/App.css';
import '../css/login.css';
import  store from "./store.js";

import Login from "./Login.js";
import Applications from "./Applications";

class  App extends Component {
  constructor(props){
    super(props);
    this.state={
      view: "main",
      user:''
    };

    store.subscribe(()=>{
      this.setState({
        view:store.getState().view
      })
    });
  }

  changeView(){
    store.dispatch({
      type: "SET_VIEW",
      view : 'login'
    })
  }

  renderMainPage(){
    return (
        <div className="App">
          <header className="App-header">
            Welcome to Applications Ticas
            <button  onClick={this.changeView} className="acceptButton">Go to Applications</button>
          </header>
        </div>
    );
  }


  render(){
    if(this.state.view === "main"){
      return this.renderMainPage()
    }
    else if (this.state.view === "login"){
      return <Login/>
    }
    else if(this.state.view === "apps"){
      return <Applications/>
    }else{
      return this.renderMainPage();
    }
  }


}

export default App;
