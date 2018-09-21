package com.hao.easy.memory;

import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.hao.easy.R;
import com.hao.easy.base.BaseActivity;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * @author Yang Shihao
 */
public class Memory3Activity extends BaseActivity {

    @BindView(R.id.iv)
    ImageView mIv;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_memory;
    }

    @Override
    protected void initView() {
        ImageManager.getInstance().loadImage(this, R.mipmap.ic_launcher, mIv);
    }

    @Override
    protected void initData() {

    }

    @OnClick(R.id.iv)
    public void onViewClicked() {
        startActivity(MemoryActivity.class);
        finish();
    }

    @Override
    protected void onStop() {
        Glide.with(this).clear(mIv);
        super.onStop();
    }
}
