package com.example.hoaiktt.drawing2;

import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Main2Activity extends AppCompatActivity implements View.OnClickListener {
    private DrawingShape mDraw;
    private Button mBtnAddShape, mBtnRemove;
    private static int mX = 800, mY = 700 ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        mDraw = (DrawingShape) findViewById(R.id.drawing);
        mBtnAddShape = (Button) findViewById(R.id.btnAdd);
        mBtnRemove = (Button) findViewById(R.id.btnRemove);
        mBtnAddShape.setOnClickListener(this);
        mBtnRemove.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        int x = RandomUntils.randomInt(mX);
        int y = RandomUntils.randomInt(mY);
        switch (view.getId()) {
            case R.id.btnAdd: {
                mDraw.clickDrawing(x, y);
            } break;
            case R.id.btnRemove: {
                //mDraw.isDeletingShape(x,y);
            }
            break;
        }
    }
}
