package com.example.lenovo.internalfile

import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

typealias myIs = Int
class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Log.i("@abc", "Internal Storage $filesDir")
        Log.i("@abc", "Cache Storage $cacheDir")

        store()

        retrieve()

        filesDir.list().forEach {
            Log.i("@abc", "file is $it")
        }

        filesDir.parentFile.list().forEach {
            Log.i("@abc", "file is $it")
        }
    }
    private fun store() {
        openFileOutput("my.txt", Context.MODE_PRIVATE).use {
            it.write("Hello....".toByteArray())
        }
    }

    private fun retrieve() {

        val isp = openFileInput("my.txt")
        val dt = isp.bufferedReader().use {
            it.readLine()
        }
        Log.i("@abc", "Data is $dt")
    }
}
