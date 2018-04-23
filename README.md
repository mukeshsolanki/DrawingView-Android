<h1 align="center">DrawingView-Android</h1>
<p align="center">
  <a href="https://jitpack.io/#mukeshsolanki/DrawingView-Android"><img src="https://jitpack.io/v/mukeshsolanki/DrawingView-Android/month.svg"/></a>
  <a href="https://android-arsenal.com/api?level=9"> <img src="https://img.shields.io/badge/API-14%2B-blue.svg?style=flat" /></a>
  <a href="https://jitpack.io/#mukeshsolanki/DrawingView-Android"> <img src="https://jitpack.io/v/mukeshsolanki/DrawingView-Android.svg" /></a>
  <a href="http://android-arsenal.com/details/1/4042"> <img src="https://img.shields.io/badge/Android%20Arsenal-DrawingView--Android-brightgreen.svg?style=flat" /></a>
  <a href="https://travis-ci.org/mukeshsolanki/DrawingView-Android"> <img src="https://travis-ci.org/mukeshsolanki/DrawingView-Android.svg?branch=master" /></a>
  <a href="https://opensource.org/licenses/Apache-2.0"><img src="https://img.shields.io/badge/License-Apache%202.0-blue.svg"/></a>
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

## Author
Maintained by [Mukesh Solanki](https://www.github.com/mukeshsolanki)

## Contribution
[![GitHub contributors](https://img.shields.io/github/contributors/mukeshsolanki/DrawingView-Android.svg)](https://github.com/mukeshsolanki/DrawingView-Android/graphs/contributors)

* Bug reports and pull requests are welcome.
* Make sure you use [square/java-code-styles](https://github.com/square/java-code-styles) to format your code.

## License
```
Copyright 2018 Mukesh Solanki

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```