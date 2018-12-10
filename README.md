<h1 align="center">DrawingView-Android</h1>
<p align="center">
  <a class="badge-align" href="https://www.codacy.com/app/mukeshsolanki/DrawingView-Android?utm_source=github.com&amp;utm_medium=referral&amp;utm_content=mukeshsolanki/DrawingView-Android&amp;utm_campaign=Badge_Grade"><img src="https://api.codacy.com/project/badge/Grade/1657f302c30f47978e7b823d1d28c649"/></a>
  <a href="https://jitpack.io/#mukeshsolanki/DrawingView-Android"> <img src="https://jitpack.io/v/mukeshsolanki/DrawingView-Android/month.svg" /></a>
  <a href="https://jitpack.io/#mukeshsolanki/DrawingView-Android"> <img src="https://jitpack.io/v/mukeshsolanki/DrawingView-Android.svg" /></a>
  <a href="https://circleci.com/gh/mukeshsolanki/DrawingView-Android/tree/master"> <img src="https://circleci.com/gh/mukeshsolanki/DrawingView-Android/tree/master.svg?style=shield" /></a>
  <a href="https://opensource.org/licenses/MIT"><img src="https://img.shields.io/badge/License-MIT-blue.svg"/></a>
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
drawingView.clear(); //clear image
```

## Author
Maintained by [Mukesh Solanki](https://www.github.com/mukeshsolanki)

## Contribution
[![GitHub contributors](https://img.shields.io/github/contributors/mukeshsolanki/DrawingView-Android.svg)](https://github.com/mukeshsolanki/DrawingView-Android/graphs/contributors)

* Bug reports and pull requests are welcome.
* Make sure you use [square/java-code-styles](https://github.com/square/java-code-styles) to format your code.

## License
```
MIT License

Copyright (c) 2018 Mukesh Solanki

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
```
