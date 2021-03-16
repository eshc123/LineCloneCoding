package org.standardj.rine.ui.timeline

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import org.standardj.rine.R

class StoryAdapter(private val itemlist : Array<Story>) : RecyclerView.Adapter<StoryAdapter.ViewHolder>() {
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val name : TextView
        val image : ImageView

        init {
            // Define click listener for the ViewHolder's View.
            name = view.findViewById(R.id.item_story_name)
            image = view.findViewById(R.id.item_story_image)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.item_story, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.name.text = itemlist.get(position).name
        //holder.image. = itemlist.get(position).name

    }

    override fun getItemCount(): Int {
        return itemlist.size
    }
}