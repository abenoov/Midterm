import axios from 'axios'
import jwt_decode from 'jwt-decode'

import setAuthToken from "../../common/setAuthToken";
import {ADD_BILL, GET_BILLS} from "./types";

const qs = require('querystring')

export const getBills = () => dispatch => {
    axios.get('/bills/')
        .then(res => {
            const payload = res.data

            console.log(payload)

            dispatch({
                type: GET_BILLS,
                payload: payload
            })
        })
        .catch(err => {
            console.log(err)
        })
}

export const addBill = (bill) => dispatch => {
    axios.post('/bills/newBill', bill)
        .then(res => {
            const payload = res.data.

            console.log("payload?")

            dispatch({
                type: ADD_BILL,
                payload: payload
            })
        })
        .catch(err => {
            console.log(err)
        })
        .finally( e =>{

            console.log("Hohlj")
        }      )
}