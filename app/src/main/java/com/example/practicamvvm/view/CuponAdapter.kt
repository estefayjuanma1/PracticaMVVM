package com.example.practicamvvm.view


import Cupon
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.example.practicamvvm.R
import com.example.practicamvvm.BR
import com.example.practicamvvm.viewmodel.MainViewModel

class CuponAdapter(var mainViewModel: MainViewModel) :
    RecyclerView.Adapter<CuponAdapter.CuponViewHolder>() {

    private var cuponList : List<Cupon>? = null

    fun setCuponesList(cupones: List<Cupon>){
        this.cuponList = cupones
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CuponViewHolder {
        val layoutInflater: LayoutInflater = LayoutInflater.from(parent.context)
        val binding: ViewDataBinding =
            DataBindingUtil.inflate(layoutInflater,viewType,parent,false)
        return CuponViewHolder(binding)
    }

    override fun getItemCount(): Int = cuponList?.size?:0

    override fun onBindViewHolder(holder: CuponViewHolder, position: Int) {
        holder.setCupon(mainViewModel,position)
    }

    override fun getItemViewType(position: Int): Int {
        return getLayoutIdForPosition(position)
    }

    private fun getLayoutIdForPosition (position: Int): Int {
        return R.layout.cupon_list_item
    }

    class CuponViewHolder(binding: ViewDataBinding) : RecyclerView.ViewHolder(binding.root){

        private var binding: ViewDataBinding?= null

        init {
            this.binding = binding
        }

        fun setCupon(mainViewModel: MainViewModel, position: Int) {
            binding?.setVariable(BR.model, mainViewModel)
            binding?.setVariable(BR.position, position)
        }
    }
}