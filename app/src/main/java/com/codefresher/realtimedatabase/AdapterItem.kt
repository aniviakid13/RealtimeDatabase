package com.codefresher.realtimedatabase

import android.content.Context
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.squareup.picasso.Picasso

class AdapterItem(private val context: Context, private val itemList: ArrayList<ItemModel>) :
    RecyclerView.Adapter<AdapterItem.MyViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(
            R.layout.item,
            parent, false
        )
        return  MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val itemP = itemList[position].img
        holder.title.text = itemList[position].title
        Picasso.get().load(itemP).into(holder.image)


    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val image: ImageView = itemView.findViewById(androidx.appcompat.R.id.image)
        val title: TextView = itemView.findViewById(R.id.txtTitle)
    }
}