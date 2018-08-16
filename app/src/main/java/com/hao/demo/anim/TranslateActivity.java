package com.hao.demo.anim;

import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.TextView;

import com.hao.demo.R;
import com.hao.demo.base.BaseActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class TranslateActivity extends BaseActivity {


    @BindView(R.id.tv)
    TextView tv;

    TranslateAnimation translateAnimation;
    List<String> list = new ArrayList<>();

    @Override
    protected int getLayoutId() {
        return R.layout.activity_translate;
    }

    @Override
    protected void initView() {
        initAnim();
    }

    @Override
    protected void initData() {

    }

    int i = 0;

    public void start(View view) {
        i++;
        list.add("第" + i);
        startAnim();
    }

    public void cancel(View view) {
        if (translateAnimation != null) {
            translateAnimation.cancel();
        }
    }


    private void initAnim() {
        translateAnimation = new TranslateAnimation(
                Animation.RELATIVE_TO_SELF, -1.3F,
                Animation.RELATIVE_TO_SELF, 0,
                Animation.RELATIVE_TO_SELF, 0,
                Animation.RELATIVE_TO_SELF, 0);
        translateAnimation.setDuration(2000);
    }


    private boolean b = false;

    private void startAnim() {

        if (list.size() == 0 || b) {
            return;
        }

        final String s = list.get(0);
        tv.setText(s);
        translateAnimation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                b = true;
                Log.d(TAG, "onAnimationStart: ");
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                b = false;
                list.remove(s);
                Log.d(TAG, "onAnimationEnd: " + list.size());
                if (list.size() == 0) {

                } else {
                    startAnim();
                }
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        tv.startAnimation(translateAnimation);
    }
}
