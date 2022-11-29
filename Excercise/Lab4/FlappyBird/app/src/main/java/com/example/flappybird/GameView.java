package com.example.flappybird;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Handler;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;

import java.util.Random;
import java.util.logging.LogRecord;

public class GameView extends View {
    //This is our custom View class
    android.os.Handler handler;
    Runnable runnable;
    final int UPDATE_MILLIS = 30;
    Bitmap backgound;
    Display display;
    Point point;
    int dWidth, dHeight;
    Rect rect;
    Bitmap[] birds;
    int birdFrame = 0;
    int velocity = 0, gravity = 3;
    int birdX, birdY;
    boolean gameState = false;
    int gap = 400;
    int minTubeOffset, maxTubeOffset;
    int numberOfTubes = 4;
    int distanceBetweenTubes;
    int[] tubeX = new int[numberOfTubes];
    int[] topTubeY = new int[numberOfTubes];
    Bitmap toptube, bottomtube;
    Random random;
    int tubeVelocity = 8;


    public GameView(Context context) {
        super(context);
        handler = new Handler();
        runnable = new Runnable() {
            @Override
            public void run() {
                invalidate();
            }
        };
        backgound = BitmapFactory.decodeResource(getResources(), R.drawable.background);
        display = ((Activity) getContext()).getWindowManager().getDefaultDisplay();
        point = new Point();
        display.getSize(point);
        dWidth = point.x;
        dHeight = point.y;
        rect = new Rect(0, 0, dWidth, dHeight);
        toptube = BitmapFactory.decodeResource(getResources(), R.drawable.toptube);
        bottomtube = BitmapFactory.decodeResource(getResources(), R.drawable.bottomtube);
        birds = new Bitmap[2];
        birds[0] = BitmapFactory.decodeResource(getResources(), R.drawable.bird1);
        birds[1] = BitmapFactory.decodeResource(getResources(), R.drawable.bird2);
        birdX = dWidth / 2 - birds[0].getWidth() / 2;
        birdY = dHeight / 2 - birds[0].getHeight() / 2;
        distanceBetweenTubes = dWidth * 3 / 4;
        maxTubeOffset = dHeight - minTubeOffset - gap;
        random = new Random();
        for (int i = 0; i < numberOfTubes; i++) {
            tubeX[i] = dWidth + i * distanceBetweenTubes;
            topTubeY[i] = minTubeOffset + random.nextInt(maxTubeOffset - minTubeOffset + 1);
        }


    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //canvas.drawBitmap(backgound, 0, 0, null);
        canvas.drawBitmap(backgound, null, rect, null);
        if (birdFrame == 0) {
            birdFrame = 1;
        } else {
            birdFrame = 0;
        }
        if (gameState) {
            if (birdY < dHeight - birds[0].getHeight() || velocity < 0) {
                velocity += gravity;
                birdY += velocity;
            }
            for (int i = 0; i < numberOfTubes; i++) {
                tubeX[i] -= tubeVelocity;
                if(tubeX[i] < -toptube.getWidth()){
                    tubeX[i] += numberOfTubes  *distanceBetweenTubes;
                    topTubeY[i] = minTubeOffset + random.nextInt(maxTubeOffset - minTubeOffset + 1);
                }
                canvas.drawBitmap(toptube, tubeX[i], topTubeY[i] - toptube.getHeight(), null);
                canvas.drawBitmap(bottomtube, tubeX[i], topTubeY[i] + gap, null);
            }
        }


        canvas.drawBitmap(birds[birdFrame], birdX, birdY, null);
        handler.postDelayed(runnable, UPDATE_MILLIS);
    }

    //Get the touch Events

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        int action = event.getAction();
        if (action == MotionEvent.ACTION_DOWN) {
            velocity = -30;
            gameState = true;
        }
        return true;
    }
}
