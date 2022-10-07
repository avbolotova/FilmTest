package com.example.filmtest

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.widget.AppCompatButton
import androidx.core.content.ContextCompat
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.RecyclerView
import com.example.filmtest.databinding.ActivityMainBinding
import com.example.filmtest.model.Item
import com.example.filmtest.view.favorite.FavoriteFragment
import com.example.filmtest.view.main.MainAdapter
import com.example.filmtest.view.main.MainFragmentViewModel
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    private lateinit var mBinding: ActivityMainBinding
    private val binding get() = mBinding
    lateinit var recyclerView: RecyclerView
    private lateinit var appCompatButton: Button
    private val adapter by lazy { MainAdapter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        MAIN = this

        init()
    }


    private fun init() {
        val viewModel = ViewModelProvider(this).get(MainFragmentViewModel::class.java)
        recyclerView = binding.recyclerView
        recyclerView.adapter = adapter
        viewModel.getMovies()
        viewModel.myMovies.observe(this, {
            adapter.setList(it.body()!!.items)
        })

        val itemDecoration = DividerItemDecoration(this, DividerItemDecoration.VERTICAL)
        val dividerDrawable = ContextCompat.getDrawable(this, R.drawable.item_divider)
        dividerDrawable?.let {
            itemDecoration.setDrawable(dividerDrawable)
        }
        recyclerView.addItemDecoration(itemDecoration)
    }



//
//    override fun onFilmsChanged(films: List<Films>) {
////        adapter.refreshFilms(films.toMutableList())
//
//    }
//
//    private fun onShowToast() {
//        val buttonToast: AppCompatButton = findViewById(R.id.favoriteFilms)
//        buttonToast.setOnClickListener {
//            Toast.makeText(applicationContext, "Вы добавили в избранное", Toast.LENGTH_SHORT).show()
//        }
//
//    }

//    private fun initRecyclerView() {
//        adapter = FilmsAdapter(
//            films = FilmsRepo.films.toMutableList()
//            onViewFilmsClick = this::onFilmsClicked,
//            onSetFavoriteClick = this::onSetFavoriteClicked
//        )




//    private fun onSetFavoriteClicked(films: Films) {
//        FilmsRepo.setFilmsFavorite(films)
//        adapter.refreshFilms(FilmsRepo.films.toMutableList())
//    }
//
//
//    private fun onFilmsClicked(films: Films) {
//        val intent = Intent(this, DetailedActivity::class.java)
//        intent.putExtra(DetailedActivity.TITLE, films.title)
//        intent.putExtra(DetailedActivity.DESCRIPTION, films.description)
//        intent.putExtra(DetailedActivity.IMAGE, films.imageResId)
//        startActivityForResult(intent, 42)
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
            }
            setCancelable(true)
        }.create().show()
    }
}

















