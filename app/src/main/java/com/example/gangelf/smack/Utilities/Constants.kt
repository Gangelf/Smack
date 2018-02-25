package com.example.gangelf.smack.Utilities

/**
 * Created by Gangelf on 2/24/2018.
 */
const val BASE_URL = "http://10.0.2.2:3005/v1/"
//const val BASE_URL = "https://chattychatal.herokuapp.com/v1/"
const val URL_REGISTER = "${BASE_URL}account/register"
const val URL_LOGIN = "${BASE_URL}account/login"
const val URL_CREATE_USER = "${BASE_URL}user/add"
const val URL_GET_USER = "${BASE_URL}user/byEmail/"

//Broadcast
const val BROADCAST_USER_DATA_CHAANGE = "BROADCAST_USER_DATA_CHAANGE"