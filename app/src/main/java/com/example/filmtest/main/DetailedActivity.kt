package com.example.filmtest.main

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.example.filmtest.R
import com.example.filmtest.favorite.FavoriteAdapter
import com.example.filmtest.repo.FilmsRepo
import com.google.android.material.bottomnavigation.BottomNavigationView

class DetailedActivity : AppCompatActivity() {


//    private lateinit var bottomNavigation: BottomNavigationView
    private lateinit var adapter: FavoriteAdapter


    companion object {
        const val TITLE = "title"
        const val FAVORITE = "favorite"
        const val DESCRIPTION = "description"
        const val IMAGE = "image"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detailed)


        title = intent.getStringExtra(TITLE) ?: error("No title provided")

        val text = intent.getStringExtra(DESCRIPTION) ?: error("No title provided")

        val description = findViewById<TextView>(R.id.detailedActivityDes)
        description.text = text

        val image = intent.getIntExtra(IMAGE, -1)
        findViewById<ImageView>(R.id.detailedActivity).setImageResource(image)

        val result = Intent()
        result.putExtra(FAVORITE, true)
        setResult(RESULT_OK, result)


//        bottomNavigation = findViewById(R.id.bottomNav)
//
//        bottomNavigation.setOnItemSelectedListener {
//            when (it.itemId) {
//                R.id.home -> onClickHome()
//                R.id.favorite -> onClickBottomMenu()
//                else -> {
//                }
//            }
//            return@setOnItemSelectedListener true
//        }


        var button: Button = findViewById(R.id.toShareBut)
        button.setOnClickListener {
            val intent = Intent(Intent.ACTION_SEND)
            intent.type = "text/plain"
            val chooser = Intent.createChooser(intent, "Share using")
            startActivity(chooser)

        }
    }


//    private fun onClickBottomMenu() {
//        val intent = Intent(this, FavoriteActivity::class.java)
//        intent.putExtra(FavoriteActivity.FAVORITE_KEY)
//        startActivity(intent)
//    }
//
//    private fun onClickHome() {
//        val intent = Intent(this, MainActivity::class.java)
//        intent.putExtra(MainActivity.HOME_OPEN)
//        startActivity(intent)
//    }
//    private fun Intent.putExtra(favoriteKey: String) {
//    }
}




