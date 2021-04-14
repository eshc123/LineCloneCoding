package org.standardj.rine.ui.home

import android.view.LayoutInflater
//import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import org.standardj.rine.R
import org.standardj.rine.database.Friend
import org.standardj.rine.databinding.ItemFriendBinding

class FriendAdapter(private val itemlist : List<Friend>) : RecyclerView.Adapter<FriendAdapter.ViewHolder>() {
    class ViewHolder(val binding: ItemFriendBinding) : RecyclerView.ViewHolder(binding.root) {
//        val name : TextView
        //val image : ImageView
//        init {
//            // Define click listener for the ViewHolder's View.
//            name = view.findViewById(R.id.item_friend_name)
//            //image = view.findViewById(R.id.item_friend_image)
//        }
        fun bind(item : Friend){
            binding.friend = item
            binding.executePendingBindings()
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        //val binding = DataBindingUtil.inflate(LayoutInflater.from(parent.context),parent,false)
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ItemFriendBinding.inflate(layoutInflater)
//        val view = LayoutInflater.from(parent.context)
//                .inflate(R.layout.item_friend, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(itemlist[position])
    //        holder.name.text = itemlist.get(position).nickname
        //Glide.with(holder.itemView.context).load(itemlist.get(position).image).into(holder.image)
        //holder.image. = itemlist.get(position).name
    }

    override fun getItemCount(): Int {
        return itemlist.size
    }
}