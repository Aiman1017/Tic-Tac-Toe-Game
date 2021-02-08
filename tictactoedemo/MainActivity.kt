package com.example.tictactoedemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ImageView
import com.example.tictactoedemo.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    //0 - cross, 1 - circle
    var activePlayer = 0

    //Add GameState to keep track of the change
    //The 2 represent game early State
    //Will change base on activePlayer
    val gameState = arrayListOf(2,2,2,2,2,2,2,2,2)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    fun dropIn(view: View){
        val slotImage = view as ImageView
        //Bind the tappedSlot with the slotImage
        val tappedSlot = slotImage.tag.toString().toInt()
        //bind the gameState with user tap or tapped Slot
        gameState[tappedSlot] = activePlayer
        Log.i("Game state", gameState.toString())
        slotImage.translationY = -2000f
        if(activePlayer == 0){
            slotImage.setImageResource(R.drawable.tic_tac_toe_x)
            activePlayer = 1
        }else{
            slotImage.setImageResource(R.drawable.tic_tac_toe_o)
            activePlayer = 0
        }
        slotImage.animate().translationYBy(2000f).rotation(1800f).setDuration(500)
    }
}