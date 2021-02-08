package com.example.tictactoedemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.Toast
import com.example.tictactoedemo.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    //0 - cross, 1 - circle
    var activePlayer = 0

    //Add GameState to keep track of the change
    //The 2 represent game early State
    //Will change base on activePlayer - 0 and 1
    val gameState = arrayListOf(2,2,2,2,2,2,2,2,2)
    val winningPosition = listOf(
            listOf(0,1,2),
            listOf(3,4,5),
            listOf(6,7,8),
            listOf(0,3,6),
            listOf(1,4,7),
            listOf(2,5,8),
            listOf(0,4,8),
            listOf(2,4,6)
    )

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

        //Iterate every data in the array
        //The combo refer to activePlayer
        for(combo in winningPosition){
            //Check if the activePlayer have the same slot (Either 0 or 1)
            // based on winningPosition array
            if(gameState[combo[0]] == gameState[combo[1]] && gameState[combo[1]] == gameState[combo[2]] && gameState[combo[0]] != 2){
                Toast.makeText(this, "We have a winner. The winner is $activePlayer", Toast.LENGTH_LONG).show()
            }
        }
    }
}