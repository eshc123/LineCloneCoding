package org.standardj.rine.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "friend")
class Friend(
        @PrimaryKey val fid: String,
        @ColumnInfo(name = "nickname") val nickname: String?
)