package com.hao.easy.sharedelement.contacts

import android.app.Activity
import android.content.Intent
import android.os.Parcelable
import android.support.v4.app.ActivityCompat
import android.support.v4.view.ViewCompat
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.hao.easy.R
import com.hao.easy.extensions.f
import com.hao.easy.sharedelement.contacts.SharedElementActivity.Companion.KEY_CONTACT
import com.hw.ycshareelement.YcShareElement
import com.hw.ycshareelement.transition.ShareElementInfo
import com.hw.ycshareelement.transition.TextViewStateSaver

class ContactAdapter(var data: ArrayList<Contact>) : RecyclerView.Adapter<VH>() {

    private lateinit var activity: Activity

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        activity = parent.context as Activity
        val view = LayoutInflater.from(activity).inflate(R.layout.item_contacts, parent, false)
        return VH(view)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: VH, position: Int) {
        val contact = data[position]
        Glide.with(holder.ivAvatar).load(contact.avatarRes).apply(RequestOptions.circleCropTransform()).into(holder.ivAvatar)
        holder.tvName.text = contact.name
        holder.itemView.setOnClickListener {
            val intent = Intent(holder.itemView.context, DetailsActivity::class.java)
            intent.putExtra(KEY_CONTACT, contact)
            val bundle = YcShareElement.buildOptionsBundle(activity) {
                arrayOf(ShareElementInfo<Parcelable>(holder.ivAvatar),
                        ShareElementInfo(holder.tvName, TextViewStateSaver()))
            }

            ActivityCompat.startActivity(activity, intent, bundle)

        }
        ViewCompat.setTransitionName(holder.ivAvatar, "avatar:" + contact.name)
        ViewCompat.setTransitionName(holder.tvName, "name:" + contact.name)
    }
}


class VH(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val ivAvatar: ImageView = itemView.f(R.id.iv_avatar)
    val tvName: TextView = itemView.f(R.id.tv_name)
}
