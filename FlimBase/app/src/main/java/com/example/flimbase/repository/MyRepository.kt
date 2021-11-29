package com.example.flimbase.repository

import com.example.flimbase.remote.ApiClient
import com.example.flimbase.remote.Network
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class MyRepository {
    private val retrofitAPI = Network.getInstance().create(ApiClient::class.java)
    private val token = "c786d51042a6a278e561a6b55e90ff21"

    fun getRemoteMovie(){
        CoroutineScope(Dispatchers.IO).launch {
            val response =retrofitAPI.getMovie()
        }
    }

}