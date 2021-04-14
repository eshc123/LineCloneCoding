package org.standardj.rine.database

import androidx.annotation.WorkerThread
import kotlinx.coroutines.flow.Flow

class FriendRepository(private val friendDao: FriendDao){

    val allFriends: Flow<List<Friend>> = friendDao.getAll()

    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun insert(friend: Friend) {
        friendDao.insert(friend)
    }
}