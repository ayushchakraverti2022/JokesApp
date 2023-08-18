package com.example.kotapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import com.example.kotapp.databinding.ActivityMainBinding
import com.google.gson.JsonObject
import com.google.gson.JsonPrimitive
import com.google.gson.JsonParser
class MainActivity : AppCompatActivity() {
    lateinit var mainBinding: ActivityMainBinding;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainBinding = ActivityMainBinding.inflate(layoutInflater);
        setContentView(mainBinding.root);
         var boojho: String;
         var jane: String  ="";
//        // getcityid
        mainBinding.newjoke.setOnClickListener {


// Instantiate the RequestQueue.
            val queue = Volley.newRequestQueue(this)
            val url = "https://official-joke-api.appspot.com/random_joke"

// Request a string response from the provided URL.

            val stringrequest = JsonObjectRequest(Request.Method.GET,url,null,Response.Listener {
                var sjson = it.toString();
                val jsonobj: JsonObject = JsonParser.parseString(sjson).asJsonObject

                val value1: JsonPrimitive = jsonobj["setup"] as JsonPrimitive;
                val value2: JsonPrimitive = jsonobj["punchline"] as JsonPrimitive;

                 boojho= value1.asString;
                mainBinding.boojho.setText(boojho);
                mainBinding.jaane.setText("");
                 jane = value2.asString;

            },{

            })
// Add the request to the RequestQueue.
            queue.add(stringrequest);

        }
//
      //ends
        mainBinding.newjoke.performClick();

        // usecityid
          mainBinding.parsejoke.setOnClickListener {

              mainBinding.jaane.setText(jane);
          }

        //ends



    }


}