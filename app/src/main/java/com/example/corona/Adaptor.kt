package com.example.corona

import android.view.LayoutInflater
import android.view.OnReceiveContentListener
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class Adaptor(private val  listener:NewsItemCliked): RecyclerView.Adapter<viewHolder>() {

    private val item:ArrayList<News> = ArrayList()


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewHolder {
           val view=LayoutInflater.from(parent.context).inflate(R.layout.item_news,parent,false)
   val view_=viewHolder(view)
        view.setOnClickListener{

            listener.onItemClicked(item[view_.bindingAdapterPosition])
        }

        return view_
    }

    override fun onBindViewHolder(holder: viewHolder, position: Int) {


        val currentItem=item[position]
        holder.titleView.text=currentItem.title
        holder.author.text = currentItem.author
        Glide.with(holder.itemView.context).load(currentItem.imageUrl).into(holder.image)
    }

    override fun getItemCount(): Int {
         return item.size
    }

fun updateNews(updatedNews: ArrayList<News>) {

    item.clear()
    item.addAll(updatedNews)

     notifyDataSetChanged()


}


}
class viewHolder(itemView: View):RecyclerView.ViewHolder(itemView){

    val titleView:TextView=itemView.findViewById(R.id.title)
    val image:ImageView = itemView.findViewById(R.id.image)
    val author: TextView = itemView.findViewById(R.id.author)
}

interface NewsItemCliked{

    fun onItemClicked(item:News)
}