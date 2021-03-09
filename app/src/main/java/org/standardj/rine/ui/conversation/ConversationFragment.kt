package org.standardj.rine.ui.conversation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import kotlinx.android.synthetic.main.fragment_conversation.*
import org.standardj.rine.R

class ConversationFragment : Fragment() {

    private lateinit var conversationViewModel: ConversationViewModel

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        conversationViewModel =
                ViewModelProvider(this).get(ConversationViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_conversation, container, false)
//        val textView: TextView = root.findViewById(R.id.text_conversation)
//        conversationViewModel.text.observe(viewLifecycleOwner, Observer {
//            textView.text = it
//        })
        return root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val list = arrayOf(Conversation(1,"친구1","오후 5:00","안녕하세요!!"),Conversation(2,"친구2","1.25","안녕하세요!!"))
        val adapter = ConversationAdapter(list)
        conversation_recyclerview.adapter = adapter
    }
}