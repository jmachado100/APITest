package com.example.apitest

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.apitest.Models.Counties
import com.example.apitest.Network.Covid19Service
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

class Covid19ViewModel: ViewModel() {

    val service = Retrofit.Builder()
        .baseUrl("https://randomuser.me/")
        .addConverterFactory(MoshiConverterFactory.create())
        .build()
        .create(Covid19Service::class.java)

    fun getCountries(onFinish: (List<Counties>) -> Unit) = viewModelScope.launch {
        val response = service.getCountries()
        onFinish(response)
    }
}