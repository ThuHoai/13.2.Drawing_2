package com.example.hoaiktt.drawing2;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.graphics.drawable.shapes.RectShape;
import android.graphics.drawable.shapes.Shape;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by hoaiktt on 7/27/2017.
 */

public class DrawingShape extends View {
    private List<ShapeDrawable> mListShape = new ArrayList<>();
    private Integer[] mListColor = new Integer[]{Color.RED, Color.GREEN,
            Color.YELLOW, Color.BLACK};

    public DrawingShape(Context context) {
        super(context);
    }

    public DrawingShape(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        for (ShapeDrawable shapes : mListShape) {
            shapes.draw(canvas);
        }

    }



    private ShapeDrawable makeShapwDraw(int x, int y) {
        int maxWith = getWidth() / 10;
        int maxHeight = getHeight() / 10;
        Shape shape;
        if (Math.random() < 0.5) {
            shape = new OvalShape();
        } else {
            shape = new RectShape();
        }
        //dua shape vao drawshape
        ShapeDrawable shapeD = new ShapeDrawable(shape);
        int with = RandomUntils.randomInt(maxWith) + 5;
        int height = RandomUntils.randomInt(maxHeight) + 5;
        shapeD.setBounds((x - with)/ 2, (y - height) / 2, (x - with )/2+with, (y - height )/ 2+height);
        shapeD.getPaint().setColor(RandomUntils.randomElement(mListColor));
        return (shapeD);
    }

    public boolean isDeletingShape(int x, int y) {
        for (ShapeDrawable shape : mListShape) {
            Rect bounds = shape.getBounds();
            if (bounds.contains(x, y)) {
                mListShape.remove(shape);
                return true;
            }
        }
        return false;
    }

    public void clickDrawing(int x, int y) {
        if (!isDeletingShape(x, y)) {
            mListShape.add(makeShapwDraw(x, y));
            invalidate(); //goi lai ham ondraw
        }

    }
}
