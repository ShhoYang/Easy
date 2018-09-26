package com.hao.easy.anim;

import android.animation.ValueAnimator;
import android.os.Handler;
import android.util.Log;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.hao.easy.R;
import com.hao.easy.base.BaseActivity;

import butterknife.BindView;
import butterknife.OnClick;

public class RotateActivity extends BaseActivity {

    @BindView(R.id.tv_reg)
    TextView tvReg;
    @BindView(R.id.rl_reg)
    RelativeLayout rlReg;
    @BindView(R.id.tv_login)
    TextView tvLogin;
    @BindView(R.id.rl_login)
    RelativeLayout rlLogin;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_rotate;
    }

    int w = 0;

    @Override
    protected void initView() {
        rlReg.setTranslationY(120);
        ViewGroup.LayoutParams layoutParams = rlReg.getLayoutParams();
        layoutParams.width = 480;
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                w = rlLogin.getMeasuredWidth();
                Log.d(TAG, "run: " + w);
            }
        }, 2000);
    }

    @Override
    protected void initData() {

    }

    @OnClick(R.id.tv_reg)
    public void onTvRegClicked() {
        ValueAnimator valueAnimator = ValueAnimator.ofInt(0, 120);
        valueAnimator.setDuration(1200);
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                int animatedValue = (int) valueAnimator.getAnimatedValue();
                if (animatedValue <= 60) {
                    rlLogin.setTranslationX(-animatedValue * 5);


                    rlReg.setTranslationX(animatedValue * 5);
                    rlReg.setTranslationY((60 - animatedValue) * 2);

                } else {
                    rlReg.bringToFront();


                    ViewGroup.LayoutParams layoutParams = rlReg.getLayoutParams();
                    layoutParams.width = (int) (w * 1.0F * (0.8 + 0.2F * (animatedValue - 60) / 60));
                    rlReg.requestLayout();
                    ViewGroup.LayoutParams layoutParams2 = rlLogin.getLayoutParams();
                    layoutParams2.width = (int) (w * 1.0F * (1.0F - 0.2 * (animatedValue - 60) / 60));
                    rlLogin.requestLayout();

                    rlLogin.setTranslationX((animatedValue - 120) * 5);
                    rlLogin.setTranslationY((animatedValue - 60) * 2);

                    rlReg.setTranslationX((120 - animatedValue) * 5);

                }

            }
        });
        valueAnimator.start();
    }

    @OnClick(R.id.tv_login)
    public void onTvLoginClicked() {
        ValueAnimator valueAnimator = ValueAnimator.ofInt(0, 120);
        valueAnimator.setDuration(1200);
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                int animatedValue = (int) valueAnimator.getAnimatedValue();
                if (animatedValue <= 60) {
                    rlLogin.setTranslationX(-animatedValue * 5);
                    rlLogin.setTranslationY((60 - animatedValue) * 2);

                    rlReg.setTranslationX(animatedValue * 5);


                } else {
                    rlLogin.bringToFront();


                    ViewGroup.LayoutParams layoutParams = rlLogin.getLayoutParams();
                    layoutParams.width = (int) (w * 1.0F * (0.8 + 0.2F * (animatedValue - 60) / 60));
                    rlLogin.requestLayout();
                    ViewGroup.LayoutParams layoutParams2 = rlReg.getLayoutParams();
                    layoutParams2.width = (int) (w * 1.0F * (1.0F - 0.2 * (animatedValue - 60) / 60));
                    rlReg.requestLayout();

                    rlReg.setTranslationX((120 - animatedValue) * 5);
                    rlReg.setTranslationY((animatedValue - 60) * 2);

                    rlLogin.setTranslationX((animatedValue - 120) * 5);

                }

            }
        });
        valueAnimator.start();
    }
}
