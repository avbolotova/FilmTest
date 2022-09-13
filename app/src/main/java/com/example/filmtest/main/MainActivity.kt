package com.example.filmtest.main

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.widget.AppCompatButton
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.RecyclerView
import com.example.filmtest.R
import com.example.filmtest.databinding.ActivityMainBinding
import com.example.filmtest.fragments.Favorite_fragment
import com.example.filmtest.observable.FilmsObserver
import com.example.filmtest.repo.FilmsRepo
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity(), FilmsObserver {


    private lateinit var adapter: FilmsAdapter
    private lateinit var binding: ActivityMainBinding
    private lateinit var bottomNavigationView: BottomNavigationView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        bottomNavigationView = findViewById(R.id.bottomMenu)

        bottomNavigationView.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.home -> onOpenActivity()
                R.id.favorite -> supportFragmentManager.beginTransaction()
                    .replace(R.id.fragmentContainerView, Favorite_fragment())
                    .commit()
                else -> {
                }
            }
            return@setOnItemSelectedListener true
        }

        FilmsRepo.createFilms(applicationContext)
        FilmsRepo.addObserver(this)
        initRecyclerView()
    }

    private fun onOpenActivity() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }


    override fun onFilmsChanged(films: List<Films>) {
        adapter.refreshFilms(films.toMutableList())

    }

    private fun onShowToast(){
        val buttonToast: AppCompatButton = findViewById(R.id.favoriteFilms)
        buttonToast.setOnClickListener{
            Toast.makeText(applicationContext, "Вы добавили в избранное", Toast.LENGTH_SHORT).show()
        }

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



    override fun onBackPressed() {
        AlertDialog.Builder(this).apply {
            setTitle("Подтверждение")
            setMessage("Вы уверены, что хотите выйти из программы?")

            setPositiveButton("Да") { _, _ ->
                super.onBackPressed()
            }

            setNegativeButton("Нет") { _, _ ->
                // if user press no, then return the activity
            }
            setCancelable(true)
        }.create().show()
    }
}
















