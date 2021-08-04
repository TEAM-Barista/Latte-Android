package com.barista.latte.utils

import android.graphics.drawable.ShapeDrawable
import android.graphics.drawable.shapes.OvalShape
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions

/**

 * Created by juhyang on 2021/07/06.

 */
object ImageUtil {

    @BindingAdapter("imageFromUrl")
    fun bindImageFromUrl(view: ImageView, imageUrl: String?) {
        if (!imageUrl.isNullOrEmpty()) {
            Glide.with(view.context)
                    .load(imageUrl)
                    .transition(DrawableTransitionOptions.withCrossFade())
                    .into(view)
        }
    }

    fun setImageViewCircle(imageView : ImageView) {
        imageView.background = ShapeDrawable(OvalShape())
        imageView.clipToOutline = true
    }
}
