package com.example.flimbase.view


import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.Toast

import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.flimbase.remote.ApiClient
import com.example.flimbase.remote.Network
import com.example.flimbase.remote.ResponseModel
import com.example.flimbase.remote.ResultModel
import com.example.flimbase.R
import kotlinx.android.synthetic.main.fragment_home.*
import retrofit2.Call
import retrofit2.Response


class HomeFragment : Fragment(R.layout.fragment_home) {

    lateinit var listData : List<ResultModel>
    private var Recycler_all_arival : RecyclerView? = null



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Recycler_all_arival = view.findViewById(R.id.new_arrival_recycler)
        MovieApiCall()
        refreshapp()



    }

    private fun MovieApiCall() {
    var apiClient = Network.getInstance().create(ApiClient::class.java)
        apiClient.getMovie()
            .enqueue(object : retrofit2.Callback<ResponseModel>{
                override fun onResponse(call: Call<ResponseModel>, response: Response<ResponseModel>) {
                    response.body()?.run {
                        listData = results
                        setAdapter()
                    }
                }

                override fun onFailure(call: Call<ResponseModel>, t: Throwable) {
                    Log.d("Abhishek", "onFailure: "+t.message)
                }

            })
    }

    private fun refreshapp(){
        swiperToRefresh.setOnRefreshListener {
            Toast.makeText(context,"Page Refreshed" , Toast.LENGTH_SHORT).show()
        }
    }

    private fun setAdapter() {
        val linearLayoutManager =
            LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        val allArrivalAdapter = NewMovieArrivalAdapter(listData)
        Recycler_all_arival!!.adapter = allArrivalAdapter
        Recycler_all_arival!!.layoutManager = linearLayoutManager
    }

}




