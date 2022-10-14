package com.example.runninglist

import android.app.Application
import com.example.runninglist.data.AppDataBase
import com.example.runninglist.data.UserTaskRepository
import com.example.runninglist.data.UserTaskRepositoryImpl

class App: Application() {
    private lateinit var  dataBase: AppDataBase

    lateinit var  repository: UserTaskRepository
    override fun onCreate() {
        super.onCreate()
        dataBase =AppDataBase.buildDatabase(applicationContext, NAME_DATABASE)
        repository = UserTaskRepositoryImpl(dataBase.TaskDao())
    }
    companion object{

        private const val NAME_DATABASE ="TaskDataBase"
    }
}