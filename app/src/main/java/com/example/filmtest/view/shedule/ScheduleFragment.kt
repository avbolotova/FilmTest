package com.example.filmtest.view.shedule

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import com.example.filmtest.MAIN
import com.example.filmtest.R
import com.example.filmtest.databinding.FragmentFavoriteBinding
import com.example.filmtest.databinding.FragmentScheduleBinding
import com.example.filmtest.model.Item
import com.example.filmtest.view.favorite.FavoriteAdapter
import com.example.filmtest.view.favorite.FavoriteFragmentViewModel

class ScheduleFragment : Fragment() {
    private lateinit var mBinding: FragmentScheduleBinding
    private val binding get() = mBinding
    lateinit var recyclerView: RecyclerView
    private val adapter by lazy { ScheduleAdapter() }



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        mBinding = FragmentScheduleBinding.inflate(layoutInflater, container, false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    private fun init() {
        val viewModel = ViewModelProvider(this).get(ScheduleFragmentViewModel::class.java)
        recyclerView = binding.recyclerViewSched
        recyclerView.adapter = adapter
        viewModel.getAllMoviesSched().observe(viewLifecycleOwner,{
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
                    viewModel.deleteMoviesSched(item as Item)
                    adapter.notifyItemRemoved(viewHolder.adapterPosition)

                }
            }
        )
        itemTouchHelper.attachToRecyclerView(recyclerView)
    }

    companion object {
        fun clickFilmsShedule(model: Item) {
            val bundle = Bundle()
            bundle.putSerializable("getFilms", model)
            MAIN.navController.navigate(R.id.action_detailedFragment_to_scheduleFragment, bundle)
        }
    }

}