package com.example.filmtest

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

class DetailedActivity : AppCompatActivity() {

    companion object {
        const val TITLE_KEY = "TITLE_KEY"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detailed)

        val films = intent.getSerializableExtra(
            Companion.TITLE_KEY)
        if (films != null && films is Films) {
            val poster: ImageView = findViewById(R.id.detailedActivity)
            val nameFilm: TextView = findViewById(R.id.detailedActivityTv)
            val descripton: TextView = findViewById(R.id.detailedActivityDes)

            poster.setImageResource(films.image)
            nameFilm.text = films.name
            descripton.text = films.description

        }


        var button: Button = findViewById(R.id.toShareBut)
        button.setOnClickListener {
            val intent = Intent(Intent.ACTION_SEND)
            intent.type = "text/plain"
            val chooser = Intent.createChooser(intent, "Share using")
            startActivity(chooser)



        }
    }
}