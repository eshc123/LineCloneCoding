package com.genie.wanttogo.ui.home

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import org.standardj.rine.R

class FeedAdapter(val itemlist : Array<Feed>): RecyclerView.Adapter<FeedAdapter.ViewHolder>() {
    inner class  ViewHolder(itemView : View): RecyclerView.ViewHolder(itemView) {
        val image : ImageView
        val name : TextView
        val date : TextView
        val userAvatar : ImageView
        val content : TextView
        init {
            image = itemView.findViewById(R.id.item_feed_image)
            name = itemView.findViewById(R.id.item_feed_name)
            date = itemView.findViewById(R.id.item_feed_date)
            userAvatar = itemView.findViewById(R.id.item_feed_title_image)
            content = itemView.findViewById(R.id.item_feed_text)

//            itemView.setOnClickListener {
//                val position : Int = adapterPosition
//                val intent : Intent = Intent(itemView.context,DetailActivity::class.java )
//                intent.putExtra("image",itemlist.get(position).image)
//                itemView.context.startActivity(intent)
//            }
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FeedAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_feed,parent,false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: FeedAdapter.ViewHolder, position: Int) {
        Glide.with(holder.itemView.context).load(itemlist.get(position).image).into(holder.image)
        holder.name.setText(itemlist.get(position).name)
        holder.date.setText(itemlist.get(position).date)
        holder.content.setText(itemlist.get(position).content)
        Glide.with(holder.itemView.context).load(itemlist.get(position).userAvatar).into(holder.userAvatar)

    }

    override fun getItemCount(): Int {
        return itemlist.size
    }
}