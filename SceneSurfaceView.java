package com.example.myapplication;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.view.MotionEvent;
import android.view.SurfaceView;

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

    // 区分点击与拖动事件
    private boolean isClick;
    // 拖动起始位置
    int downX = 0;
    int downY = 0;
    // 拖动起始结束时间
    private long startTime = 0;
    private long endTime = 0;

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



        switch(event.getAction()){

            case MotionEvent.ACTION_DOWN:
                downX = (int) event.getRawX();
                downY = (int) event.getRawY();

                // 当按下的时候设置isClick为false
                isClick = false;
                startTime = System.currentTimeMillis();

                break;
            case MotionEvent.ACTION_MOVE:

                //当按钮被移动的时候设置isClick为true
                isClick = true;

                int moveX = (int) event.getRawX() - downX;
                int moveY = (int) event.getRawY() - downY;

                mapShiftX = mapShiftX + moveX;
                mapShiftY = mapShiftY + moveY;

                downX = (int) event.getRawX();
                downY = (int) event.getRawY();

                break;
            case MotionEvent.ACTION_UP:
                endTime = System.currentTimeMillis();
                // 当从点击到弹起小于半秒的时候,则判断为点击,如果超过则不响应点击事件
                if ((endTime - startTime) > 0.1 * 1000L) {
                    isClick = true;
                } else {
                    isClick = false;
                }
                break;
        }

        // 重新绘制画面
        invalidate();

        // 不能用return super.onTouchEvent(event);
        return true;
    }
}
