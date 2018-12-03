package com.hao.easy.mvvm.android.ui.fragment

import android.arch.lifecycle.Observer
import android.support.design.widget.AppBarLayout
import android.support.v7.widget.GridLayoutManager
import android.view.View
import android.view.WindowManager
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.ListPopupWindow
import com.gcssloop.widget.PagerGridLayoutManager
import com.gcssloop.widget.PagerGridSnapHelper
import com.hao.easy.mvvm.android.R
import com.hao.easy.mvvm.android.di.component.DaggerFragmentComponent
import com.hao.easy.mvvm.android.model.Article
import com.hao.easy.mvvm.android.ui.activity.ArticleActivity
import com.hao.easy.mvvm.android.ui.adapter.ArticleAdapter
import com.hao.easy.mvvm.android.ui.adapter.TypeAdapter
import com.hao.easy.mvvm.android.viewmodel.AndroidViewModel
import com.hao.easy.mvvm.base.App
import com.hao.easy.mvvm.base.extensions.gone
import com.hao.easy.mvvm.base.extensions.visible
import com.hao.easy.mvvm.base.ui.BaseListFragment
import com.hao.easy.mvvm.base.ui.WebActivity
import com.hao.easy.mvvm.base.ui.WebWithImageActivity
import kotlinx.android.synthetic.main.fragment_android.*
import org.jetbrains.anko.support.v4.dip
import javax.inject.Inject

/**
 * @author Yang Shihao
 * @date 2018/11/18
 */
class AndroidFragment : BaseListFragment<Article, AndroidViewModel>() {

    companion object {
        private const val TAG = "AndroidFragment"
    }

    @Inject
    lateinit var adapter: ArticleAdapter

    @Inject
    lateinit var typeAdapter: TypeAdapter

    override fun getLayoutId() = R.layout.fragment_android

    override fun initInject() {
        DaggerFragmentComponent.builder()
                .appComponent(App.instance.appComponent)
                .build().inject(this)
    }

    override fun initView() {
        super.initView()
        typeAdapter.itemClickListener = { _, item, _ ->
            this@AndroidFragment.context?.apply {
                ArticleActivity.start(this, item)
            }
        }

        val pagerGridLayoutManager = PagerGridLayoutManager(2, 4, PagerGridLayoutManager.HORIZONTAL)
        pagerGridLayoutManager.setPageListener(object : PagerGridLayoutManager.PageListener {
            override fun onPageSelect(pageIndex: Int) {
                if (pageIndex != currentPager && pageIndex < points.size) {
                    points[pageIndex].setImageResource(R.drawable.indicator_1)
                    points[currentPager].setImageResource(R.drawable.indicator_0)
                    currentPager = pageIndex
                }
            }

            override fun onPageSizeChanged(pageSize: Int) {
            }
        })

        rvType.apply {
            //layoutManager = GridLayoutManager(context, 2, GridLayoutManager.HORIZONTAL, false)
            layoutManager = pagerGridLayoutManager
            PagerGridSnapHelper().attachToRecyclerView(this)
            adapter = typeAdapter
        }
        appBarLayout.addOnOffsetChangedListener(AppBarLayout.OnOffsetChangedListener { _, verticalOffset ->
            baseRefreshLayout.isEnabled = verticalOffset == 0
        })
    }

    override fun initData() {
        super.initData()
        viewModel.typeLiveData.observe(this, Observer {
            typeAdapter.setData(it!!)
            line.visible()
            createPoints(it!!.size)
        })
    }

    override fun adapter() = adapter

    override fun itemClicked(view: View, item: Article, position: Int) {
        when (view.id) {
            R.id.ivLink, R.id.tvLink -> {
                context?.apply {
                    WebActivity.start(this, item.title, item.projectLink)
                }
            }
            R.id.ivFav -> {
                viewModel.collect(item, position)
            }
            else -> context?.apply {
                WebWithImageActivity.start(this, item.title, item.link)
            }
        }
    }

    private val points = ArrayList<ImageView>()

    private var currentPager = 0

    private fun createPoints(itemSize: Int) {
        if (itemSize < 9) {
            llPoint.gone()
            return
        }
        val count = if (itemSize % 8 == 0) itemSize / 8 else itemSize / 8 + 1
        points.clear()
        llPoint.removeAllViews()
        currentPager = 0
        var layoutParams = LinearLayout.LayoutParams(dip(8), dip(8))
        layoutParams.leftMargin = dip(4)
        layoutParams.rightMargin = dip(4)
        for (i in 0 until count) {
            val imageView = ImageView(this@AndroidFragment.context)
            imageView.layoutParams = layoutParams
            if (i == 0) {
                imageView.setImageResource(R.drawable.indicator_1)
            } else {
                imageView.setImageResource(R.drawable.indicator_0)
            }
            points.add(imageView)
            llPoint.addView(imageView)
        }
        llPoint.visible()
    }
}