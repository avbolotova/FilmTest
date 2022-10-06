package com.example.filmtest.view.main

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.filmtest.MAIN
import com.example.filmtest.R
import com.example.filmtest.model.Item
import kotlinx.android.synthetic.main.fragment_detailed.view.*

class MainAdapter: RecyclerView.Adapter<MainAdapter.MyViewHolder>() {

    private var listMovies = emptyList<Item>()

    class MyViewHolder(view: View): RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.each_item, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.itemView.dtv_title_detailed.text = listMovies[position].title

        Glide.with(MAIN)
            .load(listMovies[position].poster_path)
            .centerCrop()
            .placeholder(R.drawable.item_divider)
            .into(holder.itemView.img_detailed)
    }

    override fun getItemCount(): Int {
        return listMovies.size
    }
    fun setList(list: List<Item>){
        listMovies = list
        notifyDataSetChanged()

    }
}