package com.example.runninglist.Retrofits

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface ApiInterface {

    @GET("Home/GetTaskSingle/{id}")
    fun getTask(id: Int):Call<UserTaskItem>
    @GET("Home/GetAllTask")
    fun getAllTask() : Call<List<UserTaskItem>>
    companion object{
        var BASE_URL ="https://localhost:7223/"

        fun create(): ApiInterface{
            val retrofit = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BASE_URL)
                .build()
            return retrofit.create(ApiInterface::class.java)

        }
    }
}