package com.hao.easy.sharedelement.image.to

import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import com.hao.easy.R
import com.hao.easy.base.BaseActivity
import com.hao.easy.sharedelement.image.Image
import com.hw.ycshareelement.YcShareElement
import com.hw.ycshareelement.transition.IShareElements
import com.hw.ycshareelement.transition.ShareElementInfo

class Details2Activity : BaseActivity(), IShareElements {

    private lateinit var fragment: Details2Fragment

    override fun onCreate(savedInstanceState: Bundle?) {
        YcShareElement.setEnterTransitions(this, this, true)
        super.onCreate(savedInstanceState)
    }


    override fun getLayoutId(): Int {

        return R.layout.activity_shared_element2
    }

    override fun initView() {
        window.setBackgroundDrawable(ColorDrawable(0xFF323232.toInt()))
        fragment = Details2Fragment()
        fragment.arguments = intent.extras
        supportFragmentManager.beginTransaction().add(R.id.frameLayout, fragment).commit()
    }

    override fun initData() {

    }

    override fun finishAfterTransition() {
        YcShareElement.finishAfterTransition(this, this)
        super.finishAfterTransition()
    }

    override fun getShareElements(): Array<ShareElementInfo<Image>>? {
        return fragment.getShareElements()
    }
}
