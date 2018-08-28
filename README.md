<h1 align="center">DrawingView-Android</h1>
<p align="center">
  <a class="badge-align" href="https://www.codacy.com/app/mukeshsolanki/DrawingView-Android?utm_source=github.com&amp;utm_medium=referral&amp;utm_content=mukeshsolanki/DrawingView-Android&amp;utm_campaign=Badge_Grade"><img src="https://api.codacy.com/project/badge/Grade/1657f302c30f47978e7b823d1d28c649"/></a>
  <a href="https://jitpack.io/#mukeshsolanki/DrawingView-Android"> <img src="https://jitpack.io/v/mukeshsolanki/DrawingView-Android.svg" /></a>
  <a href="https://circleci.com/gh/mukeshsolanki/DrawingView-Android/tree/master"> <img src="https://circleci.com/gh/mukeshsolanki/DrawingView-Android/tree/master.svg?style=shield" /></a>
  <a href="https://opensource.org/licenses/Apache-2.0"><img src="https://img.shields.io/badge/License-Apache%202.0-blue.svg"/></a>
  <br /><br />
  DrawingView is a simple view that lets you draw on screen using your fingers and lets you save the drawings as images.
</p>

![Demo](https://github.com/mukeshsolanki/DrawingView-Android/blob/master/ScreenShoot.gif)

# Support Country Picker for Android

Drawing View is an independent project with ongoing development and support made possible thanks to donations made by [these awesome backers](BACKERS.md#sponsors). If you'd like to join them, please consider:

- [Become a backer or sponsor on Patreon](https://www.patreon.com/mukeshsolanki).
- [One-time donation via PayPal](https://www.paypal.me/mukeshsolanki)

<a href="https://www.patreon.com/bePatron?c=935498" alt="Become a Patron"><img src="https://c5.patreon.com/external/logo/become_a_patron_button.png" /></a>

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