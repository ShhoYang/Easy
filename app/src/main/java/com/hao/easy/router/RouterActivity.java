package com.hao.easy.router;

import com.hao.easy.R;
import com.hao.easy.base.BaseActivity;
import com.hao.easy.router.annotation.Route;
import com.hao.easy.router.core.Router;

import butterknife.OnClick;

/**
 * @author Yang Shihao
 */
@Route(path = "/main/RouterActivity")
public class RouterActivity extends BaseActivity {

    @Override
    protected int getLayoutId() {
        return R.layout.activity_router;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {

    }

    @OnClick(R.id.btn1)
    public void onBtn1Clicked() {
        Router.getInstance().build("/module1/Module1Activity").navigation();
    }

    @OnClick(R.id.btn2)
    public void onBtn2Clicked() {
        Router.getInstance().build("/module2/Module2Activity").navigation();
    }
}
