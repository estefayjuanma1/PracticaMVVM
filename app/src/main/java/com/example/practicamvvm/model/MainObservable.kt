package com.example.practicamvvm.model

import Cupon
import androidx.databinding.BaseObservable
import androidx.lifecycle.MutableLiveData


class MainObservable: BaseObservable() {
    private var mainRepository: lMainRepository = MainRepository()
    fun callCupones(){
        mainRepository.loadList()
    }

    fun getCupones() : MutableLiveData<List<Cupon>> {
        return mainRepository.getCupones()
    }
}