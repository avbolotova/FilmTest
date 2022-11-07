package com.example.filmtest.view.favorite

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import com.example.filmtest.MAIN
import com.example.filmtest.R
import com.example.filmtest.data.repository.MoviesRepo
import com.example.filmtest.data.retrofit.RetrofitRepo
import com.example.filmtest.data.room.MoviesDao
import com.example.filmtest.databinding.FragmentFavoriteBinding
import com.example.filmtest.model.Item
import com.example.filmtest.view.main.MainAdapter
import com.example.filmtest.view.main.MainFragmentViewModel
import com.google.android.material.snackbar.Snackbar


class FavoriteFragment : Fragment() {

    private lateinit var mBinding: FragmentFavoriteBinding
    private val binding get() = mBinding
    lateinit var recyclerView: RecyclerView
    private val adapter by lazy { FavoriteAdapter() }



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        mBinding = FragmentFavoriteBinding.inflate(layoutInflater, container, false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    private fun init() {
        val viewModel = ViewModelProvider(this).get(FavoriteFragmentViewModel::class.java)
        recyclerView = binding.recyclerViewFav
        recyclerView.adapter = adapter
        viewModel.getAllMoviesFav().observe(viewLifecycleOwner,{
            adapter.setList(it.asReversed())
        })
        val itemTouchHelper = ItemTouchHelper(
            object : ItemTouchHelper.SimpleCallback(
                0, ItemTouchHelper.RIGHT or ItemTouchHelper.LEFT
            ) {
                override fun onMove(
                    recyclerView: RecyclerView,
                    viewHolder: RecyclerView.ViewHolder,
                    target: RecyclerView.ViewHolder
                ): Boolean = false

                override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                    val item = adapter.getItem(viewHolder.adapterPosition)
                    viewModel.deleteMovieFav(item as Item)
                    adapter.notifyItemRemoved(viewHolder.adapterPosition)

                }
            }
        )
        itemTouchHelper.attachToRecyclerView(recyclerView)
    }

    companion object {
        fun clickFilmsFavorite(model: Item) {
            val bundle = Bundle()
            bundle.putSerializable("getFilms", model)
            MAIN.navController.navigate(R.id.action_detailedFragment_to_favoriteFragment, bundle)
        }
    }


}