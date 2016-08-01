[ ![Download](https://api.bintray.com/packages/mukeshsolanki/maven/drawingview/images/download.svg) ](https://bintray.com/mukeshsolanki/maven/drawingview/_latestVersion)
[![Release](https://jitpack.io/v/mukeshsolanki/DrawingView-Android.svg)](https://jitpack.io/#mukeshsolanki/DrawingView-Android)

# DrawingView-Android 
DrawingView is a simple view that lets you draw on screen using your fingers and lets you save the drawings as images.

![Demo](https://raw.githubusercontent.com/mukeshsolanki/MarkdownView-Android/master/Screenshots/demo.gif)

## Getting started

Its really simple to integrate *DrawingView* in android. All you need to do make the following change to you build gradle under the app module.
```Java
dependencies { 
    compile 'com.mukesh:drawingview:1.0.0'
}
```

## How to use DrawingView

Its fairly simple and straight forward to use *DrawingView* in you application. Just add the following in your layout where you want to display the DrawingView.

```XML
<com.mukesh.DrawingView
  android:id="@+id/scratch_pad"
  android:layout_width="match_parent"
  android:layout_height="match_parent"
  android:layout_above="@+id/buttons"
  />
```

and reference it in your activity/fragment and assign the DrawingView like wise.
```Java
DrawingView drawingView = (DrawingView) findViewById(R.id.scratch_pad);
drawingView.initializePen(); //To use the pen mode to draw on the screen
drawingView.initializeEraser(); //To use the eraser mode to clear the screen
drawingView.setBackgroundColor(@ColorInt int color); //To set the background color of the drawing view
drawingView.setEraserSize(float size); //To set the size of the eraser
drawingView.setPenSize(float size); //To set the size of the pen
drawingView.setPenColor(@ColorInt int color); //To set the color of the pen
drawingView.saveImage(String filePath, String filename, Bitmap.CompressFormat format, int quality); //To save the image after your done drawing
```
