package com.example.stopwatch

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.SystemClock
import android.util.Log
import android.widget.Button
import android.widget.Chronometer

class MainActivity : AppCompatActivity() {

    //make a classwide static constant in Kotlin
    companion object{
        // all your static constant go here
        val TAG = "MainActivity"
    }
    private lateinit var startButton: Button
    private lateinit var stopwatch: Chronometer
    private lateinit var resetButton: Button




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.d(TAG, "onCreate: ")
        startButton = findViewById(R.id.button_main_start)
        stopwatch = findViewById(R.id.chronometer_main_stopwatch)
        resetButton = findViewById(R.id.button_main_restart)




        var checked = false
       // var value = 0
        var b = 0.toLong();




        // r-(s-b)

        startButton.setOnClickListener {
            if(!checked){
                stopwatch.base = b + SystemClock.elapsedRealtime()
                stopwatch.start()
                startButton.text = "STOP"
                checked = true}
            else{
                b = stopwatch.base-SystemClock.elapsedRealtime()
                stopwatch.stop()
                startButton.text = "START"
                checked = false}


        }
        resetButton.setOnClickListener {

             stopwatch.base = SystemClock.elapsedRealtime()
             stopwatch.stop()
            startButton.text = "Start"
            checked = false
        }

        }

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "onStart: ")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "onResume: ")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "onPause: ")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "onStop: ")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "onDestroy: ")
    }






    }


