package com.example.filmtest.view.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.example.filmtest.MAIN
import com.example.filmtest.R
import com.example.filmtest.databinding.ActivityMainBinding
import com.example.filmtest.databinding.FragmentFavoriteBinding
import com.example.filmtest.databinding.FragmentMainBinding
import com.example.filmtest.model.Item
import com.example.filmtest.view.favorite.FavoriteFragmentViewModel

class MainFragment : Fragment() {

    private lateinit var mBinding: FragmentMainBinding
    private val binding get() = mBinding
    lateinit var recyclerView: RecyclerView
    private val adapter by lazy { MainAdapter() }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        mBinding = FragmentMainBinding.inflate(layoutInflater, container, false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    private fun init() {
        val viewModel = ViewModelProvider(this).get(MainFragmentViewModel::class.java)
        viewModel.initDatabase()
        recyclerView = binding.recyclerView
        recyclerView.adapter = adapter
        viewModel.getMovies()
        viewModel.myMovies.observe(viewLifecycleOwner, {
            adapter.setList(it.body()!!.items)
        })
    }
    companion object {
        fun clickFilms(model: Item) {
            val bundle = Bundle()
            bundle.putSerializable("getFilms", model)
            MAIN.navController.navigate(R.id.action_mainFragment_to_detailedFragment, bundle)
        }
    }
}