package com.hao.easy.mvvm.view

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.FrameLayout
import com.hao.easy.mvvm.R
import com.hao.easy.mvvm.extensions.visibility
import kotlinx.android.synthetic.main.toolbar.view.*


/**
 * @author Yang Shihao
 * @date 2018/11/21
 */
class ToolbarLayout : FrameLayout {

    var title: CharSequence? = ""
        set(value) {
            field = value
            toolbarTitle?.text = title
        }

    private var showBack: Boolean = true

    constructor(context: Context) : super(context) {
        init(context, null)
    }

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        init(context, attrs)
    }

    fun setBackClickListener(f: () -> Unit) {
        toolbarBack.setOnClickListener { f() }
    }

    private fun init(context: Context, attrs: AttributeSet?) {
        View.inflate(context, R.layout.toolbar, this)
        attrs?.let {
            val typedArray = context.obtainStyledAttributes(it, R.styleable.ToolbarLayout)
            typedArray.apply {
                title = getString(R.styleable.ToolbarLayout_title)
                showBack = getBoolean(R.styleable.ToolbarLayout_showBack, true)
                recycle()
            }
        }
    }

    override fun onFinishInflate() {
        super.onFinishInflate()
        toolbarTitle.text = title
        toolbarBack.visibility(showBack)
    }
}