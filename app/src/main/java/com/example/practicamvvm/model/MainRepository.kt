package com.example.practicamvvm.model


import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.practicamvvm.model.server.ApiService
import com.example.practicamvvm.model.server.Cupon
import com.example.practicamvvm.model.server.cupones

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainRepository (): lMainRepository
{

    private var Cupones = MutableLiveData<List<Cupon>>()
    override  fun getCupones() : MutableLiveData<List<Cupon>> {
        return Cupones
    }
    override fun loadList() {
        val apiKey = "f5061e2538cc06e04b1b73e615bc7056"
        var cuponList: ArrayList<Cupon>?= ArrayList()
        ApiService.create()
            .getTopRated(apiKey)
            .enqueue(object : Callback<cupones> {
                override fun onFailure(call: Call<cupones>, t: Throwable) {
                    Log.e("error",t.message)
                    //    mainPresenter.showErrorMsg(t.message)
                }

                override fun onResponse(call: Call<cupones>, response: Response<cupones>) {
                    if (response.isSuccessful) {
                        cuponList = response.body()?.cupons as ArrayList<Cupon>
                        //       mainPresenter.envioLista(response.body()?.offers as ArrayList<Offer>)
                    }
                    Cupones.value = cuponList
                }
            })
    }
}