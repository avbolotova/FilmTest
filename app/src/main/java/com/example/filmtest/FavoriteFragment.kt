package com.example.filmtest

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment

class FavoriteFragment : AppCompatActivity(){

    companion object {
        const val TITLE_KEY_TWO = "TITLE_KEY"
    }

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        setContentView(R.layout.favorite_empty)
    }

}