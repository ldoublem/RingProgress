# RingProgress
a circle progress bar with effect
#Preview
![png](https://github.com/ldoublem/RingProgress/blob/master/shot/shot1.jpeg)

![gif](https://github.com/ldoublem/RingProgress/blob/master/shot/shot2.gif)
![gif](https://github.com/ldoublem/RingProgress/blob/master/shot/shot3.gif)
##Usage  xml
```
 <com.ldoublem.ringPregressLibrary.RingProgress
        android:id="@+id/ring_progress"
        android:layout_width="200dp"
        android:layout_height="200dp"
        app:bgColor="#707070"
        app:bgShadowColor="#ffffff"
        app:ringSweepAngle="360"
        app:ringWidthScale="0.75"
        app:rotate="270"
        app:showBackground="true"
        app:showBackgroundShadow="true"
        app:showRingCorner="true"
        >
  </com.ldoublem.ringPregressLibrary.RingProgress>
```
##java
```
      mRingProgress.setSweepAngle(360f);
      mRingProgress.setDrawBg(true, Color.rgb(168, 168, 168));
      mRingProgress.setDrawBgShadow(true, Color.argb(100, 235, 79, 56));
      mRingProgress.setCorner(true);
      mRingProgress.setOnSelectRing(new OnSelectRing() {
          @Override
          public void Selected(Ring r) {
         
          }
      });
       Ring r = new Ring(progress,text,title,startColor,endColor);
       List<Ring> mlistRing = new ArrayList<>();
       mlistRing.add(r);
       mRingProgress.setData(mlistRing, 1000);// if >0 animation ==0 null

```

## About me

An android developer in Hangzhou.

If you want to make friends with me, You can email to me.
my [email](mailto:1227102260@qq.com) :smiley:


License
=======

    The MIT License (MIT)

	Copyright (c) 2016 ldoublem

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

