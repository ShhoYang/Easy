package com.hao.easy.sharedelement.image;

import android.os.Parcel;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;

import com.hw.ycshareelement.transition.ShareElementInfo;


/**
 * Created by huangwei on 2018/9/27.
 */
public class ShareContentInfo extends ShareElementInfo<Image> {

    public ShareContentInfo(@NonNull View view, @Nullable Image data) {
        super(view, data);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        super.writeToParcel(dest, flags);
    }

    protected ShareContentInfo(Parcel in) {
        super(in);
    }

    public static final Creator<ShareContentInfo> CREATOR = new Creator<ShareContentInfo>() {
        @Override
        public ShareContentInfo createFromParcel(Parcel source) {
            return new ShareContentInfo(source);
        }

        @Override
        public ShareContentInfo[] newArray(int size) {
            return new ShareContentInfo[size];
        }
    };
}
