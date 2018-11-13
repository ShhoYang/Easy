package com.hao.easy.sharedelement.image.to

import android.support.v4.view.ViewPager
import android.widget.FrameLayout
import android.widget.ImageView
import com.hao.easy.R
import com.hao.easy.base.BaseFragment
import com.hao.easy.extensions.f
import com.hao.easy.sharedelement.image.BitmapThumbnail
import com.hao.easy.sharedelement.image.Image
import com.hao.easy.sharedelement.image.from.SharedElement2Fragment
import com.hw.ycshareelement.YcShareElement
import com.hw.ycshareelement.transition.ShareElementInfo

class Details2Fragment : BaseFragment() {

    private lateinit var data: ArrayList<Image>
    private lateinit var viewPager: ViewPager
    private lateinit var adapter: ImagePagerAdapter

    override fun getLayoutId(): Int {
        return R.layout.fragment_shared_element_details2
    }

    override fun initView() {
        data = arguments?.getParcelableArrayList<Image>(SharedElement2Fragment.KEY_DATA) ?: ArrayList()
        viewPager = rootView.f(R.id.viewPager)
        adapter = ImagePagerAdapter(data)
        val index = arguments?.getInt(SharedElement2Fragment.KEY_SELECT) ?: 0
        viewPager.apply {
            adapter = this@Details2Fragment.adapter
            currentItem = index
        }
        YcShareElement.postStartTransition(getActivity())
    }

    override fun initData() {

    }

    fun getShareElements(): Array<ShareElementInfo<Image>> {
        val position = viewPager.currentItem
        val itemView = viewPager.findViewWithTag<FrameLayout>(position)
        val imageView = itemView?.f<ImageView>(R.id.ivThumbnail)
        return if (imageView == null) {
            arrayOf()
        } else {
            arrayOf(ShareElementInfo(imageView, data[position]))
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        BitmapThumbnail.clear()
    }
}
