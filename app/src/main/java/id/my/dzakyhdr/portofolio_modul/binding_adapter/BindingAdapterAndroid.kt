package id.my.dzakyhdr.portofolio_modul.binding_adapter

import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import coil.load
import id.my.dzakyhdr.portofolio_modul.data.Portofolio

@BindingAdapter("androidTitle")
fun TextView.setTitleAndroid(data: Portofolio?) {
    data?.let {
        text = it.title
    }
}

@BindingAdapter("androidImage")
fun ImageView.setAndroidImage(data: Portofolio) {
    this.setImagerResource(data.images)
}
