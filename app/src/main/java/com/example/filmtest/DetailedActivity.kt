package com.example.filmtest

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.SyncStateContract
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.google.android.material.bottomnavigation.BottomNavigationView

class DetailedActivity : AppCompatActivity() {

    private lateinit var bottomNavigation: BottomNavigationView


    companion object {
        const val TITLE_KEY = "TITLE_KEY"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detailed)


        bottomNavigation = findViewById(R.id.bottomNav)

        bottomNavigation.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.home -> onStart()
                R.id.favorite -> onClickBottomMenu()
                else -> {
                }
            }
            return@setOnItemSelectedListener true
        }



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

    private fun onClickBottomMenu() {
        val intent = Intent(this, FavoriteActivity::class.java)
        intent.putExtra(FavoriteActivity.FAVORITE_KEY)
        startActivity(intent)
    }

}
