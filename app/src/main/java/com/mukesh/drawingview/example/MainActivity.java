package com.mukesh.drawingview.example;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Environment;
import android.support.annotation.ColorInt;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import com.mukesh.DrawingView;
import com.pavelsikun.vintagechroma.ChromaDialog;
import com.pavelsikun.vintagechroma.IndicatorMode;
import com.pavelsikun.vintagechroma.OnColorSelectedListener;
import com.pavelsikun.vintagechroma.colormode.ColorMode;

public class MainActivity extends AppCompatActivity
    implements View.OnClickListener, SeekBar.OnSeekBarChangeListener {
  private Button mSaveButton, mPenButton, mEraserButton, mPenColorButton, mBackgroundColorButton,
      mLoadButton;
  private DrawingView mDrawingView;
  private SeekBar mPenSizeSeekbar, mEraserSeekbar;

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    initializeUI();
    setListeners();
  }

  private void setListeners() {
    mSaveButton.setOnClickListener(this);
    mPenButton.setOnClickListener(this);
    mEraserButton.setOnClickListener(this);
    mPenColorButton.setOnClickListener(this);
    mBackgroundColorButton.setOnClickListener(this);
    mPenSizeSeekbar.setOnSeekBarChangeListener(this);
    mEraserSeekbar.setOnSeekBarChangeListener(this);
    mLoadButton.setOnClickListener(this);
  }

  private void initializeUI() {
    mDrawingView = (DrawingView) findViewById(R.id.scratch_pad);
    mSaveButton = (Button) findViewById(R.id.save_button);
    mLoadButton = (Button) findViewById(R.id.load_button);
    mPenButton = (Button) findViewById(R.id.pen_button);
    mEraserButton = (Button) findViewById(R.id.eraser_button);
    mPenColorButton = (Button) findViewById(R.id.pen_color_button);
    mBackgroundColorButton = (Button) findViewById(R.id.background_color_button);
    mPenSizeSeekbar = (SeekBar) findViewById(R.id.pen_size_seekbar);
    mEraserSeekbar = (SeekBar) findViewById(R.id.eraser_size_seekbar);
  }

  @Override public void onClick(View view) {
    switch (view.getId()) {
      case R.id.save_button:
        mDrawingView.saveImage(Environment.getExternalStorageDirectory().toString(), "test",
            Bitmap.CompressFormat.PNG, 100);
        break;
      case R.id.load_button:
        Log.d("saveImage", "quality cannot be");
        mDrawingView.loadImage(BitmapFactory.decodeResource(getResources(), R.raw.image));
        Log.d("saveImage", "quality cannot bter that 100");
        break;
      case R.id.pen_button:
        mDrawingView.initializePen();
        break;
      case R.id.eraser_button:
        mDrawingView.initializeEraser();
        break;
      case R.id.pen_color_button:
        new ChromaDialog.Builder().initialColor(Color.GREEN)
            .colorMode(ColorMode.ARGB)
            .indicatorMode(IndicatorMode.HEX)
            .onColorSelected(new OnColorSelectedListener() {
              @Override public void onColorSelected(@ColorInt int color) {
                mDrawingView.setPenColor(color);
              }
            })
            .create()
            .show(getSupportFragmentManager(), "Pen color picker");
        break;
      case R.id.background_color_button:
        new ChromaDialog.Builder().initialColor(Color.GREEN)
            .colorMode(ColorMode.ARGB)
            .indicatorMode(IndicatorMode.HEX)
            .onColorSelected(new OnColorSelectedListener() {
              @Override public void onColorSelected(@ColorInt int color) {
                mDrawingView.setBackgroundColor(color);
              }
            })
            .create()
            .show(getSupportFragmentManager(), "Background color picker");
        break;
    }
  }

  @Override public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
    switch (seekBar.getId()) {
      case R.id.pen_size_seekbar:
        mDrawingView.setPenSize(i);
        break;
      case R.id.eraser_size_seekbar:
        mDrawingView.setEraserSize(i);
        break;
    }
  }

  @Override public void onStartTrackingTouch(SeekBar seekBar) {
  }

  @Override public void onStopTrackingTouch(SeekBar seekBar) {
  }
}
