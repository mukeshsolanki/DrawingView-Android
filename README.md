<h1 align="center">DrawingView-Android</h1>
<p align="center">
  <a href="https://android-arsenal.com/api?level=9"> <img src="https://img.shields.io/badge/API-14%2B-blue.svg?style=flat" /></a>
  <a href="https://jitpack.io/#mukeshsolanki/DrawingView-Android"> <img src="https://jitpack.io/v/mukeshsolanki/DrawingView-Android.svg" /></a>
  <a href="http://android-arsenal.com/details/1/4042"> <img src="https://img.shields.io/badge/Android%20Arsenal-DrawingView--Android-brightgreen.svg?style=flat" /></a>
  <a href="https://travis-ci.org/mukeshsolanki/DrawingView-Android"> <img src="https://travis-ci.org/mukeshsolanki/DrawingView-Android.svg?branch=master" /></a>
  <a href="https://www.paypal.me/mukeshsolanki"> <img src="https://img.shields.io/badge/paypal-donate-yellow.svg" /></a>
  <br /><br />
  DrawingView is a simple view that lets you draw on screen using your fingers and lets you save the drawings as images.
</p>

![Demo](https://github.com/mukeshsolanki/DrawingView-Android/blob/master/ScreenShoot.gif)

## Getting started

Its really simple to integrate *DrawingView* in android. All you need to do make the following change to you build gradle.

Step 1. Add the JitPack repository to your build file. Add it in your root build.gradle at the end of repositories:

```java
allprojects {
  repositories {
    ...
    maven { url "https://jitpack.io" }
  }
}
```
Step 2. Add the dependency
```java
dependencies {
    implementation 'com.github.mukeshsolanki:DrawingView-Android:<latest-version>'
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
drawingView.loadImage(Bitmap bitmap); //Load image (your saved drawing)
```
