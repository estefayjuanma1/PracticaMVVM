package com.example.practicamvvm.viewmodel


import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.practicamvvm.model.MainObservable
import com.example.practicamvvm.model.server.Cupon
import com.example.practicamvvm.view.CuponAdapter
import com.squareup.picasso.Picasso

class MainViewModel  : ViewModel(){
    private var mainObservable: MainObservable =
        MainObservable()
    private var cuponAdapter: CuponAdapter ? = null
    private var cuponSelected : MutableLiveData<Cupon> = MutableLiveData()

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

    fun getCuponSelected() : MutableLiveData<Cupon>{
        return cuponSelected
    }

    fun onItemClick(position: Int){
        val cupon = getCuponesAt(position)
        cuponSelected.value = cupon

    }
    companion object{
        @JvmStatic
        @BindingAdapter("loadImage")
        fun loadimage(imageView: ImageView, imageURL: String){
            if(!imageURL.isNullOrBlank())
                Picasso.get().load(imageURL).into(imageView)
        }
    }
}