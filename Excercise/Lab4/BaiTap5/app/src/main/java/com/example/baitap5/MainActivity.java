package com.example.baitap5;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

public class MainActivity extends AppCompatActivity {

    private GameView gameView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        gameView = new GameView(this);
        setContentView(gameView);
    }

    @Override
    protected void onResume() {
        super.onResume();
        gameView.resume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        gameView.pause();
    }

    class GameView extends SurfaceView implements Runnable {
        private Thread gameThread;
        private SurfaceHolder ourHolder;
        private volatile boolean playing;
        private Canvas canvas;
        private Bitmap bitmapRunningMan;
        private boolean isMoving;
        private float runSpeedperSecond = 250;
        private float manXpos = 10, manYPos = 10;
        private int frameWidth = 115, frameHeight = 137;
        private int frameCount = 8;
        private int currentFrame = 0;
        private long fps;
        private long timeThisFrame;
        private long lastFrameChangeTime = 0;
        private int frameLengthInMilisecond = 100;

        private Rect frameToDraw = new Rect(0, 0, frameWidth, frameHeight);
        private RectF whereToDraw = new RectF(manXpos, manYPos, manXpos + frameWidth, frameHeight);

        public GameView(Context context) {
            super(context);
            ourHolder = getHolder();
            bitmapRunningMan = BitmapFactory.decodeResource(getResources(), R.drawable.runningman1);
            bitmapRunningMan = Bitmap.createScaledBitmap(bitmapRunningMan, frameWidth * frameCount, frameHeight, false);
        }

        @Override
        public void run() {
            while (playing) {
                long startFrameTime = System.currentTimeMillis();
                update();
                draw();

                timeThisFrame = System.currentTimeMillis() - startFrameTime;

                if (timeThisFrame >= 1) {
                    fps = 1000 / timeThisFrame;
                }
            }
        }

        private void update() {
            if (isMoving) {
                manXpos = manXpos + runSpeedperSecond / fps;

                if (manXpos > getWidth()) {
                    manYPos += (int) frameHeight;
                    manXpos = 10;
                }

                if (manYPos + frameHeight > getHeight()) {
                    manYPos = 10;
                }
            }
        }

        public void manageCurrentFrame() {
            long time = System.currentTimeMillis();

            if (isMoving) {
                if (time > lastFrameChangeTime + frameLengthInMilisecond) {
                    lastFrameChangeTime = time;
                    currentFrame++;

                    if (currentFrame >= frameCount) {
                        currentFrame = 0;
                    }
                }
            }

            frameToDraw.left = currentFrame * frameWidth;
            frameToDraw.right = frameToDraw.left + frameWidth;
        }

        public void draw() {
            if (ourHolder.getSurface().isValid()) {
                canvas = ourHolder.lockCanvas();
                canvas.drawColor(Color.WHITE);
                whereToDraw.set((int) manXpos, (int) manYPos, (int) manXpos + frameWidth, (int) manYPos + frameHeight);

                manageCurrentFrame();
                canvas.drawBitmap(bitmapRunningMan,frameToDraw,whereToDraw,null);
                ourHolder.unlockCanvasAndPost(canvas);
            }
        }
        public  void pause(){
            playing = false;
            try {
                gameThread.join();
            }catch (InterruptedException e){
                Log.e("ERR","Joining Thread");
            }
        }
        public  void resume(){
            playing = true;
            gameThread =new Thread(this);
            gameThread.start();
        }

        @Override
        public boolean onTouchEvent(MotionEvent event) {
            switch (event.getAction() & MotionEvent.ACTION_MASK){
                case MotionEvent.ACTION_DOWN:
                    isMoving = !isMoving;
                    break;
            }
            return  true;
        }
    }
}