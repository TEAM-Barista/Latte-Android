package com.barista.latte.utils

import android.graphics.drawable.ShapeDrawable
import android.graphics.drawable.shapes.OvalShape
import android.widget.ImageView

/**

 * Created by juhyang on 2021/07/06.

 */
object ImageUtil {

    fun setImageViewCircle(imageView : ImageView) {
        imageView.background = ShapeDrawable(OvalShape())
        imageView.clipToOutline = true
    }
}
