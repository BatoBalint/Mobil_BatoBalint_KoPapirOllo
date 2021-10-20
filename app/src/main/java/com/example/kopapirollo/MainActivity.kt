package com.example.kopapirollo

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog

class MainActivity : AppCompatActivity() {
    lateinit var UserImage : ImageView
    lateinit var CpuImage : ImageView
    lateinit var ScoreBoard : TextView
    lateinit var ButtonRock : Button
    lateinit var ButtonPaper : Button
    lateinit var ButtonScissor : Button

    var userChoice = 0
    var win = 0
    var lose = 0
    var draw = 0


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

    fun defaultSettings() {
        userChoice = 0
        win = 0
        lose = 0
        draw = 0

        UserImage.setImageResource(R.drawable.rock)
        CpuImage.setImageResource(R.drawable.rock)

        refreshScoreBoard()
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

        if (userChoice == cpu) {
            draw()
        } else if (userChoice == 2 && cpu == 0) {
            lose()
        } else if (userChoice == 0 && cpu == 2) {
            win()
        } else if (userChoice > cpu) {
            win()
        } else {
            lose()
        }
    }

    fun draw() {
        draw++
        Toast.makeText(this, "Döntetlen", Toast.LENGTH_SHORT).show()
    }

    fun lose() {
        lose++
        Toast.makeText(this, "Vesztettél", Toast.LENGTH_SHORT).show()
        refreshScoreBoard()
    }

    fun win() {
        win++
        Toast.makeText(this, "Nyertél", Toast.LENGTH_SHORT).show()
        refreshScoreBoard()
    }

    fun refreshScoreBoard() {
        ScoreBoard.setText("Eredmeny: Ember: ${win} Computer: ${lose}")
        checkEndOfGame()
    }

    fun checkEndOfGame() {
        if (win == 3) {
            var myAlert = AlertDialog.Builder(this).setTitle("Nyertél")
                .setMessage("Szeretne új játékot játszani?")
                .setCancelable(false)
                .setPositiveButton("Igen", DialogInterface.OnClickListener { dialog, id ->
                    defaultSettings()
                }).setNegativeButton("Nem", DialogInterface.OnClickListener { dialog, id ->
                    finishAffinity()
                }).show()
        } else if (lose == 3) {
            var myAlert = AlertDialog.Builder(this).setTitle("Vesztettél")
                .setMessage("Szeretne új játékot játszani?")
                .setCancelable(false)
                .setPositiveButton("Igen", DialogInterface.OnClickListener { dialog, id ->
                    defaultSettings()
                }).setNegativeButton("Nem", DialogInterface.OnClickListener { dialog, id ->
                    finishAffinity()
                }).show()
        }
    }
}
