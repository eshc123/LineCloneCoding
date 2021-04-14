package org.standardj.rine.database

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface FriendDao {
    @Query("SELECT * FROM friend")
    fun getAll(): Flow<List<Friend>>

    @Query("SELECT * FROM friend WHERE fid IN (:friendIds)")
    fun loadAllByIds(friendIds: IntArray): Flow<List<Friend>>

    @Query("SELECT * FROM friend WHERE nickname = :nickname")
    fun findByNickname(nickname: String): Friend

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(friend: Friend)

    @Delete
    fun delete(friend: Friend)
}