package com.example.practicamvvm.model


import androidx.lifecycle.MutableLiveData
import com.example.practicamvvm.model.server.Cupon

interface lMainRepository {

        fun loadList()
        fun getCupones() : MutableLiveData<List<Cupon>>
    }
