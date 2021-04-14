package org.standardj.rine.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Database(entities = [Friend::class], version = 1)
abstract class FriendDatabase : RoomDatabase() {
    abstract fun friendDao(): FriendDao

    private class FriendDatabaseCallback(private val scope: CoroutineScope) :RoomDatabase.Callback(){
        override fun onCreate(db: SupportSQLiteDatabase) {
            super.onCreate(db)
            INSTANCE?.let { database ->
                scope.launch {
                    var friendDao = database.friendDao()

                    //friendDao.
                }
            }
        }
    }

    companion object {
        // Singleton prevents multiple instances of database opening at the
        // same time.
        private var INSTANCE: FriendDatabase? = null

        fun getDatabase(context: Context, scope: CoroutineScope): FriendDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                        context.applicationContext,
                        FriendDatabase::class.java,
                        "friend_database"
                )
                        .addCallback(FriendDatabaseCallback(scope))
                        .build()
                INSTANCE = instance
                // return instance
                instance
//
//
//
//
//            if (INSTANCE == null) {
//                INSTANCE = Room.databaseBuilder(
//                        context.applicationContext,
//                        FriendDatabase::class.java,
//                        "friend-database"
//                )
//                        .allowMainThreadQueries()
//                        .build()
//            }
//            return INSTANCE
            }
        }
    }
}
