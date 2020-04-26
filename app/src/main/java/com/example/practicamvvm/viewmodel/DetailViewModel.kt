package com.example.practicamvvm.viewmodel

import android.os.Bundle
import android.os.PersistableBundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.BindingAdapter
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.practicamvvm.R
import com.example.practicamvvm.databinding.ActivityDetailBinding
import com.example.practicamvvm.model.server.Cupon
import com.squareup.picasso.Picasso
import java.io.Serializable

class DetailViewModel: ViewModel() {

   private var cupon: MutableLiveData<Cupon> = MutableLiveData()

    fun setDetailCupon (cupon: Cupon){
        this.cupon.value = cupon
    }

    fun getCupon(): MutableLiveData<Cupon> = cupon

    companion object{
        @JvmStatic
        @BindingAdapter("loadImageDetail")
        fun loadImageDetail(imageView: ImageView, imageUrl: String){
            Picasso.get().load(imageUrl).into(imageView)
        }}
}

