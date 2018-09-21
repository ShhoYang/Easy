package com.hao.easy.memory;

import android.content.Context;
import android.graphics.Bitmap;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.bitmap.CircleCrop;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;
import com.hao.easy.R;

import java.io.ByteArrayOutputStream;
import java.io.IOException;


/**
 * @author Yang Shihao
 * <p>
 * Glide图片管理类
 */

public class ImageManager {

    private RequestOptions requestOptions = new RequestOptions()
            .error(R.mipmap.ic_launcher_round)
            .skipMemoryCache(true)
            .dontAnimate()
            .encodeQuality(80)
            .diskCacheStrategy(DiskCacheStrategy.RESOURCE);

    private RequestOptions requestCircleOptions = new RequestOptions()
            .error(R.mipmap.ic_launcher_round)
            .diskCacheStrategy(DiskCacheStrategy.RESOURCE)
            .transform(new CircleCrop());

    private ImageManager() {

    }

    public static ImageManager getInstance() {
        return ImageManager.Holder.INSTANCE;
    }

    /**
     * 加载普通图片
     */
    public void loadImage(Context context, Object url, ImageView iv) {
        if (url == null) {
            Glide.with(context).load(R.mipmap.ic_launcher_round).apply(requestOptions).into(iv);
        } else {
            Glide.with(context).load(url).apply(requestOptions).into(iv);
        }
    }

    /**
     * 加载普通图片
     */
    public void loadGifImage(Context context, Object url, ImageView iv) {
        if (url == null) {
            Glide.with(context).load(R.mipmap.ic_launcher_round).apply(requestOptions).into(iv);
        } else {
            Glide.with(context).asGif().load(url).into(iv);
        }
    }

    public void loadImage(Context context, Object url, int ic_launcher_round, ImageView iv) {
        if (url == null) {
            Glide.with(context).load(ic_launcher_round).into(iv);
        } else {
            RequestOptions options = new RequestOptions()
                    .placeholder(ic_launcher_round)
                    .error(ic_launcher_round)
                    .diskCacheStrategy(DiskCacheStrategy.RESOURCE);
            Glide.with(context).load(url).apply(options).into(iv);
        }
    }

    /**
     * 加载圆形图片
     */
    public void loadCircleImage(Context context, Object url, ImageView iv) {
        if (url == null) {
            Glide.with(context).load(R.mipmap.ic_launcher_round).apply(requestCircleOptions).into(iv);
        } else {
            Glide.with(context).load(url).apply(requestCircleOptions).into(iv);
        }
    }

    public void loadCircleImage(Context context, Object url, int ic_launcher_round, ImageView iv) {
        if (url == null) {
            Glide.with(context).load(ic_launcher_round).apply(requestCircleOptions).into(iv);
        } else {
            RequestOptions options = new RequestOptions()
                    .placeholder(ic_launcher_round)
                    .error(ic_launcher_round)
                    .diskCacheStrategy(DiskCacheStrategy.RESOURCE)
                    .transform(new CircleCrop());
            Glide.with(context).load(url).apply(options).into(iv);
        }
    }

    /**
     * 加载圆角图片
     */
    public void loadRoundCornerImage(Context context, Object url, int radius, ImageView iv) {
        RequestOptions requestRoundOptions = new RequestOptions()
                .placeholder(R.mipmap.ic_launcher_round)
                .error(R.mipmap.ic_launcher_round)
                .diskCacheStrategy(DiskCacheStrategy.RESOURCE)
                .transform(new RoundedCorners(radius));
        Glide.with(context).load(url).apply(requestRoundOptions).into(iv);
    }

    /**
     * 加载Bitmap
     */
    public void loadImage(Context context, Bitmap bitmap, ImageView imageView) {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 30, baos);
        Glide.with(context).load(baos.toByteArray()).apply(requestOptions).into(imageView);
        if (bitmap != null) {
            bitmap.recycle();
            bitmap = null;
        }
        if (baos != null) {
            try {
                baos.close();
            } catch (IOException e) {
            }
        }
    }

    /**
     * 释放内存
     */
    public void clearMemory(Context context) {
        try {
            Glide.get(context).clearMemory();
        } catch (RuntimeException e) {

        }
    }

    /**
     * 清除磁盘缓存
     */
    public void clearDiskCache(final Context context) {
        try {
            Glide.get(context).clearDiskCache();
        } catch (RuntimeException e) {

        }
    }

    /**
     * 清除所有缓存
     */
    public void cleanAll(Context context) {
        clearDiskCache(context);
        clearMemory(context);
    }


    public static class Holder {
        public static final ImageManager INSTANCE = new ImageManager();
    }
}
