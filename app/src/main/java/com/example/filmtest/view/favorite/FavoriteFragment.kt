package com.example.filmtest.view.favorite

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.example.filmtest.R
import com.example.filmtest.databinding.FragmentFavoriteBinding
import com.example.filmtest.view.main.MainAdapter
import com.example.filmtest.view.main.MainFragmentViewModel
import com.google.android.material.snackbar.Snackbar


class FavoriteFragment : Fragment() {

    private lateinit var mBinding: FragmentFavoriteBinding
    private val binding get() = mBinding
    lateinit var recyclerView: RecyclerView
    private val adapter by lazy { MainAdapter() }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        mBinding = FragmentFavoriteBinding.inflate(layoutInflater, container, false)
        // Inflate the layout for this fragment
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
    }

}

//    override fun onStart() {
//        initRecyclerView()
//        super.onStart()
//    }
//
//    private fun showShackBar() {
//        val snackbar = Snackbar.make(requireView(), "Фильм удален", Snackbar.LENGTH_SHORT)
//        snackbar.setAction("Отменить", View.OnClickListener {
//            snackbar.dismiss()
//        })
//        snackbar.show()
//    }
//}


//    private fun initRecyclerView() {
//        adapter = FavoriteAdapter(films = FilmsRepo.getFavoriteFilms())
//        val recyclerFavoriteMovies = requireView().findViewById<RecyclerView>(R.id.recyclerViewFav)
//        recyclerFavoriteMovies.adapter = adapter
//
//
//        val itemTouchHelper = ItemTouchHelper(
//            object : ItemTouchHelper.SimpleCallback(
//                0, ItemTouchHelper.RIGHT or ItemTouchHelper.LEFT
//            ) {
//                override fun onMove(
//                    recyclerView: RecyclerView,
//                    viewHolder: RecyclerView.ViewHolder,
//                    target: RecyclerView.ViewHolder
//                ): Boolean = false
//
//
//
//                override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
//                    val film = adapter.getItem(viewHolder.adapterPosition)
//                    FilmsRepo.deleteFromFavorites(film)
//                    adapter.refreshFilms(FilmsRepo.getFavoriteFilms())
//                    showShackBar()
//                }
//            }
//        )
//        itemTouchHelper.attachToRecyclerView(recyclerFavoriteMovies)
//    }
//}