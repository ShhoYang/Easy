package com.hao.demo.test;

import android.widget.Button;
import android.widget.EditText;

import com.hao.demo.R;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;


/**
 * @author Yang Shihao
 * @date 2018/8/11
 */
@RunWith(RobolectricTestRunner.class)
public class TestActivityTest {

    @Test
    public void clickButton() throws Exception{
        TestActivity testActivity = Robolectric.setupActivity(TestActivity.class);
        EditText editText = testActivity.findViewById(R.id.et);
        Button button = testActivity.findViewById(R.id.btn);
        button.performClick();
        Assert.assertEquals("robolectriic", editText.getText().toString());
    }

}