import {createStore} from 'redux';

let default_state = {
    view: 'main',
    user: 'user',
    typeUser: 'user',
    userId: ' ',
    appsRows: [{"id_app":1,"nombre":"ap1", "stars":1},{"id_app":2,"nombre":"ap2", "stars":2}]
};

const selector = (state, action) => {
    if(action.type === "SET_USER"){
        return{
            ...state,
            user: action.user,
            typeUser: action.typeUser,
            userId: action.userId
        }
    }
    else if(action.type === "SET_VIEW"){
        return{
            ...state,
            view: action.view,
            typeUser:action.typeUser,
            user:action.user,
            userId: action.userId
        }
    }
    else if(action.type === "SET_APPS"){
        return{
            ...state,
            appRows: action.appRows
        }
    }

};

export default createStore(selector, default_state);