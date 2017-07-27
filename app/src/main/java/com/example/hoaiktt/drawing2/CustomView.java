package com.example.hoaiktt.drawing2;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.annotation.Nullable;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by hoaiktt on 7/27/2017.
 */

public class CustomView extends View {
    private Paint mDrawingShape;
    private Paint mDrawing;
    private TextPaint mDrawingText;
    private static final String CONTENT = "Wow!";

    public CustomView(Context context) {
        super(context);
    }

    public CustomView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        setUpDrawing();
    }

    private void setUpDrawing() {
        mDrawingShape = new Paint(Paint.ANTI_ALIAS_FLAG);
        mDrawingShape.setColor(Color.parseColor("#cccccc"));
        mDrawingShape.setStrokeWidth(8);
        mDrawingShape.setStyle(Paint.Style.STROKE);
        mDrawingText = new TextPaint(Paint.ANTI_ALIAS_FLAG);
        mDrawingText.setColor(Color.parseColor("#000000"));
        mDrawingText.setTextSize(20);
        mDrawingText.setStyle(Paint.Style.STROKE);
        mDrawingText.setStrokeWidth(10);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        drawingText(canvas, 350, 300);
    }

    public void drawingText(Canvas drawCanvas, float wiewWith, float viewHeight) {
        Rect rect = new Rect();
        float x = 100;
        float y = 100;
        float left = (getWidth() - wiewWith) / 2;
        float top = (getHeight() - viewHeight) / 2;
        drawCanvas.drawRect(left, top, left + viewHeight, top + viewHeight, mDrawingShape);
        float textSize = mDrawingText.getTextSize();
        float textWith = mDrawingText.measureText(CONTENT);

        drawCanvas.drawRect((left+wiewWith-x)/2,(top+viewHeight-y)/2,(left+wiewWith-x)/2+x,(top+viewHeight-y)/2+y,mDrawingText);
      //  drawCanvas.drawText(CONTENT,top,top+viewHeight,mDrawingText);
    }

}
