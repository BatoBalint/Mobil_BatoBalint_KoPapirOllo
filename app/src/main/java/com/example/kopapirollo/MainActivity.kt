package com.example.kopapirollo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    lateinit var UserImage : ImageView
    lateinit var CpuImage : ImageView
    lateinit var ScoreBoard : TextView
    lateinit var ButtonRock : Button
    lateinit var ButtonPaper : Button
    lateinit var ButtonScissor : Button


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
    }

    fun paperButtonPressed() {
        UserImage.setImageResource(R.drawable.paper)
    }

    fun scissorButtonPressed() {
        UserImage.setImageResource(R.drawable.scissors)
    }
}
