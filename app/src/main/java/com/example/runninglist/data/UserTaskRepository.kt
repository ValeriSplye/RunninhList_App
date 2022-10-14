package com.example.runninglist.data

import com.example.runninglist.AboutTask
import com.example.runninglist.CompletedTask

interface UserTaskRepository {
    suspend fun  insert(task:AboutTask)

    suspend fun getAllTask() : List<AboutTask>

    suspend fun update(task: AboutTask)

    suspend fun getAllCompletedTask() :List<AboutTask>

    suspend fun delete(task: AboutTask)

    suspend fun DeleteTask()
}