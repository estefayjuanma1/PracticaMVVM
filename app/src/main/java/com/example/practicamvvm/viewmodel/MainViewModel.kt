package com.example.practicamvvm.viewmodel

import Cupon
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.practicamvvm.model.MainObservable
import com.example.practicamvvm.view.CuponAdapter
import com.squareup.picasso.Picasso

class MainViewModel  : ViewModel(){
    private var mainObservable: MainObservable =
        MainObservable()
    private var cuponAdapter: CuponAdapter ? = null

    fun callCupones(){
        mainObservable.callCupones()
    }

    fun getCupones() : MutableLiveData<List<Cupon>> {
        return mainObservable.getCupones()
    }

    fun setCuponesInCuponesAdapter(cupones: List<Cupon>){
        cuponAdapter?.setCuponesList(cupones)
        cuponAdapter?.notifyDataSetChanged()
    }

    fun getRecyclerCuponesAdapter(): CuponAdapter? {
        cuponAdapter = CuponAdapter(this)
        return cuponAdapter
    }

    fun getCuponesAt(position: Int): Cupon?{
        var cupon: List<Cupon>? = mainObservable.getCupones().value
        return cupon?.get(position)
    }
    companion object{
        @JvmStatic
        @BindingAdapter("loadimage")
        fun loadimage(imageView: ImageView, imageURL: String){
            Picasso.get().load(imageURL)
        }
    }
}