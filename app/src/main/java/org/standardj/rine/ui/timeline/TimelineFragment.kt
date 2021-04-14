package org.standardj.rine.ui.timeline

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.genie.wanttogo.ui.home.Feed
import com.genie.wanttogo.ui.home.FeedAdapter
import kotlinx.android.synthetic.main.fragment_conversation.*
import kotlinx.android.synthetic.main.fragment_timeline.*
import org.standardj.rine.R
import org.standardj.rine.ui.conversation.Conversation
import org.standardj.rine.ui.conversation.ConversationAdapter

class TimelineFragment : Fragment() {

    private lateinit var timelineViewModel: TimelineViewModel

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        timelineViewModel =
                ViewModelProvider(this).get(TimelineViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_timeline, container, false)
       // val textView: TextView = root.findViewById(R.id.text_timeline)
//        timelineViewModel.text.observe(viewLifecycleOwner, Observer {
//            textView.text = it
//        })
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val list = arrayOf(Story(1,"스토리 추가"), Story(2,"브라운"),Story(3,"코니"))
        val adapter = StoryAdapter(list)
        timeline_story_recyclerview.layoutManager = LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false)
        timeline_story_recyclerview.adapter = adapter


        val b = Feed("test1","2021년 3월 30일",R.mipmap.ic_launcher_round,"hello!",R.drawable.ic_banner_foreground)
        val c = Feed("test2","2021년 3월 30일",R.mipmap.ic_launcher_round,"test",R.drawable.ic_banner_foreground)
        val feedlist : Array<Feed> = arrayOf(b,c)
        val feedadapter = FeedAdapter(feedlist)
        timeline_feed_recyclerview.adapter = feedadapter
    }
}