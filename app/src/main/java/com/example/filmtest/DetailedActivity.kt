package com.example.filmtest

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.SyncStateContract
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
            val imageView: ImageView = findViewById(R.id.detailedActivity)
            val textView: TextView = findViewById(R.id.detailedActivityTv)
            val textView2: TextView = findViewById(R.id.detailedActivityDes)

            imageView.setImageResource(films.image)
            textView.text = films.name
            textView2.text = films.description

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