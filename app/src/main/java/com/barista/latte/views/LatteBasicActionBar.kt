package com.barista.latte.views

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.constraintlayout.widget.ConstraintLayout
import com.barista.latte.databinding.LatteBasicActionbarBinding
import com.barista.latte.utils.ImageUtil

/**

 * Created by juhyang on 2021/06/29.

 */
class LatteBasicActionBar : ConstraintLayout {
    private val binding: LatteBasicActionbarBinding = LatteBasicActionbarBinding.inflate(LayoutInflater.from(context), this, true)

    constructor(context: Context) : super(context)
    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    )

    init {
        aboutView()
    }

    private fun aboutView() {
        ImageUtil.setImageViewCircle(binding.profileImage)
    }
}
