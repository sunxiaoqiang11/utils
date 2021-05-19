package com.example.mylibrary.uite;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.GridView;

public class GridHengx extends GridView {
    public GridHengx(Context context) {
        super(context);
    }

    public GridHengx(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public GridHengx(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @SuppressLint("NewApi")
    public GridHengx(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int i = MeasureSpec.makeMeasureSpec((getWidth()/3) * getCount(), MeasureSpec.AT_MOST);
        super.onMeasure(i, heightMeasureSpec);
    }
}
