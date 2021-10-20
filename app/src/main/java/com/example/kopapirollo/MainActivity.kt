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
        ButtonPaper = findViewById(R.id.btnPaper)
        ButtonScissor = findViewById(R.id.btnScissor)
    }
}
