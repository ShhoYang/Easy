package com.hao.easy.progress;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.os.Bundle;
import android.util.Log;

import com.hao.easy.R;
import com.hao.easy.base.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @author Yang Shihao
 */
public class ProgressBarActivity extends BaseActivity {

    @BindView(R.id.progress1)
    MyProgressBar mProgress1;
    @BindView(R.id.progress2)
    MyProgressBar mProgress2;
    @BindView(R.id.progress3)
    MyProgressBar mProgress3;
    @BindView(R.id.progress4)
    MyProgressBar mProgress4;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_progress_bar;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {
        final int[][] data = {new int[]{40,60},new int[]{35,70},new int[]{40,80},new int[]{20,60}};
        ValueAnimator anim = ValueAnimator.ofInt(0, 100);
        anim.setDuration(5000);
        anim.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                int currentValue = (int) animation.getAnimatedValue();
                int[] data0 = data[0];
                mProgress1.setProgress(data0[0]*currentValue);
                mProgress1.setSecondaryProgress(data0[1]*currentValue);

                int[] data1 = data[1];
                mProgress2.setProgress(data1[0]*currentValue);
                mProgress2.setSecondaryProgress(data1[1]*currentValue);

                int[] data2 = data[2];
                mProgress3.setProgress(data2[0]*currentValue);
                mProgress3.setSecondaryProgress(data2[1]*currentValue);

                int[] data3 = data[3];
                mProgress4.setProgress(data3[0]*currentValue);
                mProgress4.setSecondaryProgress(data3[1]*currentValue);
            }
        });
        anim.start();
    }
}
