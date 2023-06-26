package com.alpesh1.apivolley

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.android.volley.Request
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import org.json.JSONArray

class MainActivity : AppCompatActivity() {

    var userList = ArrayList<PostModel>()
    var url = "https://jsonplaceholder.typicode.com/posts"
    private val TAG = "MainActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var request = StringRequest(Request.Method.GET, url, {

            var array = JSONArray(it)

            for (i in 0 ..array.length()-1){
                var obj = array.getJSONObject(i)


                var id = obj.getInt("id")
                var title = obj.getString("title")
                var body = obj.getString("body")
                var userId = obj.getInt("userId")

                var model = PostModel(id, title, body , userId)
                userList.add(model)
            }

            for (user in userList){
                Log.e(TAG, "onCreate: ============${user.id}", )
                Log.e(TAG, "onCreate: ============${user.title}", )
                Log.e(TAG, "onCreate: ============${user.body}", )
                Log.e(TAG, "onCreate: ============${user.userId}", )
                Log.e(TAG, "onCreate: ---------------------------", )
            }

        }, {

        })

        var que = Volley.newRequestQueue(this)
        que.add(request)

    }
}