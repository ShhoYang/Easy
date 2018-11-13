package com.hao.easy.router.module1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.hao.easy.router.annotation.Route;
import com.hao.easy.router.core.Router;

@Route(path = "/module1/Module1Activity")
public class Module1Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_module1);
        findViewById(R.id.tv).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Router.getInstance().build("/module2/Module2Activity")
                        .withString("String", "test string").navigation();
            }
        });
    }
}
