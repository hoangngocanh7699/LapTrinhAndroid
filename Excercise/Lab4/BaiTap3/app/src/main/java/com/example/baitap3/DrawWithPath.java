package com.example.baitap3;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class DrawWithPath extends View {
    public boolean clear = false;
    public Paint paint = new Paint();
    public Path path = new Path();


    public DrawWithPath(Context context) {
        super(context);
    }

    public DrawWithPath(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

        paint.setStrokeWidth(5f);
        paint.setColor(Color.WHITE);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeJoin(Paint.Join.ROUND);

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        float eventX = event.getX();
        float eventY = event.getY();
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                path.moveTo(eventX, eventY);
                return true;
            case MotionEvent.ACTION_MOVE:
                path.lineTo(eventX, eventY);
                break;
            default:
                return false;
        }

        invalidate(); //làm mất hiệu lực
        return true;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        //btnclear Click ==> clear = true ==> setColor: black......
        if (clear) {
            canvas.drawColor(Color.BLACK);
            path = new Path();
        }
        clear = false;
        canvas.drawPath(path, paint);
    }
}
