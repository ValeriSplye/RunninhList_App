package com.example.runninglist.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.runninglist.AboutTask
import com.google.gson.internal.JavaVersion

@Database(
    entities = [AboutTask::class], version = 1
)
abstract class AppDataBase :RoomDatabase() {
    abstract fun TaskDao():UserTaskDao

    companion object{
       fun buildDatabase(context: Context,dbName:String): AppDataBase{
           return Room.databaseBuilder(context,AppDataBase::class.java,dbName).build()
       }
    }
}