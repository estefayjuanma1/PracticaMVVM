package com.example.practicamvvm.model

import Cupon
import androidx.lifecycle.MutableLiveData

    interface lMainRepository {

        fun loadList()
        fun getCupones() : MutableLiveData<List<Cupon>>
    }
