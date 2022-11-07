package com.happiestminds.androidthreading

import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.view.View
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import kotlinx.coroutines.*
import kotlin.concurrent.thread

class MainActivity : AppCompatActivity() {
    lateinit var resultTextView: TextView
    lateinit var pBar : ProgressBar
    lateinit var t1 : Thread
    lateinit var job: Job

    val handler = Handler()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        resultTextView = findViewById(R.id.resultT)
        pBar = findViewById(R.id.progressBar)
    }

    fun startClick(view: View) {

       doWithCoroutine()

    }

    private fun doWithCoroutine() {
        val data = arrayOf("Coroutines", "dont", "add", "new thread")

        pBar.visibility = View.VISIBLE
        resultTextView.text = "Please wait.."

        job = CoroutineScope(Dispatchers.Default).launch {
            delay(5000)
            val joined = joinStrs(*data)

            CoroutineScope(Dispatchers.Main).launch {
                resultTextView.text = joined
                pBar.visibility = View.INVISIBLE
            }

//            runOnUiThread {
//                Toast.makeText(this@MainActivity,
//                    "Coroutine $joined", Toast.LENGTH_LONG).show()
//                resultTextView.text = joined
//                pBar.visibility = View.INVISIBLE
//            }

        }

    }

    private fun doWithThreads() {
        val data = arrayOf("Android", "iOS")
        pBar.visibility = View.VISIBLE
        resultTextView.text = "Please wait.."

        t1 = thread {
            Thread.sleep(5000)
            val joined = joinStrs(*data)
            Log.d("MainActivity", "Result: $joined")
//            runOnUiThread {
//                resultTextView.text = joined
//                pBar.visibility = View.INVISIBLE
//
//            }

            // handler should be created in main thread
            handler.post {
                resultTextView.text = joined
                pBar.visibility = View.INVISIBLE
            }
        }
    }

    private fun doWithAsyncTask() {
        val task = MyTask()
        task.execute("John", "Merry")
    }

    fun joinStrs(vararg strs: String): String{
        var result = ""
        for (str in strs){
            result += str.uppercase() + "-"
        }

        return result
    }

    inner class MyTask : AsyncTask<String, Void, String>() {

        override fun onPreExecute() {
            super.onPreExecute()
            pBar.visibility = View.VISIBLE
            resultTextView.text = "Please wait.."
        }

        override fun doInBackground(vararg params: String): String {
            // executed by background thread
            // DO NOT access any UI Elements
            Thread.sleep(5000)
            val joined = joinStrs(*params)
            Log.d("MyTask", "doInbackground: Result: $joined")
            return joined
        }

        // executed on Main Thread
        override fun onPostExecute(result: String) {
            super.onPostExecute(result)
            resultTextView.text = "$result"
            pBar.visibility = View.INVISIBLE
        }
    }

    fun stopClick(view: View) {
        if (job.isActive){
            job.cancel()
            pBar.visibility = View.INVISIBLE
            resultTextView.text = "Job Cancelled.."
        }

    }

}