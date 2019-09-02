package com.pertamine.remote

import com.pertamine.model.User
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface PertamineInterface {

    //post
    @FormUrlEncoded
    @POST("user/login")
    fun loginUser(@Field("email")email:String, @Field("password")password:String): Call<User>

    @FormUrlEncoded
    @POST("user/register")
    fun register(@Field("name")name:String,@Field("email")email:String, @Field("password")password:String): Call<User>

    //get

}