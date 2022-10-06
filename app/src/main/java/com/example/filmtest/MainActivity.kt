package com.example.filmtest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.filmtest.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView


class MainActivity : AppCompatActivity() {

    private var mBinding: ActivityMainBinding?= null
    private val binding get() = mBinding!!
    private lateinit var bottomNavigationView: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        MAIN = this

        bottomNavigationView = findViewById(R.id.bottomMenu)

    }

    override fun onDestroy() {
        super.onDestroy()
        mBinding = null
    }
}

//
//        bottomNavigationView = findViewById(R.id.bottomMenu)

//        bottomNavigationView.setOnItemSelectedListener {
//            when (it.itemId) {
//                R.id.home -> onOpenActivity()
//                R.id.favorite -> supportFragmentManager.beginTransaction()
//                    .replace(R.id.fragmentContainerView, FavoriteFragment())
//                    .commit()
//                else -> {
//                }
//            }
//            return@setOnItemSelectedListener true
//        }


//        initRecyclerView()
//    }
//
//    private fun onOpenActivity() {
//        val intent = Intent(this, MainActivity::class.java)
//        startActivity(intent)
//    }
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


//        recyclerView.adapter = adapter
//
//        val apiInterface = ApiInterface.create().getMovies("pk_o8r5adc3qy9sqc5c3")
//
//        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)


//        val itemDecoration = DividerItemDecoration(this, DividerItemDecoration.VERTICAL)
//        val dividerDrawable = ContextCompat.getDrawable(this, R.drawable.item_divider)
//
//        dividerDrawable?.let {
//            itemDecoration.setDrawable(dividerDrawable)
//        }
//
//        recyclerView.addItemDecoration(itemDecoration)
//
//    }

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


//        fun onBackPressed() {
//            AlertDialog.Builder(this).apply {
//                setTitle("Подтверждение")
//                setMessage("Вы уверены, что хотите выйти из программы?")
//
//                setPositiveButton("Да") { _, _ ->
//                    super.onBackPressed()
//                }
//
//                setNegativeButton("Нет") { _, _ ->
//                    // if user press no, then return the activity
//                }
//                setCancelable(true)
//            }.create().show()
//        }
//    }
//}
















