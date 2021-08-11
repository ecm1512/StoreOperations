package com.educode.examentottus.data.source

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.educode.examentottus.data.source.utils.Converters
import com.educode.examentottus.domain.model.Member
import com.educode.examentottus.domain.model.Team
import com.educode.examentottus.domain.model.User

@Database(entities = [User::class, Team::class, Member::class], version = 3)
@TypeConverters(
    Converters::class
)
abstract class TottusDatabase : RoomDatabase(){
    companion object {
        fun build(context: Context) = Room.databaseBuilder(
            context,
            TottusDatabase::class.java,
            "TottusDb"
        ).fallbackToDestructiveMigration().allowMainThreadQueries().build()
    }

    abstract fun teamDao() : TeamDao

    abstract fun userDao() : UserDao

    abstract fun memberDao() : MemberDao
}