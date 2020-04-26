package com.example.practicamvvm.model.server
import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class cupones(
    @SerializedName("offers")
    val cupons: List<Cupon>,
    @SerializedName("result")
    val result: Boolean
)