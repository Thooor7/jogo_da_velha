package com.example.jogodavelha

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    var isPlayer1 = true
    var gameEnd = false

    private lateinit var top: ImageView
    private lateinit var topStart: ImageView
    private lateinit var topEnd: ImageView

    private lateinit var center: ImageView
    private lateinit var centerStart: ImageView
    private lateinit var centerEnd: ImageView

    private lateinit var bottom: ImageView
    private lateinit var bottomStart: ImageView
    private lateinit var bottomEnd: ImageView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        top = findViewById(R.id.top)
        topStart = findViewById(R.id.topStart)
        topEnd = findViewById(R.id.topEnd)

        center = findViewById(R.id.center)
        centerStart = findViewById(R.id.centerStart)
        centerEnd = findViewById(R.id.centerEnd)

        bottom = findViewById(R.id.bottom)
        bottomStart = findViewById(R.id.bottomStart)
        bottomEnd = findViewById(R.id.bottomEnd)

        configureBox(top)
        configureBox(topStart)
        configureBox(topEnd)

        configureBox(center)
        configureBox(centerStart)
        configureBox(centerEnd)

        configureBox(bottom)
        configureBox(bottomStart)
        configureBox(bottomEnd)


    }

    private fun configureBox(box: ImageView) {
        if (box.tag == null && !gameEnd) {
            box.setOnClickListener {
                if (isPlayer1) {
                    box.setImageResource(R.drawable.baseline_circle_24)
                    isPlayer1 = false
                    box.tag = 1
                } else {
                    box.setImageResource(R.drawable.baseline_clear_24)
                    isPlayer1 = true
                    box.tag = 2
                }
                if (playerWin(1)) {
                    Toast.makeText(this@MainActivity, "Player 1 venceu!", Toast.LENGTH_SHORT).show()
                    gameEnd = true
                } else if (playerWin(2)) {
                    Toast.makeText(this@MainActivity, "Player 2 venceu!", Toast.LENGTH_SHORT).show()
                    gameEnd = true
                }
            }

        }

    }

    private fun playerWin(value: Int): Boolean {
        if ((top.tag == value && center.tag == value && bottom.tag == value) ||
            (topStart.tag == value && centerStart.tag == value && bottomStart.tag == value) ||
            (topEnd.tag == value && centerEnd.tag == value && bottomEnd.tag == value) ||
            (topStart.tag == value && center.tag == value && bottomEnd.tag == value) ||
            (topEnd.tag == value && center.tag == value && bottomStart.tag == value) ||
            (topStart.tag == value && top.tag == value && topEnd.tag == value) ||
            (centerStart.tag == value && center.tag == value && centerEnd.tag == value) ||
            bottomStart.tag == value && bottom.tag == value && bottomEnd.tag == value

        ) {
            return true

        }
        return false
    }
}

