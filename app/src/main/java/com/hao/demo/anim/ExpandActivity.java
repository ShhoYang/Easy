package com.hao.demo.anim;

import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.LinearLayout;

import com.hao.demo.R;
import com.hao.demo.base.BaseActivity;
import com.hao.demo.utils.DisplayUtils;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ExpandActivity extends BaseActivity {

    @BindView(R.id.ll3)
    LinearLayout mLl3;
    @BindView(R.id.ll2)
    LinearLayout mLl2;
    @BindView(R.id.btn)
    Button mBtn;

    int mh1, mh2;
    boolean mShow = true;
    TranslateAnimation mAnimationTop, mAnimationBottom;
    ObjectAnimator mObjectAnimatorTop, mObjectAnimatorBottom, mObjectAnimatorOther;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_expand;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {
        mh1 = DisplayUtils.dip2px(this, 44);
        mh2 = DisplayUtils.dip2px(this, 88);
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
        if (mShow) {
            hide();

        } else {
            show();

        }
        mShow = !mShow;
    }

    private void show() {

        mObjectAnimatorTop = ObjectAnimator.ofFloat(mLl2, "translationY", -mh1, 0);
        mObjectAnimatorBottom = ObjectAnimator.ofFloat(mLl3, "translationY", -mh2, 0);
        mObjectAnimatorOther = ObjectAnimator.ofFloat(mBtn, "translationY", -mh2, 0);

        mObjectAnimatorTop.setDuration(500);
        mObjectAnimatorBottom.setDuration(500);
        mObjectAnimatorOther.setDuration(500);

        mObjectAnimatorTop.start();
        mObjectAnimatorBottom.start();
        mObjectAnimatorOther.start();
//        mAnimationTop = new TranslateAnimation(Animation.RELATIVE_TO_SELF, 0,
//                Animation.RELATIVE_TO_SELF, 0, Animation.RELATIVE_TO_SELF, -1, Animation.RELATIVE_TO_SELF, 0);
//        mAnimationBottom = new TranslateAnimation(Animation.RELATIVE_TO_SELF, 0,
//                Animation.RELATIVE_TO_SELF, 0, Animation.RELATIVE_TO_SELF, -2, Animation.RELATIVE_TO_SELF, 0);
//        mAnimationTop.setDuration(500);
//        mAnimationBottom.setDuration(500);
//        mAnimationTop.setAnimationListener(new Animation.AnimationListener() {
//            @Override
//            public void onAnimationStart(Animation animation) {
//
//            }
//
//            @Override
//            public void onAnimationEnd(Animation animation) {
//                mLl2.setVisibility(View.VISIBLE);
//            }
//
//            @Override
//            public void onAnimationRepeat(Animation animation) {
//
//            }
//        });
//        mAnimationBottom.setAnimationListener(new Animation.AnimationListener() {
//            @Override
//            public void onAnimationStart(Animation animation) {
//
//            }
//
//            @Override
//            public void onAnimationEnd(Animation animation) {
//                mLl3.setVisibility(View.VISIBLE);
//            }
//
//            @Override
//            public void onAnimationRepeat(Animation animation) {
//
//            }
//        });
//        mLl2.startAnimation(mAnimationTop);
//        mLl3.startAnimation(mAnimationBottom);
    }

    private void hide() {
        mObjectAnimatorTop = ObjectAnimator.ofFloat(mLl2, "translationY", 0, -mh1);
        mObjectAnimatorBottom = ObjectAnimator.ofFloat(mLl3, "translationY", 0, -mh2);
        mObjectAnimatorOther = ObjectAnimator.ofFloat(mBtn, "translationY", 0, -mh2);

        mObjectAnimatorTop.setDuration(500);
        mObjectAnimatorBottom.setDuration(500);
        mObjectAnimatorOther.setDuration(500);

        mObjectAnimatorTop.start();
        mObjectAnimatorBottom.start();
        mObjectAnimatorOther.start();
//        mAnimationTop = new TranslateAnimation(Animation.RELATIVE_TO_SELF, 0,
//                Animation.RELATIVE_TO_SELF, 0, Animation.RELATIVE_TO_SELF, 0, Animation.RELATIVE_TO_SELF, -1);
//        mAnimationBottom = new TranslateAnimation(Animation.RELATIVE_TO_SELF, 0,
//                Animation.RELATIVE_TO_SELF, 0, Animation.RELATIVE_TO_SELF, 0, Animation.RELATIVE_TO_SELF, -2);
//        mAnimationTop.setDuration(500);
//        mAnimationTop.setFillAfter(true);
//        mAnimationBottom.setDuration(500);
//        mAnimationBottom.setFillAfter(true);
//        mAnimationTop.setAnimationListener(new Animation.AnimationListener() {
//            @Override
//            public void onAnimationStart(Animation animation) {
//
//            }
//
//            @Override
//            public void onAnimationEnd(Animation animation) {
//               // mLl2.setVisibility(View.GONE);
//            }
//
//            @Override
//            public void onAnimationRepeat(Animation animation) {
//
//            }
//        });
//        mAnimationBottom.setAnimationListener(new Animation.AnimationListener() {
//            @Override
//            public void onAnimationStart(Animation animation) {
//
//            }
//
//            @Override
//            public void onAnimationEnd(Animation animation) {
//              //  mLl3.setVisibility(View.GONE);
//            }
//
//            @Override
//            public void onAnimationRepeat(Animation animation) {
//
//            }
//        });
//        mLl2.startAnimation(mAnimationTop);
//        mLl3.startAnimation(mAnimationBottom);
    }
}
