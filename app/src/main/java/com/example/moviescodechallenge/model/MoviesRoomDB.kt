package com.example.moviescodechallenge.model

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Data::class], version = 1)
abstract class MoviesRoomDB  : RoomDatabase(){
    abstract val movieDao : MoviesDao

    companion object{

        @Volatile
        private var INSTANCE: MoviesRoomDB? = null

        fun getDatabase(context: Context) : MoviesRoomDB {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    MoviesRoomDB::class.java,
                    "moviedb"

                ).build()
                INSTANCE = instance

                return instance
            }

        }
    }
}
