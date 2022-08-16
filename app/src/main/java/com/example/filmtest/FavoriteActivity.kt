package com.example.filmtest

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils.isEmpty
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomnavigation.BottomNavigationView

class FavoriteActivity : AppCompatActivity() {

    private lateinit var bottomNavigation: BottomNavigationView

    companion object {
        const val FAVORITE_KEY = "FAVORITE_KEY"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.favorite_activity)


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
           FavoriteActivity.FAVORITE_KEY)


        class Observer(private val recyclerView: RecyclerView) :
            RecyclerView.AdapterDataObserver() {

            private var emptyLayout: View

            init {
                emptyLayout = inflateEmptyView(recyclerView)
                emptyLayout.visibility = View.GONE
            }

            private fun inflateEmptyView(view: View): View {
                return LayoutInflater.from(view.context).inflate(
                    R.layout.favorite_activity, view.parent as ViewGroup
                )
            }
        }
    }

    private fun onClickBottomMenu() {
        val intent = Intent(this, FavoriteActivity::class.java)
        intent.putExtra(FavoriteActivity.FAVORITE_KEY)
        startActivity(intent)
    }
}

fun Intent.putExtra(favoriteKey: String) {
}
