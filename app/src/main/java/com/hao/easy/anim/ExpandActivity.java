package com.hao.easy.anim;

import android.animation.ObjectAnimator;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.LinearLayout;

import com.hao.easy.R;
import com.hao.easy.base.BaseActivity;
import com.hao.easy.utils.DisplayUtils;

import butterknife.BindView;
import butterknife.OnClick;

public class ExpandActivity extends BaseActivity {

    @BindView(R.id.ll3)
    LinearLayout ll3;
    @BindView(R.id.ll2)
    LinearLayout ll2;
    @BindView(R.id.btn)
    Button btn;

    int h1, h2;
    boolean show = true;
    TranslateAnimation animationTop, animationBottom;
    ObjectAnimator objectAnimatorTop, objectAnimatorBottom, objectAnimatorOther;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_expand;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {
        h1 = DisplayUtils.dip2px( 44);
        h2 = DisplayUtils.dip2px( 88);
    }

    @OnClick(R.id.ll3)
    public void onLl3Clicked() {
        toast("3");
    }

    @OnClick(R.id.ll2)
    public void onLl2Clicked() {
        toast("2");
    }

    @OnClick(R.id.btn)
    public void onBtnClicked() {
        if (show) {
            hide();

        } else {
            show();

        }
        show = !show;
    }

    private void show() {

        objectAnimatorTop = ObjectAnimator.ofFloat(ll2, "translationY", -h1, 0);
        objectAnimatorBottom = ObjectAnimator.ofFloat(ll3, "translationY", -h2, 0);
        objectAnimatorOther = ObjectAnimator.ofFloat(btn, "translationY", -h2, 0);

        objectAnimatorTop.setDuration(500);
        objectAnimatorBottom.setDuration(500);
        objectAnimatorOther.setDuration(500);

        objectAnimatorTop.start();
        objectAnimatorBottom.start();
        objectAnimatorOther.start();
//        animationTop = new TranslateAnimation(Animation.RELATIVE_TO_SELF, 0,
//                Animation.RELATIVE_TO_SELF, 0, Animation.RELATIVE_TO_SELF, -1, Animation.RELATIVE_TO_SELF, 0);
//        animationBottom = new TranslateAnimation(Animation.RELATIVE_TO_SELF, 0,
//                Animation.RELATIVE_TO_SELF, 0, Animation.RELATIVE_TO_SELF, -2, Animation.RELATIVE_TO_SELF, 0);
//        animationTop.setDuration(500);
//        animationBottom.setDuration(500);
//        animationTop.setAnimationListener(new Animation.AnimationListener() {
//            @Override
//            public void onAnimationStart(Animation animation) {
//
//            }
//
//            @Override
//            public void onAnimationEnd(Animation animation) {
//                ll2.setVisibility(View.VISIBLE);
//            }
//
//            @Override
//            public void onAnimationRepeat(Animation animation) {
//
//            }
//        });
//        animationBottom.setAnimationListener(new Animation.AnimationListener() {
//            @Override
//            public void onAnimationStart(Animation animation) {
//
//            }
//
//            @Override
//            public void onAnimationEnd(Animation animation) {
//                ll3.setVisibility(View.VISIBLE);
//            }
//
//            @Override
//            public void onAnimationRepeat(Animation animation) {
//
//            }
//        });
//        ll2.startAnimation(animationTop);
//        ll3.startAnimation(animationBottom);
    }

    private void hide() {
        objectAnimatorTop = ObjectAnimator.ofFloat(ll2, "translationY", 0, -h1);
        objectAnimatorBottom = ObjectAnimator.ofFloat(ll3, "translationY", 0, -h2);
        objectAnimatorOther = ObjectAnimator.ofFloat(btn, "translationY", 0, -h2);

        objectAnimatorTop.setDuration(500);
        objectAnimatorBottom.setDuration(500);
        objectAnimatorOther.setDuration(500);

        objectAnimatorTop.start();
        objectAnimatorBottom.start();
        objectAnimatorOther.start();
//        animationTop = new TranslateAnimation(Animation.RELATIVE_TO_SELF, 0,
//                Animation.RELATIVE_TO_SELF, 0, Animation.RELATIVE_TO_SELF, 0, Animation.RELATIVE_TO_SELF, -1);
//        animationBottom = new TranslateAnimation(Animation.RELATIVE_TO_SELF, 0,
//                Animation.RELATIVE_TO_SELF, 0, Animation.RELATIVE_TO_SELF, 0, Animation.RELATIVE_TO_SELF, -2);
//        animationTop.setDuration(500);
//        animationTop.setFillAfter(true);
//        animationBottom.setDuration(500);
//        animationBottom.setFillAfter(true);
//        animationTop.setAnimationListener(new Animation.AnimationListener() {
//            @Override
//            public void onAnimationStart(Animation animation) {
//
//            }
//
//            @Override
//            public void onAnimationEnd(Animation animation) {
//               // ll2.setVisibility(View.GONE);
//            }
//
//            @Override
//            public void onAnimationRepeat(Animation animation) {
//
//            }
//        });
//        animationBottom.setAnimationListener(new Animation.AnimationListener() {
//            @Override
//            public void onAnimationStart(Animation animation) {
//
//            }
//
//            @Override
//            public void onAnimationEnd(Animation animation) {
//              //  ll3.setVisibility(View.GONE);
//            }
//
//            @Override
//            public void onAnimationRepeat(Animation animation) {
//
//            }
//        });
//        ll2.startAnimation(animationTop);
//        ll3.startAnimation(animationBottom);
    }
}
