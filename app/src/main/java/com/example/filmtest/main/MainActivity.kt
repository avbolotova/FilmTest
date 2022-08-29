package com.example.filmtest.main

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.widget.AppCompatButton
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.RecyclerView
import com.example.filmtest.R
import com.example.filmtest.observable.FilmsObserver
import com.example.filmtest.repo.FilmsRepo

class MainActivity : AppCompatActivity(), FilmsObserver {

//    companion object {
//        const val HOME_OPEN = "HOME_OPEN"
//    }
//    private lateinit var bottomNavigation: BottomNavigationView
    private lateinit var adapter: FilmsAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        FilmsRepo.createFilms(applicationContext)
        FilmsRepo.addObserver(this)
        setOnShowFavoritesButtonClickListener()
        initRecyclerView()



//        bottomNavigation = findViewById(R.id.bottomNav)
//
//        bottomNavigation.setOnItemSelectedListener {
//            when (it.itemId) {
//                R.id.home -> onClickHome()
//                else -> {
//                }
//            }
//            return@setOnItemSelectedListener true
//        }

    }


    override fun onFilmsChanged(films: List<Films>) {
        adapter.refreshFilms(films.toMutableList())
    }


    private fun initRecyclerView() {
        adapter = FilmsAdapter(
            films = FilmsRepo.films.toMutableList(),
            onViewFilmsClick = this::onFilmsClicked,
            onSetFavoriteClick = this::onSetFavoriteClicked
        )

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.adapter = adapter

        val itemDecoration = DividerItemDecoration(this, DividerItemDecoration.VERTICAL)
        val dividerDrawable = ContextCompat.getDrawable(this, R.drawable.item_divider)

        dividerDrawable?.let {
            itemDecoration.setDrawable(dividerDrawable)
        }

        recyclerView.addItemDecoration(itemDecoration)

    }

    private fun onSetFavoriteClicked(films: Films) {
        FilmsRepo.setFilmsFavorite(films)
        adapter.refreshFilms(FilmsRepo.films.toMutableList())
    }


    private fun onFilmsClicked(films: Films) {
        val intent = Intent(this, DetailedActivity::class.java)
        intent.putExtra(DetailedActivity.TITLE, films.title)
        intent.putExtra(DetailedActivity.DESCRIPTION, films.description)
        intent.putExtra(DetailedActivity.IMAGE, films.imageResId)
        startActivityForResult(intent, 42)
    }

    private fun setOnShowFavoritesButtonClickListener() {
        val button = findViewById<AppCompatButton>(R.id.buttonAddFavorite)
        button.setOnClickListener {
            val intent = Intent(this, FavoriteActivity::class.java)
            startActivity(intent)
        }
    }


//    private fun onClickHome() {
//        val intent = Intent(this, MainActivity::class.java)
//        intent.putExtra(HOME_OPEN)
//        startActivity(intent)
//    }


//    private fun Intent.putExtra(favoriteKey: String) {
//    }


    override fun onBackPressed() {
        AlertDialog.Builder(this).apply {
            setTitle("Подтверждение")
            setMessage("Вы уверены, что хотите выйти из программы?")

            setPositiveButton("Да") { _, _ ->
                super.onBackPressed()
            }

            setNegativeButton("Нет") { _, _ ->
                // if user press no, then return the activity
                Toast.makeText(this@MainActivity, "Thank you",
                    Toast.LENGTH_LONG).show()
            }
            setCancelable(true)
        }.create().show()
    }
}















