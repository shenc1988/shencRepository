package com.example.myfirstapplication;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.view.MotionEvent;
import android.view.SurfaceView;
import android.view.SurfaceHolder;

public class SceneSurfaceView extends SurfaceView {

    // 画面表示用
    private Paint paint = new Paint();
    private Canvas canvas;

    // 每个单元格标准尺寸
    static final int BASE_SIZE = 100;

    // 地图位移显示基准
    static final int MAP_SHIFT_BASE = 0;
    // 地图位移记录
    int mapShiftX = 0;
    int mapShiftY = 0;
    // 地图位移最大值
    int mapShiftMaxX = 100;
    int mapShiftMaxY = 100;

    // 声明图片
    Bitmap bitmap_land;
    Bitmap bitmap_selected;

    public SceneSurfaceView(Context context) {
        super(context);
        // 设定调用onDraw方法
        setWillNotDraw(false);

        // 加载图片
        Resources res = context.getResources();
        bitmap_land = BitmapFactory.decodeResource(res, R.drawable.land);
        bitmap_selected = BitmapFactory.decodeResource(res, R.drawable.selected);

    }

    @Override
    protected void onDraw(Canvas canvas) {

        this.canvas = canvas;

        super.onDraw(canvas);
        // 画面表示
        onDraw_Main();
    }

    private void onDraw_Main() {
        // 图片裁剪
        Rect src=new Rect(0,0,0+BASE_SIZE,0+BASE_SIZE);
        canvas.drawBitmap(bitmap_land, src, new RectF(0 + mapShiftX,0 + mapShiftY,0 + BASE_SIZE + mapShiftX,0+BASE_SIZE + mapShiftY), paint);
        canvas.drawBitmap(bitmap_land, src, new RectF(100 + mapShiftX,100 + mapShiftY,100 + BASE_SIZE + mapShiftX,100+BASE_SIZE + mapShiftY), paint);
        canvas.drawBitmap(bitmap_land, src, new RectF(0 + mapShiftX,100 + mapShiftY,0 + BASE_SIZE + mapShiftX,100+BASE_SIZE + mapShiftY), paint);
        canvas.drawBitmap(bitmap_land, src, new RectF(100 + mapShiftX,0 + mapShiftY,100 + BASE_SIZE + mapShiftX,0+BASE_SIZE + mapShiftY), paint);
    }

    // 触摸屏响应
    @Override
    public boolean onTouchEvent(MotionEvent event) {

        int downX = 0;
        int downY = 0;
        int moveX = 0;
        int moveY = 0;

        switch(event.getAction()){

            case MotionEvent.ACTION_DOWN:
                downX = (int) event.getX();
                downY = (int) event.getY();
            case MotionEvent.ACTION_MOVE:
                moveX = (int) event.getX();
                moveY = (int) event.getY();
                mapShiftX = mapShiftX + (moveX - downX);
                mapShiftY = mapShiftY + (moveY - downY);
                onDraw_Main();
        }

//        int ax = (int) event.getX();
//        int ay = (int) event.getY();
//        // 判断触摸点
//        if(){
//
//        }

        return super.onTouchEvent(event);
    }
}
