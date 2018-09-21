package com.hao.easy.immersive;


import android.annotation.SuppressLint;
import android.content.pm.ActivityInfo;
import android.support.v7.app.ActionBar;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.hao.easy.R;
import com.hao.easy.base.BaseActivity;

import butterknife.OnClick;

/**
 * 横竖屏切换,动态显示和隐藏状态栏导航栏
 */
public class ImmersiveActivity extends BaseActivity {

    @Override
    protected int getLayoutId() {
        return R.layout.activity_immersive;
    }

    @Override
    protected void initView() {
    }

    @Override
    protected void initData() {

    }

    @OnClick(R.id.tv)
    public void onViewClicked() {
        if (getRequestedOrientation() == ActivityInfo.SCREEN_ORIENTATION_PORTRAIT) {
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
            //landscape();
            hideActionBar();
            hideNav();
        } else {
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
           // portrait();
            showActionBar();
            showNav();
        }
    }

    /**
     * 这种方法从横屏切换到竖屏要设置布局的顶部padding
     */
    private void portrait() {
        Window window = getWindow();
        //状态栏
        WindowManager.LayoutParams lp = window.getAttributes();
        lp.flags &= (~WindowManager.LayoutParams.FLAG_FULLSCREEN);
        window.setAttributes(lp);
        //控制View
        window.clearFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);

        int uiFlags = View.SYSTEM_UI_FLAG_LAYOUT_STABLE;
        window.getDecorView().setSystemUiVisibility(uiFlags);
    }

    private void landscape() {
        Window window = getWindow();
        WindowManager.LayoutParams lp = window.getAttributes();
        lp.flags |= WindowManager.LayoutParams.FLAG_FULLSCREEN;
        window.setAttributes(lp);
        window.addFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);

        int flag = View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_FULLSCREEN
                | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY;

        window.getDecorView().setSystemUiVisibility(flag);
    }

    @SuppressLint("RestrictedApi")
    private void showActionBar() {
        ActionBar ab = getSupportActionBar();
        if (ab != null && !ab.isShowing()) {
            ab.setShowHideAnimationEnabled(false);
            ab.show();
        }
    }

    @SuppressLint("RestrictedApi")
    private void hideActionBar() {
        ActionBar ab = getSupportActionBar();
        if (ab != null && ab.isShowing()) {
            ab.setShowHideAnimationEnabled(false);
            ab.hide();
        }
    }

    private void showNav() {
        Window window = getWindow();

        WindowManager.LayoutParams lp = window.getAttributes();
        lp.flags &= (~WindowManager.LayoutParams.FLAG_FULLSCREEN);
        window.setAttributes(lp);

        window.clearFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);

        View decorView = window.getDecorView();
        int systemUiVisibility = decorView.getSystemUiVisibility();
        int flags = View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_FULLSCREEN
                | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY;
        systemUiVisibility &= ~flags;
        decorView.setSystemUiVisibility(systemUiVisibility);
    }

    private void hideNav() {
        Window window = getWindow();

        WindowManager.LayoutParams lp = window.getAttributes();
        lp.flags |= WindowManager.LayoutParams.FLAG_FULLSCREEN;
        window.setAttributes(lp);

        window.addFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);

        int flags = View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_FULLSCREEN
                | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY;

        View decorView = window.getDecorView();
        decorView.setSystemUiVisibility(flags);
    }
}
