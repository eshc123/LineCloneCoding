package org.standardj.rine.ui.home

import android.app.ActionBar
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.observe
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.room.Room
import kotlinx.android.synthetic.main.fragment_conversation.*
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import org.standardj.rine.MainActivity
import org.standardj.rine.R
import org.standardj.rine.database.Friend
import org.standardj.rine.database.FriendDatabase
import java.time.LocalDateTime

class   HomeFragment : Fragment() {

    private val homeViewModel: HomeViewModel by viewModels {
        HomeViewModelFactory((this.activity?.application as HomeApplication).repository)
    }

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
//        homeViewModel =
//                ViewModelProvider(this).get(HomeViewModel::class.java)

        val root = inflater.inflate(R.layout.fragment_home, container, false)
//        val textView: TextView = root.findViewById(R.id.text_home)
//        homeViewModel.text.observe(viewLifecycleOwner, Observer {
//            textView.text = it
//        })
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val job = Job()
        val uiScope = CoroutineScope(Dispatchers.Main + job)

        homeViewModel.allFriends.observe(viewLifecycleOwner, Observer { friends ->
            friends.let {
                friend_number_card_text.text = it.size.toString()
                var fa = FriendAdapter(it)
                friend_list_recyclerview.layoutManager = LinearLayoutManager(context)
                friend_list_recyclerview.adapter = fa

            }

        })

//        var db : FriendDatabase? = null
//        var friendList : LiveData<List<Friend>>
//        db = FriendDatabase.getDatabase(requireContext())
//        val r = Runnable {
//            friendList = db!!.friendDao().getAll()
//
//            fa.notifyDataSetChanged()
//
//        }
//
//        val thread = Thread(r)
//        thread.start()
//
        addFriend.setOnClickListener {
            val dateAndtime: LocalDateTime = LocalDateTime.now()
            val friend = Friend("friend$dateAndtime","닉$dateAndtime")
            uiScope.launch(Dispatchers.IO){
                homeViewModel.insert(friend)

            }
            //thread.start()
        }


        friend_add.setOnClickListener {
            if(friend_list_recyclerview.visibility == View.VISIBLE)
                friend_list_recyclerview.visibility = View.GONE
            else
                friend_list_recyclerview.visibility = View.VISIBLE
        }

//        addFriend.setOnClickListener {
//            val intent = Intent(activity,AddFriendActivity::class.java)
//            activity?.startActivity(intent)
//        }
        //AddFriend(requireContext())
        //GetFriend(requireContext())
        //val actionBar : ActionBar? = activity?.actionBar
        //actionBar?.setDisplayShowTitleEnabled(false)

//        val db = context?.let {
//            Room.databaseBuilder(
//                it.applicationContext,
//                FriendDatabase::class.java, "friendDB"
//            ).build()
//        }
//
//        db

    }
}
