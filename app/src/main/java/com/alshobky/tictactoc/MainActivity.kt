package com.alshobky.tictactoc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import java.util.Random

class MainActivity : AppCompatActivity() {
    lateinit var bu1:Button
    lateinit var bu2:Button
    lateinit var bu3:Button
    lateinit var bu4:Button
    lateinit var bu5:Button
    lateinit var bu6:Button
    lateinit var bu7:Button
    lateinit var bu8:Button
    lateinit var bu9:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        bu1=findViewById(R.id.bu1)
        bu2=findViewById(R.id.bu2)
        bu3=findViewById(R.id.bu3)
        bu4=findViewById(R.id.bu4)
        bu5=findViewById(R.id.bu5)
        bu6=findViewById(R.id.bu6)
        bu7=findViewById(R.id.bu7)
        bu8=findViewById(R.id.bu8)
        bu9=findViewById(R.id.bu9)
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
     var activePlayer=1
     var player1=ArrayList<Int>()
     var player2=ArrayList<Int>()
    fun playGame(butId:Int,buSelected:Button){
        if(activePlayer==1){
            buSelected.text="X"
            buSelected.setBackgroundResource(R.color.butRed)
            player1.add(butId)
            activePlayer=2
            autoPlay()
        }else{
            buSelected.text="o"
            buSelected.setBackgroundResource(R.color.greenTack)
            player2.add(butId)
            activePlayer=1

        }
        buSelected.isEnabled=false
        chickWiner()
    }

    // fun for chick winer
    fun  chickWiner(){
        var winer=-1
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

    // fun for autoplay and select cell
    fun autoPlay(){
        var emptyCells=ArrayList<Int>()
        for(cellId in 1..9){
            if(!(player1.contains(cellId) || player2.contains(cellId))){
                emptyCells.add(cellId)
            }
        }
        var r= Random()
        var randIndex=r.nextInt(emptyCells.size)
        val cellId=emptyCells[randIndex]
        val buSelected:Button? = when(cellId){
            1->bu1
            2->bu2
            3->bu3
            4->bu4
            5->bu5
            6->bu6
            7->bu7
            8->bu8
            9->bu9

            else -> {bu1}
        }
        playGame(cellId,buSelected!!)
    }




}