package com.example.practicamvvm.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.practicamvvm.R
import com.example.practicamvvm.databinding.ActivityMainBinding
import com.example.practicamvvm.viewmodel.MainViewModel

class MainActivity : AppCompatActivity() {
    private var mainViewModel : MainViewModel? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupBinding(savedInstanceState)
    }

    fun setupBinding(savedInstanceState: Bundle?){

        var activityMainBinding : ActivityMainBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_main)

        mainViewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        activityMainBinding.lifecycleOwner = this
        activityMainBinding.model = mainViewModel

        setUpListUpdate()

    }

    fun setUpListUpdate(){
        mainViewModel?.callCupones()

        mainViewModel?.getCupones()?.observe(this, Observer {
            Log.d("Cupon", it[0].title)
            mainViewModel?.setCuponesInCuponesAdapter(it)
        })
    }
}
