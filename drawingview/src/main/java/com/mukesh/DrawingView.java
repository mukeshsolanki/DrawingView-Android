package com.mukesh;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.support.annotation.ColorInt;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class DrawingView extends View {
  private static final float TOUCH_TOLERANCE = 4;
  private Bitmap bitmap;
  private Canvas canvas;
  private Path path;
  private Paint bitmapPaint;
  private Paint paint;
  private boolean drawMode;
  private float x, y;
  private float penSize = 10;
  private float eraserSize = 10;

  public DrawingView(Context c) {
    this(c, null);
  }

  public DrawingView(Context c, AttributeSet attrs) {
    this(c, attrs, 0);
  }

  public DrawingView(Context c, AttributeSet attrs, int defStyle) {
    super(c, attrs, defStyle);
    init();
  }

  private void init() {
    path = new Path();
    bitmapPaint = new Paint(Paint.DITHER_FLAG);
    paint = new Paint();
    paint.setAntiAlias(true);
    paint.setDither(true);
    paint.setColor(Color.BLACK);
    paint.setStyle(Paint.Style.STROKE);
    paint.setStrokeJoin(Paint.Join.ROUND);
    paint.setStrokeCap(Paint.Cap.ROUND);
    paint.setStrokeWidth(penSize);
    drawMode = true;
    paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SCREEN));
  }

  @Override protected void onSizeChanged(int w, int h, int oldw, int oldh) {
    super.onSizeChanged(w, h, oldw, oldh);
    if (bitmap == null) {
      bitmap = Bitmap.createBitmap(w, h, Bitmap.Config.ARGB_8888);
    }
    canvas = new Canvas(bitmap);
    canvas.drawColor(Color.TRANSPARENT);
  }

  @Override protected void onDraw(Canvas canvas) {
    super.onDraw(canvas);
    canvas.drawBitmap(bitmap, 0, 0, bitmapPaint);
    canvas.drawPath(path, paint);
  }

  private void touchStart(float x, float y) {
    path.reset();
    path.moveTo(x, y);
    this.x = x;
    this.y = y;
    canvas.drawPath(path, paint);
  }

  private void touchMove(float x, float y) {
    float dx = Math.abs(x - this.x);
    float dy = Math.abs(y - this.y);
    if (dx >= TOUCH_TOLERANCE || dy >= TOUCH_TOLERANCE) {
      path.quadTo(this.x, this.y, (x + this.x) / 2, (y + this.y) / 2);
      this.x = x;
      this.y = y;
    }
    canvas.drawPath(path, paint);
  }

  private void touchUp() {
    path.lineTo(x, y);
    canvas.drawPath(path, paint);
    path.reset();
    if (drawMode) {
      paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SCREEN));
    } else {
      paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
    }
  }

  @Override public boolean onTouchEvent(MotionEvent event) {
    float x = event.getX();
    float y = event.getY();
    switch (event.getAction()) {
      case MotionEvent.ACTION_DOWN:
        if (!drawMode) {
          paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        } else {
          paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SCREEN));
        }
        touchStart(x, y);
        invalidate();
        break;
      case MotionEvent.ACTION_MOVE:
        touchMove(x, y);
        if (!drawMode) {
          path.lineTo(this.x, this.y);
          path.reset();
          path.moveTo(x, y);
        }
        canvas.drawPath(path, paint);
        invalidate();
        break;
      case MotionEvent.ACTION_UP:
        touchUp();
        invalidate();
        break;
      default:
        break;
    }
    return true;
  }

  public void initializePen() {
    drawMode = true;
    paint.setAntiAlias(true);
    paint.setDither(true);
    paint.setStyle(Paint.Style.STROKE);
    paint.setStrokeJoin(Paint.Join.ROUND);
    paint.setStrokeCap(Paint.Cap.ROUND);
    paint.setStrokeWidth(penSize);
    paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SCREEN));
  }

  public void initializeEraser() {
    drawMode = false;
    paint.setColor(Color.parseColor("#f4f4f4"));
    paint.setStyle(Paint.Style.STROKE);
    paint.setStrokeWidth(eraserSize);
    paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
  }

  public void clear() {
    canvas.drawColor(Color.TRANSPARENT, PorterDuff.Mode.CLEAR);
    invalidate();
  }

  @Override public void setBackgroundColor(int color) {
    if (canvas == null) {
      canvas = new Canvas();
    }
    canvas.drawColor(color);
    super.setBackgroundColor(color);
  }

  public void setEraserSize(float size) {
    eraserSize = size;
    initializeEraser();
  }

  public void setPenSize(float size) {
    penSize = size;
    initializePen();
  }

  public float getEraserSize() {
    return eraserSize;
  }

  public float getPenSize() {
    return penSize;
  }

  public void setPenColor(@ColorInt int color) {
    paint.setColor(color);
  }

  public @ColorInt int getPenColor() {
    return paint.getColor();
  }

  public void loadImage(Bitmap bitmap) {
    this.bitmap = bitmap.copy(Bitmap.Config.ARGB_8888, true);
    canvas.setBitmap(this.bitmap);
    bitmap.recycle();
    invalidate();
  }

  public boolean saveImage(String filePath, String filename, Bitmap.CompressFormat format,
      int quality) {
    if (quality > 100) {
      Log.d("saveImage", "quality cannot be greater that 100");
      return false;
    }
    File file;
    FileOutputStream out = null;
    try {
      switch (format) {
        case PNG:
          file = new File(filePath, filename + ".png");
          out = new FileOutputStream(file);
          return bitmap.compress(Bitmap.CompressFormat.PNG, quality, out);
        case JPEG:
          file = new File(filePath, filename + ".jpg");
          out = new FileOutputStream(file);
          return bitmap.compress(Bitmap.CompressFormat.JPEG, quality, out);
        default:
          file = new File(filePath, filename + ".png");
          out = new FileOutputStream(file);
          return bitmap.compress(Bitmap.CompressFormat.PNG, quality, out);
      }
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      try {
        if (out != null) {
          out.close();
        }
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
    return false;
  }
}
