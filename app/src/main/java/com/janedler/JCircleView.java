package com.janedler;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.SweepGradient;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by janedler on 16/4/8.
 */
public class JCircleView extends View {

    private Context mContext;

    private static Paint mPaint;

    private int mScreenWidth;
    private int mScreenHeight;
    private int mPointX;
    private int mPointY;
    private int mInnerCircleRadius;
    private int mRingWidth;
    private float[] mPositions = null;


    static {
        mPaint = new Paint();
        mPaint.setAntiAlias(true); //消除锯齿
        mPaint.setStyle(Paint.Style.STROKE); //绘制空心圆
    }


    public JCircleView(Context context) {
        super(context);
        initView(context);
    }

    public JCircleView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView(context);
    }

    /**
     * 计算控件的大小
     */
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        mScreenHeight = this.getMeasuredHeight();
        mScreenWidth = this.getMeasuredWidth();
        int measureWidth = measureWidth(widthMeasureSpec);
        int measureHeight = measureHeight(heightMeasureSpec);
        setMeasuredDimension(measureWidth, measureHeight);
    }

    private int measureHeight(int pHeightMeasureSpec) {
        int result = 0;
        int heightMode = MeasureSpec.getMode(pHeightMeasureSpec);
        int heightSize = MeasureSpec.getSize(pHeightMeasureSpec);
        switch (heightMode) {
            case MeasureSpec.AT_MOST:
            case MeasureSpec.EXACTLY:
                result = heightSize;
                break;
        }
        return result;
    }

    private int measureWidth(int pWidthMeasureSpec) {
        int result = 0;
        int widthMode = MeasureSpec.getMode(pWidthMeasureSpec);// 得到模式
        int widthSize = MeasureSpec.getSize(pWidthMeasureSpec);// 得到尺寸
        switch (widthMode) {
            case MeasureSpec.AT_MOST:
            case MeasureSpec.EXACTLY:
                result = widthSize;
                break;
        }
        return result;
    }


    private void initView(Context context){
        this.mContext = context;
        mInnerCircleRadius = UnitUtil.dip2px(mContext,60);
        mRingWidth = UnitUtil.dip2px(mContext, 8); //设置圆环宽度

    }


    @Override
    protected void onDraw(Canvas canvas) {
        mPointX = mScreenWidth/2;
        mPointY = mScreenHeight/2;

        mPaint.setColor(Color.LTGRAY);
        mPaint.setShader(null);
        this.mPaint.setStrokeWidth(1);
        canvas.drawCircle(mPointX,mPointY, mInnerCircleRadius, this.mPaint);

        SweepGradient gradient = new SweepGradient(mPointX,mPointY,
                new int[] { Color.RED,Color.LTGRAY,Color.WHITE},
                mPositions);
        mPaint.setShader(gradient);
        this.mPaint.setStrokeWidth(mRingWidth);
        canvas.drawCircle(mPointX, mPointY, mInnerCircleRadius + 1 + mRingWidth / 2, this.mPaint);

        mPaint.setColor(Color.LTGRAY);
        mPaint.setShader(null);
        this.mPaint.setStrokeWidth(1);
        canvas.drawCircle(mPointX,mPointY, mInnerCircleRadius+1+mRingWidth, this.mPaint);

        super.onDraw(canvas);
    }

    public void setSweepGradientPositions(float positions[]){
        this.mPositions = positions;

    }

    public void jCircleInvalidate(){
        this.postInvalidate();
    }

}
