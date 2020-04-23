
import com.google.gson.annotations.SerializedName

data class cupones(
    @SerializedName("offers")
    val cupons: List<Cupon>,
    @SerializedName("result")
    val result: Boolean
)