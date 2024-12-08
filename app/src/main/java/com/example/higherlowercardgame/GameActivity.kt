package com.example.higherlowercardgame

import android.annotation.SuppressLint
import android.app.AlertDialog
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity


class GameActivity : AppCompatActivity() {

    lateinit var streakCount: TextView

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_game)

        streakCount = findViewById(R.id.streakCountTextView)

        val oldCardImageView: ImageView = findViewById(R.id.oldCardImageView)
        val lastCardImageView: ImageView = findViewById(R.id.lastCardImageView)

        oldCardImageView.setImageResource(R.drawable.cardback)

        var lastCardValue = drawCard().first
        var lastCardImage = drawCard().second

        var score = 0

        val hbutton = findViewById<Button>(R.id.higherButton)
        hbutton.setOnClickListener{
            val (newCardValue, newCardImage) = drawCard()
            oldCardImageView.setImageResource(lastCardImage)
            lastCardImageView.setImageResource(newCardImage)

            if (lastCardValue <= newCardValue) {
                score++
            } else {
                val builder: AlertDialog.Builder = AlertDialog.Builder(this)
                builder
                    .setTitle("You did a total of $score streaks!")
                    .setMessage("Play again?")
                    .setPositiveButton("Yes!!") { dialog, which ->
                        // Restart game
                        val intent = Intent(this, GameActivity::class.java)
                        startActivity(intent)
                    }
                    .setNegativeButton("No..") { dialog, which ->
                        // Exit game
                        finish()
                    }

                val dialog: AlertDialog = builder.create()
                dialog.show()
            }
            lastCardValue = newCardValue
            lastCardImage = newCardImage
            streakCount.text = "Streak: $score"
        }

        val lbutton = findViewById<Button>(R.id.lowerButton)
        lbutton.setOnClickListener{
            val (newCardValue, newCardImage) = drawCard()
            oldCardImageView.setImageResource(lastCardImage)
            lastCardImageView.setImageResource(newCardImage)

            if (lastCardValue >= newCardValue) {
                score++
            }else {
                val builder: AlertDialog.Builder = AlertDialog.Builder(this)
                builder
                    .setTitle("You did a total of $score streaks!")
                    .setMessage("Play again?")
                    .setPositiveButton("Yes!!") { dialog, which ->
                        // Restart game
                        val intent = Intent(this, GameActivity::class.java)
                        startActivity(intent)
                    }
                    .setNegativeButton("No..") { dialog, which ->
                        // Exit game
                        finish()
                    }

                val dialog: AlertDialog = builder.create()
                dialog.show()

            }
            lastCardValue = newCardValue
            lastCardImage = newCardImage
            streakCount.text = "Streak: $score"

        }
    }


    private fun drawCard(): Pair<Int,Int> {
        val value = (2..14).random()                                      //2-14
        val suits = listOf("hearts", "diamonds", "clubs", "spades")             //suits
        val suit = suits.random()                                               //randomize suits

        val showCard: ImageView = findViewById(R.id.lastCardImageView)

        //value and color to an image
        val cardImage = getCardImage(value, suit)
        showCard.setImageResource(cardImage)

        return Pair(value,cardImage)
    }

    private fun getCardImage(value: Int, suit: String): Int {
        return when (value) {
            2 -> when (suit) {
                "hearts" -> R.drawable.heartstwo
                "diamonds" -> R.drawable.diamondstwo
                "clubs" -> R.drawable.clubstwo
                "spades" -> R.drawable.spadestwo
                else -> R.drawable.cardback
            }
            3 -> when (suit) {
                "hearts" -> R.drawable.heartsthree
                "diamonds" -> R.drawable.diamondsthree
                "clubs" -> R.drawable.clubsthree
                "spades" -> R.drawable.spadesthree
                else -> R.drawable.cardback
            }
            4 -> when (suit) {
                "hearts" -> R.drawable.heartsfour
                "diamonds" -> R.drawable.diamondsfour
                "clubs" -> R.drawable.clubsfour
                "spades" -> R.drawable.spadesfour
                else -> R.drawable.cardback
            }
            5 -> when (suit) {
                "hearts" -> R.drawable.heartsfive
                "diamonds" -> R.drawable.diamondsfive
                "clubs" -> R.drawable.clubsfive
                "spades" -> R.drawable.spadesfive
                else -> R.drawable.cardback
            }
            6 -> when (suit) {
                "hearts" -> R.drawable.heartssix
                "diamonds" -> R.drawable.diamondssix
                "clubs" -> R.drawable.clubssix
                "spades" -> R.drawable.spadessix
                else -> R.drawable.cardback
            }
            7 -> when (suit) {
                "hearts" -> R.drawable.heartsseven
                "diamonds" -> R.drawable.diamondsseven
                "clubs" -> R.drawable.clubsseven
                "spades" -> R.drawable.spadesseven
                else -> R.drawable.cardback
            }
            8 -> when (suit) {
                "hearts" -> R.drawable.heartseight
                "diamonds" -> R.drawable.diamondseight
                "clubs" -> R.drawable.clubseight
                "spades" -> R.drawable.spadeseight
                else -> R.drawable.cardback
            }
            9 -> when (suit) {
                "hearts" -> R.drawable.heartsnine
                "diamonds" -> R.drawable.diamondsnine
                "clubs" -> R.drawable.clubsnine
                "spades" -> R.drawable.spadesnine
                else -> R.drawable.cardback
            }
            10 -> when (suit) {
                "hearts" -> R.drawable.heartsten
                "diamonds" -> R.drawable.diamondsten
                "clubs" -> R.drawable.clubsten
                "spades" -> R.drawable.spadesten
                else -> R.drawable.cardback
            }
            11 -> when (suit) {
                "hearts" -> R.drawable.heartsjack
                "diamonds" -> R.drawable.diamondsjack
                "clubs" -> R.drawable.clubsjack
                "spades" -> R.drawable.spadesjack
                else -> R.drawable.cardback
            }
            12 -> when (suit) {
                "hearts" -> R.drawable.heartsqueen
                "diamonds" -> R.drawable.diamondsqueen
                "clubs" -> R.drawable.clubsqueen
                "spades" -> R.drawable.spadesqueen
                else -> R.drawable.cardback
            }
            13 -> when (suit) {
                "hearts" -> R.drawable.heartsking
                "diamonds" -> R.drawable.diamondsking
                "clubs" -> R.drawable.clubsking
                "spades" -> R.drawable.spadesking
                else -> R.drawable.cardback
            }
            14 -> when (suit) {
                "hearts" -> R.drawable.heartsace
                "diamonds" -> R.drawable.diamondsace
                "clubs" -> R.drawable.clubsace
                "spades" -> R.drawable.spadesace
                else -> R.drawable.cardback
            }
            else -> R.drawable.cardback
            }
        }
}