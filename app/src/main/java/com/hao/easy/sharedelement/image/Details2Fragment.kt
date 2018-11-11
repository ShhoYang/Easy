package com.hao.easy.sharedelement.image

import android.graphics.Color
import android.graphics.drawable.BitmapDrawable
import android.graphics.drawable.ColorDrawable
import android.os.Parcelable
import android.support.v4.view.PagerAdapter
import android.support.v4.view.ViewCompat
import android.support.v4.view.ViewPager
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
import com.hw.ycshareelement.transition.ShareElementInfo
import java.util.*
import kotlin.collections.ArrayList

class Details2Fragment : BaseFragment() {

    var data: ArrayList<Image>? = null
    var viewPager: ViewPager? = null
    var adapter: Adapter? = null
    override fun getLayoutId(): Int {
        return R.layout.fragment_shared_element_details2
    }

    override fun initView() {
        data = arguments?.getParcelableArrayList<Image>(SharedElement2Fragment.KEY_DATA)
        viewPager = rootView.f(R.id.viewPager)
        adapter = Adapter(data!!)
        viewPager?.apply {
            adapter = this@Details2Fragment.adapter
        }

        val index = arguments?.getInt(SharedElement2Fragment.KEY_SELECT) ?: 0
        viewPager?.currentItem = index
        YcShareElement.postStartTransition(getActivity()!!)
    }

    override fun initData() {

    }

    fun getShareElements(): Array<ShareElementInfo<Parcelable>> {
        val parcelable = data?.get(viewPager!!.currentItem) as Parcelable
        var itemView = adapter!!.getItemView(0)
        if(itemView == null){
            return arrayOf()
        }else {
            return arrayOf(ShareElementInfo(itemView, parcelable))
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        BitmapThumbnail.clear()
    }

    inner class Adapter(val data: ArrayList<Image>) : PagerAdapter() {

        private val imageViewCache: LinkedList<ImageView> = LinkedList()

        override fun isViewFromObject(view: View, `object`: Any): Boolean {
            return view == `object`
        }

        override fun getCount(): Int {
            return data.size
        }

        override fun instantiateItem(container: ViewGroup, position: Int): Any {
            val imageView: ImageView
            if (imageViewCache.size > 0) {
                imageView = imageViewCache.remove()
            } else {
                imageView = ImageView(container.context)
                val layoutParams = ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                        ViewGroup.LayoutParams.MATCH_PARENT)
                imageView.layoutParams = layoutParams
                imageView.scaleType = ImageView.ScaleType.CENTER_CROP
                imageViewCache.add(imageView)
            }

            val url = data[position].url
            ViewCompat.setTransitionName(imageView, url)
            val thumbnail = if (url == BitmapThumbnail.key) BitmapThumbnail.bitmap else null
            val drawable = if (thumbnail == null) ColorDrawable(Color.GRAY) else BitmapDrawable(imageView.resources, thumbnail)

            Glide.with(imageView)
                    .load(data[position].url)
                    .apply(RequestOptions()
                            .diskCacheStrategy(DiskCacheStrategy.NONE)
                            .transform(FitCenter())
                            .skipMemoryCache(true)
                            .placeholder(drawable))
                    .into(imageView)


            container.addView(imageView)
            return imageView
        }

        override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
            val imageView = `object` as ImageView
            container.removeView(imageView)
            imageViewCache.add(imageView)
        }

        fun getItemView(position: Int): View? {
            if(imageViewCache.size<1){
                return  null
            }
            return imageViewCache.last
        }
    }
}
