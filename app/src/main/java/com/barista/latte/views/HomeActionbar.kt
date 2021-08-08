package com.barista.latte.views

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.constraintlayout.widget.ConstraintLayout
import com.barista.latte.databinding.HomeActionbarBinding

/**

 * Created by juhyang on 2021/06/29.

 */
class HomeActionbar : ConstraintLayout {
    private val binding: HomeActionbarBinding = HomeActionbarBinding.inflate(LayoutInflater.from(context), this, true)

    constructor(context: Context) : super(context)
    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    )
}
