import {ADD_BILL, GET_BILLS} from "../actions/types";


const initialState = {
    bills: []
}


export default function (state = initialState, action) {
    switch (action.type) {
        case GET_BILLS:
            return {
                ...state,
                bills: action.payload
            }
        case ADD_BILL:
            return {
                ...state,
                bills: [...state.bills, action.payload]
            }
        default:
            return state
    }
}