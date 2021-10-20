package com.example.kopapirollo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    lateinit var UserImage : ImageView
    lateinit var CpuImage : ImageView
    lateinit var ScoreBoard : TextView
    lateinit var ButtonRock : Button
    lateinit var ButtonPaper : Button
    lateinit var ButtonScissor : Button

    var userChoice = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        init()
    }

    fun init() {
        UserImage = findViewById(R.id.userImage)
        CpuImage = findViewById(R.id.cpuImage)
        ScoreBoard = findViewById(R.id.scoreBoard)
        ButtonRock = findViewById(R.id.btnRock)
        ButtonRock.setOnClickListener { rockButtonPressed() }
        ButtonPaper = findViewById(R.id.btnPaper)
        ButtonPaper.setOnClickListener { paperButtonPressed() }
        ButtonScissor = findViewById(R.id.btnScissor)
        ButtonScissor.setOnClickListener { scissorButtonPressed() }
    }

    fun rockButtonPressed() {
        UserImage.setImageResource(R.drawable.rock)
        userChoice = 0
        cpuChoice()
    }

    fun paperButtonPressed() {
        UserImage.setImageResource(R.drawable.paper)
        userChoice = 1
        cpuChoice()
    }

    fun scissorButtonPressed() {
        UserImage.setImageResource(R.drawable.scissors)
        userChoice = 2
        cpuChoice()
    }

    fun cpuChoice() {
        val cpu: Int =  (Math.random() * 3).toInt()

        if (cpu == 0) {
            CpuImage.setImageResource(R.drawable.rock)
        } else if (cpu == 1) {
            CpuImage.setImageResource(R.drawable.paper)
        } else if (cpu == 2) {
            CpuImage.setImageResource(R.drawable.scissors)
        }

        if (userChoice == 2 && cpu == 0) {
            lose()
        } else if (userChoice == 0 && cpu == 2) {
            win()
        } else if (userChoice > cpu) {
            win()
        } else {
            lose()
        }
    }

    fun lose() {
        Toast.makeText(this, "lose", Toast.LENGTH_SHORT).show()
    }

    fun win() {
        Toast.makeText(this, "win", Toast.LENGTH_SHORT).show()
    }
}
