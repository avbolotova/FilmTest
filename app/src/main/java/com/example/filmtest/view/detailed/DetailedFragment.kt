package com.example.filmtest.view.detailed

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.appcompat.widget.AppCompatButton
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.example.filmtest.MAIN
import com.example.filmtest.R
import com.example.filmtest.databinding.FragmentDetailedBinding
import com.example.filmtest.model.Item
import com.google.android.material.bottomnavigation.BottomNavigationView

class DetailedFragment : Fragment() {

    private var mBinding: FragmentDetailedBinding? = null
    private val binding get() = mBinding!!
    lateinit var currentMovie: Item
    private var isFavorite = false
    private var isScheduleAdd = false



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        mBinding = FragmentDetailedBinding.inflate(layoutInflater, container, false)
        currentMovie = arguments?.getSerializable("getFilms") as Item
        return binding.root


    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
        initSheduleAdd()


        var button: Button = view.findViewById(R.id.toShareBut)
        button.setOnClickListener {
            val intent = Intent(Intent.ACTION_SEND)
            intent.type = "text/plain"
            val chooser = Intent.createChooser(intent, "Share using")
            startActivity(chooser)

        }
    }

    private fun initSheduleAdd() {
        val viewModel = ViewModelProvider(this).get(DetailedViewModel::class.java)
        Glide.with(MAIN)
            .load(currentMovie.image)
            .centerCrop()
            .placeholder(R.drawable.item_divider)
            .into(binding.imgDetailed)
        binding.dtvTitleDetailed.text = currentMovie.fullTitle
        binding.tvDescriptionDetailed.text = currentMovie.crew

        binding.movieShed.setOnClickListener {
            isScheduleAdd = if(!isScheduleAdd) {
                binding.movieShed.setImageResource(R.drawable.ic_time_24)
                viewModel.insert(currentMovie){
                }
                true
            } else {
                binding.movieShed.setImageResource(R.drawable.ic_pin_24)
                viewModel.delete(currentMovie){
                }
                false
            }
        }
    }


    private fun init() {
        val viewModel = ViewModelProvider(this).get(DetailedViewModel::class.java)
        Glide.with(MAIN)
            .load(currentMovie.image)
            .centerCrop()
            .placeholder(R.drawable.item_divider)
            .into(binding.imgDetailed)
        binding.dtvTitleDetailed.text = currentMovie.fullTitle
        binding.tvDescriptionDetailed.text = currentMovie.crew

        binding.favoriteFilms.setOnClickListener {
            isFavorite = if(!isFavorite) {
                binding.favoriteFilms.setImageResource(R.drawable.ic_favorite_fool_roz)
                viewModel.insert(currentMovie){
                }
                true
            } else {
                binding.favoriteFilms.setImageResource(R.drawable.ic_favorite_roz)
                viewModel.delete(currentMovie){
                }
                false
            }
        }
    }


}