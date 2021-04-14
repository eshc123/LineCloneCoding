package org.standardj.rine.ui.home

import android.app.Application
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob
import org.standardj.rine.database.FriendDatabase
import org.standardj.rine.database.FriendRepository

class HomeApplication : Application() {
    val applicationScope = CoroutineScope(SupervisorJob())
    val database by lazy {FriendDatabase.getDatabase(this,applicationScope)}
    val repository by lazy {FriendRepository(database.friendDao())}
}