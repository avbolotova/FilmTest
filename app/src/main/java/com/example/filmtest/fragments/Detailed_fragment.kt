package com.example.filmtest.fragments

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.example.filmtest.R

class Detailed_fragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detailed, container, false)
    }

    companion object {
        const val TITLE = "title"
        const val FAVORITE = "favorite"
        const val DESCRIPTION = "description"
        const val IMAGE = "image"
    }

}