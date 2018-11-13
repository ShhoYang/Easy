package com.hao.easy.sharedelement.image.from

import android.content.Intent
import android.os.Parcelable
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import android.widget.ImageView
import com.hao.easy.R
import com.hao.easy.base.BaseFragment
import com.hao.easy.extensions.f
import com.hao.easy.sharedelement.image.Image
import com.hao.easy.sharedelement.image.ShareContentInfo
import com.hao.easy.sharedelement.image.to.Details2Activity
import com.hw.ycshareelement.YcShareElement
import com.hw.ycshareelement.transition.IShareElements
import com.hw.ycshareelement.transition.ShareElementInfo

/**
 * @author Yang Shihao
 * @date 2018/11/3
 */
class SharedElement2Fragment : BaseFragment(), ImageAdapter.ItemClickListener, IShareElements {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: ImageAdapter
    private val data = ArrayList<Image>()

    private var index = 0

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

        adapter = ImageAdapter(data)
        adapter.itemClickListener = this
        recyclerView = rootView.f(R.id.recyclerView)
        recyclerView.apply {
            layoutManager = GridLayoutManager(context, 2)
            adapter = this@SharedElement2Fragment.adapter
        }
    }

    override fun initData() {

    }

    fun selectedShareElement(shareElementInfo: ShareElementInfo<Parcelable>) {
        val selectedImage = shareElementInfo.data
        val count = data.size
        for (i in 0..count) {
            if (data[i] == selectedImage) {
                index = i
                val layoutManager = recyclerView.layoutManager as GridLayoutManager
                layoutManager.scrollToPosition(i)
                return
            }
        }
    }

    override fun itemClicked(position: Int) {
        index = position
        val intent = Intent(context, Details2Activity::class.java)
        intent.putParcelableArrayListExtra(KEY_DATA, data)
        intent.putExtra(KEY_SELECT, position)
        val options = YcShareElement.buildOptionsBundle(getActivity()!!, this)
        startActivityForResult(intent, REQUEST_CONTENT, options)
    }

    override fun getShareElements(): Array<ShareElementInfo<Image>> {
        val itemView = recyclerView.getChildAt(index)
        var imageView = itemView.f<ImageView>(R.id.ivThumbnail)
        return arrayOf(ShareContentInfo(imageView, data[index]))
    }
}
