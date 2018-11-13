package com.hao.easy.sharedelement.image.from

import android.graphics.Color
import android.graphics.drawable.BitmapDrawable
import android.graphics.drawable.ColorDrawable
import android.support.v4.view.ViewCompat
import android.support.v7.widget.RecyclerView
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

class ImageAdapter(var data: ArrayList<Image>) : RecyclerView.Adapter<VH>() {

     var itemClickListener: ItemClickListener? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_shared_element_image, parent, false)
        return VH(view)
    }



    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: VH, position: Int) {
        val imageView = holder.imageView
        val image = data[position]
        ViewCompat.setTransitionName(holder.imageView, image.url)
        Glide.with(imageView)
                .load(image.url)
                .apply(RequestOptions()
                        .diskCacheStrategy(DiskCacheStrategy.NONE)
                        .transform(FitCenter())
                        .placeholder(ColorDrawable(Color.GRAY)))
                .into(imageView)
        holder.itemView.setOnClickListener {
            var drawable = imageView.drawable
            if (drawable is BitmapDrawable) {
                BitmapThumbnail.bitmap = drawable.bitmap
                BitmapThumbnail.key = image.url
            }
            itemClickListener?.itemClicked(position)
        }
    }



    interface ItemClickListener {
        fun itemClicked(position: Int)
    }
}

class VH(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val imageView = itemView.f<ImageView>(R.id.ivThumbnail)

}
