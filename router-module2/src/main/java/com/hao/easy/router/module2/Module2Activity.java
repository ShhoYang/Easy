package com.hao.easy.router.module2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.hao.easy.router.annotation.Route;

@Route(path = "/module2/Module2Activity")
public class Module2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_module2);

        String s = getIntent().getStringExtra("String");

        TextView textView = findViewById(R.id.tv);
        textView.append("\n" + s);
    }
}
