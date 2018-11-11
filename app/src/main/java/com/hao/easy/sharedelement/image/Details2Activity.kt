package com.hao.easy.sharedelement.image

import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.os.Parcelable
import com.hao.easy.R
import com.hao.easy.base.BaseActivity
import com.hw.ycshareelement.YcShareElement
import com.hw.ycshareelement.transition.IShareElements
import com.hw.ycshareelement.transition.ShareElementInfo

class Details2Activity : BaseActivity(), IShareElements {


    override fun onCreate(savedInstanceState: Bundle?) {
        YcShareElement.setEnterTransitions(this, this, true)
        super.onCreate(savedInstanceState)
    }

    var fragment: Details2Fragment? = null
    override fun getLayoutId(): Int {

        return R.layout.activity_shared_element2
    }

    override fun initView() {
        window.setBackgroundDrawable(ColorDrawable(0xFF323232.toInt()))
        fragment = Details2Fragment()
        fragment?.arguments = intent.extras
        supportFragmentManager.beginTransaction().add(R.id.frameLayout, fragment).commit()
    }

    override fun initData() {

    }

    override fun finishAfterTransition() {
        YcShareElement.finishAfterTransition(this, this)
        super.finishAfterTransition()
    }

    override fun getShareElements(): Array<ShareElementInfo<Parcelable>>? {
        return fragment?.getShareElements()
    }
}
