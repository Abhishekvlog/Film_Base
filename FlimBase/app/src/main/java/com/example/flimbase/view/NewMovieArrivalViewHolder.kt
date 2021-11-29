package com.example.flimbase.view

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.flimbase.remote.ResultModel
import kotlinx.android.synthetic.main.item_layout.view.*

class NewMovieArrivalViewHolder(itemView:View ) : RecyclerView.ViewHolder(itemView) {
    fun setData(action : ResultModel){
        itemView.apply {
            action.run {
                itemView.Movie_name.text = action.title
                itemView.Movie_time.text = action.releaseDate
                itemView.Movie_title.text = action.originalLanguage
                Glide.with(Im_poster)
                    .load("https://image.tmdb.org/t/p/w500/"+action.posterPath)
                    .into(Im_poster)
            }
        }
    }
}