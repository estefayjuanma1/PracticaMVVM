package com.example.practicamvvm.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.practicamvvm.R
import com.example.practicamvvm.databinding.ActivityDetailBinding
import com.example.practicamvvm.model.server.Cupon
import com.example.practicamvvm.viewmodel.DetailViewModel

class DetailActivity : AppCompatActivity() {
    private var detailViewModel : DetailViewModel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        setupBindig(savedInstanceState)
    }

    fun setupBindig(savedInstanceState: Bundle?){
        var activityDetailBinding: ActivityDetailBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_detail)

        detailViewModel = ViewModelProvider(this).get(DetailViewModel::class.java)

        activityDetailBinding.model = detailViewModel
        activityDetailBinding.lifecycleOwner = this

        detailViewModel?.setDetailCupon(intent?.getSerializableExtra("cupon") as Cupon)
    }

}
