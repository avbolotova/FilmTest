package com.example.filmtest

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.filmtest.FilmsAdapter.FilmViewHolder

class FilmsAdapter(private val filmList: ArrayList<Films>)
    : RecyclerView.Adapter<FilmViewHolder>(){

    var onItemClick : ((Films) -> Unit)? = null


    class FilmViewHolder(itemView : View) :RecyclerView.ViewHolder(itemView){
        val imageView : ImageView = itemView.findViewById(R.id.imageView)
        val textView : TextView = itemView.findViewById(R.id.descriptionTV)
        val buttonDes : Button = itemView.findViewById(R.id.buttonDes)


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FilmViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.each_item , parent , false)
        return  FilmViewHolder(view)
    }

    override fun onBindViewHolder(holder: FilmViewHolder, position: Int) {
        val films = filmList[position]
        holder.imageView.setImageResource(films.image)
        holder.textView.text = films.name
        holder.buttonDes.setOnClickListener {
            onItemClick?.invoke(filmList[position])
            onItemClick?.apply {
                holder.textView.setTextColor(Color.parseColor("#0000ff"))
            }
        }


    }

    override fun getItemCount(): Int {
        return filmList.size
    }


}
