package com.kotlin.customview.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.kotlin.customview.R;

public class HistogramView extends View {
    private Path mPath;
    private Paint mPaint;
    private int mTextColor,mHistogramColor; 
    public HistogramView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        mPaint=new Paint();
        mPath=new Path();
        initAttrs(context,attrs);
    }

    private void initAttrs(Context context, AttributeSet attrs) {
        TypedArray typedArray=context.obtainStyledAttributes(attrs, R.styleable.HistogramView);
        mTextColor=typedArray.getColor(R.styleable.HistogramView_textColor,Color.BLACK);
        mHistogramColor=typedArray.getColor(R.styleable.HistogramView_histogramColor,Color.GREEN);
        typedArray.recycle();
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //绘制坐标轴
        mPaint.reset();
        mPath.reset();
        mPaint.setColor(Color.BLACK);
        mPaint.setStyle(Paint.Style.STROKE);
        mPath.moveTo(100,100);
        mPath.rLineTo(0,402);
        mPath.rLineTo(800,0);
        canvas.drawPath(mPath,mPaint);
        //绘制文字
        mPaint.reset();
        mPaint.setColor(mTextColor);
        mPaint.setTextSize(30);
        mPaint.setStyle(Paint.Style.FILL);
        canvas.drawText("a",160,540,mPaint);
        canvas.drawText("s",280,540,mPaint);
        canvas.drawText("c",380,540,mPaint);
        canvas.drawText("d",480,540,mPaint);
        canvas.drawText("j",560,540,mPaint);
        canvas.drawText("w",690,540,mPaint);
        canvas.drawText("m",790,540,mPaint);
        mPaint.reset();
        mPaint.setColor(mHistogramColor);
        mPaint.setStrokeWidth(80);
        float[] lines={
                200,500,200,495,
                300,500,300,480,
                400,500,400,480,
                500,500,500,300,
                600,500,600,200,
                700,500,700,150,
                800,500,800,350,
        };
        canvas.drawLines(lines,mPaint);

    }

}
