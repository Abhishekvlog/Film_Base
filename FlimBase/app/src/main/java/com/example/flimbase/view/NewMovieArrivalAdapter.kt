package com.example.flimbase.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.flimbase.remote.ResultModel
import com.example.flimbase.R

class NewMovieArrivalAdapter(var action : List<ResultModel>):RecyclerView.Adapter<NewMovieArrivalViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewMovieArrivalViewHolder {
        var view = LayoutInflater.from(parent.context).inflate(R.layout.item_layout,parent,false)
        return NewMovieArrivalViewHolder(view)
    }

    override fun onBindViewHolder(holder: NewMovieArrivalViewHolder, position: Int) {
        val datalist : ResultModel = action[position]
        holder.setData(datalist)
    }

    override fun getItemCount(): Int {
        return action.size
    }
}