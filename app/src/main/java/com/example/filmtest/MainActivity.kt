package com.example.filmtest

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.widget.AppCompatButton
import androidx.core.content.ContextCompat
import androidx.fragment.app.replace
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.ui.NavigationUI
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.RecyclerView
import com.example.filmtest.databinding.ActivityMainBinding
import com.example.filmtest.model.Item
import com.example.filmtest.view.detailed.DetailedFragment
import com.example.filmtest.view.favorite.FavoriteFragment
import com.example.filmtest.view.main.MainAdapter
import com.example.filmtest.view.main.MainFragment
import com.example.filmtest.view.main.MainFragmentViewModel
import com.example.filmtest.view.shedule.ScheduleFragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.each_item.*


class MainActivity : AppCompatActivity() {

    private var mBinding: ActivityMainBinding ?= null
    private val binding get() = mBinding!!
    lateinit var navController: NavController
    private lateinit var bottomNavigationView: BottomNavigationView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        MAIN = this

        navController = Navigation.findNavController(this, R.id.fragmentContainerView)


        bottomNavigationView = findViewById(R.id.bottomMenu)


        bottomNavigationView.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.home -> supportFragmentManager.beginTransaction()
                    .replace(R.id.fragmentContainerView, MainFragment())
                    .commit()
                R.id.favorite -> supportFragmentManager.beginTransaction()
                    .replace(R.id.fragmentContainerView, FavoriteFragment())
                    .commit()
                R.id.schedule -> supportFragmentManager.beginTransaction()
                    .replace(R.id.fragmentContainerView, ScheduleFragment())
                    .commit()

                else -> {
                }
            }
            return@setOnItemSelectedListener true
        }

        val networkConnection = NetworkConnection(applicationContext)
        networkConnection.observe(this, Observer { isConnected ->
            if (isConnected) {
                layoutDisconected.visibility = View.GONE
                layoutConected.visibility = View.VISIBLE
            } else {
                layoutDisconected.visibility = View.VISIBLE
                layoutConected.visibility = View.GONE
            }
        })


    }


    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp()
    }



    override fun onBackPressed() {
        AlertDialog.Builder(this).apply {
            setTitle("Подтверждение")
            setMessage("Вы уверены, что хотите выйти из программы?")

            setPositiveButton("Да") { _, _ ->
                super.onBackPressed()
            }

            setNegativeButton("Нет") { _, _ ->
                // if user press no, then return the activity
            }
            setCancelable(true)
        }.create().show()
    }

}

















