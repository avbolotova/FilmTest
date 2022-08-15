package com.example.filmtest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils.isEmpty
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class FavoriteActivity : AppCompatActivity() {

    companion object {
        const val FAVORITE_KEY = "FAVORITE_KEY"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.favorite_activity)

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
}
