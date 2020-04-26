package com.example.practicamvvm.model


import androidx.databinding.BaseObservable
import androidx.lifecycle.MutableLiveData
import com.example.practicamvvm.model.server.Cupon


class MainObservable: BaseObservable() {
    private var mainRepository: lMainRepository = MainRepository()
    fun callCupones(){
        mainRepository.loadList()
    }

    fun getCupones() : MutableLiveData<List<Cupon>> {
        return mainRepository.getCupones()
    }
}