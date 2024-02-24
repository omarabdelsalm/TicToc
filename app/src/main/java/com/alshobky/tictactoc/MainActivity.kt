package com.alshobky.tictactoc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast

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
       // Log.d("select :",buSelected.id.toString())
       // Log.d("select :",butId.toString())
        playGame(butId,buSelected)
    }
    //new mothed to play game
        private var activePlayer=1
        private var player1=ArrayList<Int>()
        private var player2=ArrayList<Int>()
        fun playGame(butId:Int,buSelected:Button){
          if(activePlayer==1){
              buSelected.text="X"
              buSelected.setBackgroundResource(R.color.butRed)
              player1.add(butId)
              activePlayer=2
          }else{
              buSelected.text="O"
              buSelected.setBackgroundResource(R.color.greenTack)
              player2.add(butId)
              activePlayer=1
          }
           buSelected.isEnabled=false
            chickWiner()
        }
   var winer=-1
    fun  chickWiner(){
        //row 1
       if(player1.contains(1) && player1.contains(2) && player1.contains(3)) {
           winer=1
       }
        if(player2.contains(1) && player1.contains(2) && player1.contains(3)) {
            winer=2
        }
        //row 2
        if(player1.contains(4) && player1.contains(5) && player1.contains(6)) {
            winer=1
        }
        if(player2.contains(4) && player1.contains(5) && player1.contains(6)) {
            winer=2
        }
        //row 3
        if(player1.contains(7) && player1.contains(8) && player1.contains(9)) {
            winer=1
        }
        if(player2.contains(7) && player1.contains(8) && player1.contains(9)) {
            winer=2
        }
        //col 1
        if(player1.contains(1) && player1.contains(4) && player1.contains(7)) {
            winer=1
        }
        if(player2.contains(1) && player1.contains(4) && player1.contains(7)) {
            winer=2
        }
        //col 2
        if(player1.contains(2) && player1.contains(5) && player1.contains(8)) {
            winer=1
        }
        if(player2.contains(2) && player1.contains(5) && player1.contains(8)) {
            winer=2
        }
        //col 3
        if(player1.contains(3) && player1.contains(6) && player1.contains(9)) {
            winer=1
        }
        if(player2.contains(3) && player1.contains(6) && player1.contains(9)) {
            winer=2
        }
        if(winer==1){
            Toast.makeText(this,"the winer is player 1",Toast.LENGTH_LONG).show()
        }else if(winer==2){
            Toast.makeText(this,"the winer is player 2",Toast.LENGTH_LONG).show()
        }

    }






}