package org.standardj.rine

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import org.standardj.rine.database.Friend
import org.standardj.rine.database.FriendDatabase
import org.standardj.rine.ui.home.HomeApplication
import org.standardj.rine.ui.home.HomeViewModel
import org.standardj.rine.ui.home.HomeViewModelFactory
import java.time.LocalDateTime

class MainActivity : AppCompatActivity() {
//    private val homeViewModel: HomeViewModel by viewModels {
//        HomeViewModelFactory((application as HomeApplication).repository)
//    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val navView: BottomNavigationView = findViewById(R.id.nav_view)

        val navController = findNavController(R.id.nav_host_fragment)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        val appBarConfiguration = AppBarConfiguration(setOf(
                R.id.navigation_home, R.id.navigation_conversation, R.id.navigation_timeline,R.id.navigation_call))
        //setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)

//        AddFriend(applicationContext)
//        GetFriend(applicationContext)


    }


}


//class AddFriend(val context : Context) : Thread(){
//    override fun run(){
//        val dateAndtime: LocalDateTime = LocalDateTime.now()
//        val friend = Friend("friend$dateAndtime","닉")
//        FriendDatabase.getDatabase(context)!!.FriendDao().insert(friend)
//    }
//}
//class GetFriend(val context : Context) : Thread(){
//    override fun run(){
//        Log.d("databaseget", FriendDatabase.getDatabase(context)!!.FriendDao().getAll().toString())
//    }
//}