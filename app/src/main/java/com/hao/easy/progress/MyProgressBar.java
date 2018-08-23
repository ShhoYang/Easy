package com.hao.easy.progress;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.ProgressBar;

/**
 * @author Yang Shihao
 */
public class MyProgressBar extends ProgressBar {

    String text;
    Paint paint;

    public MyProgressBar(Context context) {
        super(context);
        initPaint();
    }

    public MyProgressBar(Context context, AttributeSet attrs) {
        super(context, attrs);
        initPaint();
    }

    public MyProgressBar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initPaint();
    }

    private void initPaint() {
        paint = new Paint();
        paint.setColor(Color.WHITE);
        paint.setTextSize(36);

    }

    public void setLeftName(String text) {

    }

    private void setText(int progress) {
        int i = (progress * 100) / this.getMax();
        text = String.valueOf(i) + "%";
    }

    @Override
    public synchronized void setProgress(int progress) {
        setText(progress);
        super.setProgress(progress);
    }

    @Override
    protected synchronized void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        drawLeftText(canvas);
        drawRightText(canvas);
    }

    private void drawLeftText(Canvas canvas) {
        Rect rect = new Rect();
        paint.getTextBounds(name, 0, name.length(), rect);
        int x = 32;
        int y = (getHeight() / 2) - rect.centerY();
        canvas.drawText(name, x, y, paint);
    }

    private void drawRightText(Canvas canvas){
        Rect rect = new Rect();
        paint.getTextBounds(text, 0, text.length(), rect);
        int x = getWidth() - 32 - rect.width();
        int y = (getHeight() / 2) - rect.centerY();
        canvas.drawText(text, x, y, paint);
    }

    String name = "篮球游戏房";
}
