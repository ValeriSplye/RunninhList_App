package com.example.runninglist.data

import com.example.runninglist.AboutTask
import com.example.runninglist.CompletedTask

class UserTaskRepositoryImpl(private val UserTaskdao : UserTaskDao): UserTaskRepository {
    override suspend fun insert(task: AboutTask) {
      UserTaskdao.insert(task)
    }

    override suspend fun getAllTask() = UserTaskdao.getAllTask()

    override suspend fun update(task: AboutTask) {
        UserTaskdao.update(task)
    }

    override suspend fun getAllCompletedTask() = UserTaskdao.getAllCompletedTask()

    override suspend fun delete(task: AboutTask) {
        UserTaskdao.delete(task)
    }

    override suspend fun DeleteTask() {
        UserTaskdao.DeleteTask()
    }

}