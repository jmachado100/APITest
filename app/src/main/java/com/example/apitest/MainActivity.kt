package com.example.apitest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.recyclerview_countries.view.*


private lateinit var covid19ViewModel: Covid19ViewModel

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        covid19ViewModel = ViewModelProvider(this).get(Covid19ViewModel::class.java)

        covid19ViewModel.getCountries { listCountries ->
            countries_rv?.apply {
                layoutManager = LinearLayoutManager(this@MainActivity, LinearLayoutManager.VERTICAL, false)
                adapter = ListAdapter(
                    R.layout.recyclerview_countries,
                    listCountries,
                    { itemView, item ->
                        itemView.item_country_title.text = item.Country
                    },
                    { _, item ->
                        //Do nothing onClick
                    }
                )

            }

        }


    }
}