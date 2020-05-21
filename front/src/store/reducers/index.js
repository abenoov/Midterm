import {combineReducers} from "redux";
import authReducer from "./authReducer";
import billReducer from "./billReducer";


export default combineReducers({
    auth: authReducer,
    bills: billReducer
})