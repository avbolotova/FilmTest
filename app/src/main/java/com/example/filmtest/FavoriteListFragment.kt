package com.example.filmtest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils.isEmpty
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView

class FavoriteListFragment : Fragment() {


    companion object {
        const val TAG = "FavoriteListFragment"
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.d(TAG, "onCreateView")
        return inflater.inflate(R.layout.activity_favorite_listfragment, container, false)
    }


    inner class Observer(private val recyclerView: RecyclerView) :
        RecyclerView.AdapterDataObserver() {

        private var emptyLayout: View

        init {
            emptyLayout = inflateEmptyView(recyclerView)
            emptyLayout.visibility = View.GONE
            isEmpty()
        }

        private fun inflateEmptyView(view: View): View {
            return LayoutInflater.from(view.context).inflate(
                R.layout.favorite_activity, view.parent as ViewGroup
            )
        }

        private fun isEmpty() {
        }
    }
}
