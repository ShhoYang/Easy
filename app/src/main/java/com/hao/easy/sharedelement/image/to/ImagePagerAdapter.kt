package com.hao.easy.sharedelement.image.to

import android.graphics.Color
import android.graphics.drawable.BitmapDrawable
import android.graphics.drawable.ColorDrawable
import android.support.v4.view.PagerAdapter
import android.support.v4.view.ViewCompat
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.load.resource.bitmap.FitCenter
import com.bumptech.glide.request.RequestOptions
import com.hao.easy.R
import com.hao.easy.extensions.f
import com.hao.easy.sharedelement.image.BitmapThumbnail
import com.hao.easy.sharedelement.image.Image
import java.util.*

class ImagePagerAdapter(val data: ArrayList<Image>) : PagerAdapter() {

    private val cacheViews: LinkedList<VH> = LinkedList()

    override fun getCount(): Int {
        return data.size
    }

    override fun isViewFromObject(view: View, obj: Any): Boolean {
        val holder = obj as VH
        return view == holder.itemView
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val image = data[position]
        var holder: VH? = getCacheView()
        if (holder == null) {
            holder = createViewHolder(container)
        }

        container.addView(holder.itemView)
        holder.itemView.tag = position
        val imageView = holder.imageView
        val url = image.url
        ViewCompat.setTransitionName(imageView, url)
        val thumbnail = if (url == BitmapThumbnail.key) BitmapThumbnail.bitmap else null
        val drawable = if (thumbnail == null) ColorDrawable(Color.GRAY) else BitmapDrawable(imageView.resources, thumbnail)

        Glide.with(imageView)
                .load(url)
                .apply(RequestOptions()
                        .diskCacheStrategy(DiskCacheStrategy.NONE)
                        .transform(FitCenter())
                        .skipMemoryCache(true)
                        .placeholder(drawable))
                .into(imageView)
        return holder
    }

    override fun destroyItem(container: ViewGroup, position: Int, obj: Any) {
        val holder = obj as VH
        container.removeView(holder.itemView)
        cacheViews.add(holder)
    }

    private fun getCacheView(): VH? {
        return if (cacheViews.isEmpty()) {
            null
        } else {
            cacheViews.pop()
        }
    }

    private fun createViewHolder(container: ViewGroup): VH {
        val view = LayoutInflater.from(container.context).inflate(R.layout.item_shared_element_image2, container, false)
        return VH(view)
    }
}

class VH(val itemView: View) {
    val imageView = itemView.f<ImageView>(R.id.ivThumbnail)
}
