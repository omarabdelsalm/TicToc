package com.alshobky.tictactoc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import com.google.android.material.bottomappbar.BottomAppBar

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
    fun butClik(view :View){
        val buSelected=view as Button
        var butId=0
        when(buSelected.id){
            R.id.bu1->butId=1
            R.id.bu2->butId=2
            R.id.bu3->butId=3
            R.id.bu4->butId=4
            R.id.bu5->butId=5
            R.id.bu6->butId=6
            R.id.bu7->butId=7
            R.id.bu8->butId=8
            R.id.bu9->butId=9
        }
        Log.d("select :",buSelected.id.toString())
        Log.d("select :",butId.toString())
    }
}