package com.hao.easy.sharedelement.image

import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.BitmapDrawable
import android.graphics.drawable.ColorDrawable
import android.os.Parcelable
import android.support.v4.view.ViewCompat
import android.support.v7.widget.GridLayoutManager
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
import com.hao.easy.base.BaseFragment
import com.hao.easy.extensions.f
import com.hw.ycshareelement.YcShareElement
import com.hw.ycshareelement.transition.IShareElements
import com.hw.ycshareelement.transition.ShareElementInfo

/**
 * @author Yang Shihao
 * @date 2018/11/3
 */
class SharedElement2Fragment : BaseFragment() {

    var recyclerView: RecyclerView? = null

    var adapter: Adapter? = null
    val data = ArrayList<Image>()


    companion object {
        const val KEY_DATA = "data"
        const val KEY_SELECT = "select"
        const val REQUEST_CONTENT = 223
    }

    override fun getLayoutId(): Int {
        return R.layout.fragment_shared_element2
    }

    override fun initView() {

        data.add(Image("http://phototask.c360dn.com/Fl-0qph8x14uLb2JwRzko8fOmfqw", 1024, 738))
        data.add(Image("http://phototask.c360dn.com/FuOUEYx1YLf9gUAykzueD9TzX8Lq", 1280, 800))
        data.add(Image("http://phototask.c360dn.com/Fo9D8NQqmbs3AAQASxnkPZRHF5Hv", 720, 1280))
        data.add(Image("http://phototask.c360dn.com/FhGeGKwB9Z6WvuaINQOuc7wm4vvj", 1600, 1280))
        data.add(Image("http://phototask.c360dn.com/Fn8kpRh_rarrSMIoEnnEPadNOuWi", 720, 1280))
        data.add(Image("http://phototask.c360dn.com/Fn3915H5n7AhYKJdpdlNjSbfPC5e", 1024, 640))
        data.add(Image("http://phototask.c360dn.com/FsOmrix9LiKJXKqi4vOU7fbUmlbQ", 1080, 960))

        adapter = Adapter(data)
        recyclerView = rootView.f(R.id.recyclerView)
        recyclerView?.apply {
            layoutManager = GridLayoutManager(context, 2)
            adapter = this@SharedElement2Fragment.adapter
        }
    }

    override fun initData() {

    }

    fun selectedShareElement(shareElementInfo: ShareElementInfo<Parcelable>) {
        val selectedImage = shareElementInfo.getData()
        val count = data.size
        for (i in 0..count) {
            if (data[i] == selectedImage) {
                val layoutManager = recyclerView?.layoutManager as GridLayoutManager
                layoutManager.scrollToPosition(i)
                return
            }
        }
    }

    inner class Adapter(var data: ArrayList<Image>) : RecyclerView.Adapter<VH>() {
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
            val view = LayoutInflater.from(parent.context).inflate(R.layout.item_image, parent, false)
            return VH(view)
        }

        override fun getItemCount(): Int {
            return data.size
        }

        override fun onBindViewHolder(holder: VH, position: Int) {
            val image = data[position]
            ViewCompat.setTransitionName(holder.ivThumbnail, image.url)
            Glide.with(holder.ivThumbnail)
                    .load(image.url)
                    .apply(RequestOptions()
                            .diskCacheStrategy(DiskCacheStrategy.NONE)
                            .transform(FitCenter())
                            .placeholder(ColorDrawable(Color.GRAY)))
                    .into(holder.ivThumbnail)
            holder.itemView.setOnClickListener {
                var drawable = holder.ivThumbnail.drawable
                if (drawable is BitmapDrawable) {
                    BitmapThumbnail.bitmap = drawable.bitmap
                    BitmapThumbnail.key = image.url
                }
                val intent = Intent(context, Details2Activity::class.java)
                intent.putParcelableArrayListExtra(KEY_DATA, data)
                intent.putExtra(KEY_SELECT, position)
                val options = YcShareElement.buildOptionsBundle(getActivity()!!, object : IShareElements {
                    override fun getShareElements(): Array<ShareElementInfo<Image>> {
                        return arrayOf(ShareElementInfo(holder.ivThumbnail, image))
                    }
                })
                startActivityForResult(intent, REQUEST_CONTENT, options)
            }
        }
    }

    class VH(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val ivThumbnail = itemView.f<ImageView>(R.id.ivThumbnail)
    }
}
