package com.hao.easy.mvvm.base.adapter

import android.content.Context
import android.support.annotation.DrawableRes
import android.support.annotation.IdRes
import android.support.annotation.LayoutRes
import android.support.annotation.StringRes
import android.support.v7.widget.RecyclerView
import android.util.SparseArray
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView

class ViewHolder(val context: Context, parent: ViewGroup, @LayoutRes layoutId: Int) :
        RecyclerView.ViewHolder(LayoutInflater.from(context).inflate(layoutId, parent, false)) {

    val views = SparseArray<View>()

    fun <T : View> getView(viewId: Int): T {
        var view = views.get(viewId)
        if (view == null) {
            view = itemView.findViewById(viewId)
            if (view != null) {
                views.put(viewId, view)
            }
        }

        return view as T
    }

    fun setText(@IdRes viewId: Int, text: String): ViewHolder {
        var textView: TextView = getView(viewId)
        textView?.text = text
        return this
    }

    fun setText(@IdRes viewId: Int, @StringRes resId: Int): ViewHolder {
        var textView: TextView = getView(viewId)
        textView?.text = context.getString(resId)
        return this
    }

    fun setImageResource(@IdRes viewId: Int, @DrawableRes resId: Int): ViewHolder {
        var imageView: ImageView = getView(viewId)
        imageView?.setImageResource(resId)
        return this
    }

    fun setOnClickListener(viewId: Int, f: (View) -> Unit): ViewHolder {
        getView<View>(viewId)?.apply {
            setOnClickListener { f(this) }
        }
        return this
    }
}
