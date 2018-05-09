package com.example.developeramit.newsample

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import com.example.developeramit.newsample.data.ReturnData
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerViewMain.layoutManager = LinearLayoutManager(this)


        val url = "https://api.letsbuildthatapp.com/youtube/home_feed"

        val requestQueue = Volley.newRequestQueue(this)

        val jsonRequestObject = JsonObjectRequest(Request.Method.GET, url, null,
                Response.Listener { response ->
                    println(response.toString())
                    val gson = Gson()

                    val returnData: ReturnData = gson.fromJson(response.toString(), ReturnData::class.java)

                    println("size: " + returnData.videos.size)

                    recyclerViewMain.adapter = MainAdapter(returnData, this)
                },
                Response.ErrorListener { error ->

                })

        requestQueue.add(jsonRequestObject)

    }

}

/*
https://api.letsbuildthatapp.com/youtube/home_feed
{"user":{"id":1,"name":"Brian Voong","username":"brianvoong"},"videos":[{"id":1,"name":"Instagram Firebase - Learn How to Create Users, Follow, and Send Push Notifications","link":"https://www.letsbuildthatapp.com/course/instagram-firebase","imageUrl":"https://letsbuildthatapp-videos.s3-us-west-2.amazonaws.com/04782e30-d72a-4917-9d7a-c862226e0a93","numberOfViews":20000,"channel":{"name":"Lets Build That App","profileImageUrl":"https://letsbuildthatapp-videos.s3-us-west-2.amazonaws.com/dda5bc77-327f-4944-8f51-ba4f3651ffdf","numberOfSubscribers":100000}},{"id":2,"name":"Intermediate Training Core Data","link":"https://www.letsbuildthatapp.com/course/intermediate-training-core-data","imageUrl":"https://letsbuildthatapp-videos.s3-us-west-2.amazonaws.com/0736fecb-5b88-483b-a83d-ca2a5a6d93f9","numberOfViews":5000,"channel":{"name":"Lets Build That App","profileImageUrl":"https://letsbuildthatapp-videos.s3-us-west-2.amazonaws.com/dda5bc77-327f-4944-8f51-ba4f3651ffdf","numberOfSubscribers":100000}},{"id":3,"name":"Kindle Basic Training","link":"https://www.letsbuildthatapp.com/basic-training","imageUrl":"https://letsbuildthatapp-videos.s3-us-west-2.amazonaws.com/114bec2f-fbfd-4b13-91de-907fe57c6e37","numberOfViews":7500,"channel":{"name":"Lets Build That App","profileImageUrl":"https://letsbuildthatapp-videos.s3-us-west-2.amazonaws.com/dda5bc77-327f-4944-8f51-ba4f3651ffdf","numberOfSubscribers":100000}}]}

 */