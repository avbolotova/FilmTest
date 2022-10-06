package com.example.filmtest.fragments

import android.content.Intent
import android.net.wifi.p2p.nsd.WifiP2pUpnpServiceInfo.newInstance
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatButton
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import com.example.filmtest.R
import com.example.filmtest.favorite.FavoriteAdapter
import com.example.filmtest.main.MainActivity
import com.example.filmtest.repo.FilmsRepo
import com.google.android.material.snackbar.Snackbar
import org.xmlpull.v1.XmlPullParserFactory.newInstance


class FavoriteFragment : Fragment(){

    private lateinit var adapter: FavoriteAdapter

    companion object {
        const val TAG = "FavoriteList"
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_favorite, container, false)


    }

    override fun onStart() {
        initRecyclerView()
        super.onStart()
    }

    private fun showShackBar(){
        val snackbar = Snackbar.make(requireView(), "Фильм удален", Snackbar.LENGTH_SHORT)
        snackbar.setAction("Отменить", View.OnClickListener {
            snackbar.dismiss()
        })
        snackbar.show()
    }


    private fun initRecyclerView() {
        adapter = FavoriteAdapter(films = FilmsRepo.getFavoriteFilms())
        val recyclerFavoriteMovies = requireView().findViewById<RecyclerView>(R.id.recyclerViewFav)
        recyclerFavoriteMovies.adapter = adapter


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
                    val film = adapter.getItem(viewHolder.adapterPosition)
                    FilmsRepo.deleteFromFavorites(film)
                    adapter.refreshFilms(FilmsRepo.getFavoriteFilms())
                    showShackBar()
                }
            }
        )
        itemTouchHelper.attachToRecyclerView(recyclerFavoriteMovies)
    }
}