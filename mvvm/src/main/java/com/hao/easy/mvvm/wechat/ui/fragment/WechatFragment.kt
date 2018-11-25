package com.hao.easy.mvvm.wechat.ui.fragment

import android.arch.lifecycle.Observer
import android.content.Context
import android.support.design.widget.AppBarLayout
import android.view.MotionEvent
import android.widget.ImageView
import com.hao.easy.mvvm.R
import com.hao.easy.mvvm.base.ui.BaseFragment
import com.hao.easy.mvvm.extensions.load
import com.hao.easy.mvvm.wechat.ui.adapter.FragmentWithTabAdapter
import com.hao.easy.mvvm.wechat.viewmodel.WechatViewModel
import com.socks.library.KLog
import com.youth.banner.BannerConfig
import com.youth.banner.loader.ImageLoader
import kotlinx.android.synthetic.main.fragment_wechat.*
import org.jetbrains.anko.support.v4.dimen
import javax.inject.Inject

/**
 * @author Yang Shihao
 * @date 2018/11/18
 */
class WechatFragment : BaseFragment() {

    companion object {
        private const val TAG = "WechatFragment"
    }

    @Inject
    lateinit var viewModel: WechatViewModel
    private var adapter: FragmentWithTabAdapter? = null

    private var startX = .0F
    private var startY = .0F
    private var enableRefresh = true
    private var bannerInit = false
    private var bannerHeight = 0

    override fun setUserVisibleHint(isVisibleToUser: Boolean) {
        super.setUserVisibleHint(isVisibleToUser)
        if (bannerInit) {
            if (isVisibleToUser) {
                banner.startAutoPlay()
            } else {
                banner.stopAutoPlay()
            }
        }
    }

    override fun getLayoutId() = R.layout.fragment_wechat

    override fun initInject() {
        fragmentComponent().inject(this)
    }

    override fun initView() {

        viewPager.setOnTouchListener { _, ev ->
            when (ev.action) {
                MotionEvent.ACTION_DOWN -> {
                    startX = ev.x
                    startY = ev.y
                }
                MotionEvent.ACTION_MOVE -> {
                    var endX = ev.x
                    var endY = ev.y
                    var distanceX = Math.abs(startX - endX)
                    var distanceY = Math.abs(startY - endY)
                    if (distanceX > distanceY) {
                        baseRefreshLayout.isEnabled = false
                    }
                }
                MotionEvent.ACTION_UP, MotionEvent.ACTION_CANCEL -> {
                    enableRefresh = true
                }
            }
            false
        }

        baseRefreshLayout.setOnRefreshListener {
            var currentFragment = adapter?.currentFragment
            if (currentFragment == null) {
                baseRefreshLayout.isRefreshing = false

            } else if (currentFragment is WechatArticlesFragment) {
                currentFragment.refresh()
            }
        }



        appBarLayout.addOnOffsetChangedListener(AppBarLayout.OnOffsetChangedListener { _, verticalOffset ->
            baseRefreshLayout.isEnabled = verticalOffset == 0 && enableRefresh
            if (bannerHeight <= 0) {
                bannerHeight = banner.measuredHeight - dimen(R.dimen.status_bar_height)
            }
            if (bannerHeight > 0) {
                banner.alpha = (bannerHeight + verticalOffset) * 1.0F / bannerHeight
            }
        })

        tabLayout.setupWithViewPager(viewPager)
        banner.setBannerStyle(BannerConfig.NOT_INDICATOR)
                .setImageLoader(object : ImageLoader() {
                    override fun displayImage(context: Context?, path: Any, imageView: ImageView) {
                        imageView.load(path)
                    }
                })
                .start()
        bannerInit = true
    }

    override fun initData() {
        KLog.d(TAG, "initData")
        viewModel.authorsLiveData.observe(this, Observer {
            adapter = FragmentWithTabAdapter(childFragmentManager, it!!)
            viewPager.adapter = adapter
        })

        viewModel.adLiveData.observe(this, Observer {
            banner.update(it)
        })

        viewModel.initData()
    }

    fun refreshFinished() {
        baseRefreshLayout.isRefreshing = false
    }
}