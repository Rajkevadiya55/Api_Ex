package com.example.api_ex

import android.telecom.Call
import retrofit2.http.GET

interface ApiInterface {


@GET("users")
fun getusers(): retrofit2.Call<Users>

}