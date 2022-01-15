package com.example.corona

import android.view.LayoutInflater
import android.view.OnReceiveContentListener
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class Adaptor(val item:ArrayList<String>,private val  listener:NewsItemCliked): RecyclerView.Adapter<viewHolder>() {
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
        holder.titleView.text=currentItem
    }

    override fun getItemCount(): Int {
         return item.size
    }

}
class viewHolder(itemView: View):RecyclerView.ViewHolder(itemView){

    val titleView:TextView=itemView.findViewById(R.id.title)
}

interface NewsItemCliked{

    fun onItemClicked(item:String)
}