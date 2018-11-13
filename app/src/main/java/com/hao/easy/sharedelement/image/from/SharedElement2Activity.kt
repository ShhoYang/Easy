package com.hao.easy.sharedelement.image.from

import android.content.Intent
import android.os.Bundle
import android.os.Parcelable
import com.hao.easy.R
import com.hao.easy.base.BaseActivity
import com.hw.ycshareelement.YcShareElement
import com.hw.ycshareelement.transition.IShareElementSelector
import com.hw.ycshareelement.transition.ShareElementInfo

class SharedElement2Activity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        YcShareElement.enableContentTransition(application)
        super.onCreate(savedInstanceState)
    }

    lateinit var fragment: SharedElement2Fragment
    override fun getLayoutId(): Int {

        return R.layout.activity_shared_element2
    }

    override fun initView() {
        fragment = SharedElement2Fragment()
        supportFragmentManager.beginTransaction().add(R.id.frameLayout, fragment).commit()
    }

    override fun initData() {
    }

    override fun onActivityReenter(resultCode: Int, data: Intent?) {
        super.onActivityReenter(resultCode, data)
        YcShareElement.onActivityReenter(this, resultCode, data, object : IShareElementSelector {
            override fun selectShareElements(p0: MutableList<ShareElementInfo<Parcelable>>) {
                fragment.selectedShareElement(p0[0])
            }
        })
    }
}
