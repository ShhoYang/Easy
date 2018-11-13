package com.hao.easy.sharedelement.contacts

import android.os.Parcelable
import android.support.v4.view.ViewCompat
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.hao.easy.R
import com.hao.easy.base.BaseActivity
import com.hw.ycshareelement.YcShareElement
import com.hw.ycshareelement.transition.IShareElements
import com.hw.ycshareelement.transition.ShareElementInfo
import com.hw.ycshareelement.transition.TextViewStateSaver
import kotlinx.android.synthetic.main.activity_shared_element_details.*

class DetailsActivity : BaseActivity() {

    override fun getLayoutId(): Int {
        return R.layout.activity_shared_element_details
    }

    override fun initView() {
        val contact: Contact = intent.getSerializableExtra(SharedElementActivity.KEY_CONTACT) as Contact
        Glide.with(ivAvatar).load(contact.avatarRes).apply(RequestOptions.circleCropTransform()).into(ivAvatar)
        tvName.text = contact.name
        tvDesc.text = contact.desc

        ViewCompat.setTransitionName(ivAvatar, "avatar:" + contact.name)
        ViewCompat.setTransitionName(tvName, "name:" + contact.name)
    }

    override fun initData() {
        YcShareElement.setEnterTransitions(this, { arrayOf(ShareElementInfo<Parcelable>(ivAvatar), ShareElementInfo(tvName, TextViewStateSaver())) }, false)
    }
}
