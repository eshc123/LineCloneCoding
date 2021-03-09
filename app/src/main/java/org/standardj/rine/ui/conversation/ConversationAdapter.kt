package org.standardj.rine.ui.conversation

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import org.standardj.rine.R

class ConversationAdapter(private val itemlist : Array<Conversation>) : RecyclerView.Adapter<ConversationAdapter.ViewHolder>() {
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val name : TextView
        val time : TextView
        val content : TextView
        val image : ImageView

        init {
            // Define click listener for the ViewHolder's View.
            name = view.findViewById(R.id.item_conversation_name)
            time = view.findViewById(R.id.item_conversation_time)
            content = view.findViewById(R.id.item_conversation_content)
            image = view.findViewById(R.id.item_conversation_image)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ConversationAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.item_conversation, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ConversationAdapter.ViewHolder, position: Int) {
        holder.name.text = itemlist.get(position).name
        holder.time.text = itemlist.get(position).time
        holder.content.text = itemlist.get(position).content
        //holder.image. = itemlist.get(position).name

    }

    override fun getItemCount(): Int {
        return itemlist.size
    }
}