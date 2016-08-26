package com.ldoublem.ringPregressLibrary;

import android.graphics.RectF;
import android.graphics.Region;

/**
 * Created by lumingmin on 16/8/24.
 */

public class Ring {

    private int progress;
    private String name;
    private String value;
    private RectF rectFRing;
    private int startColor;
    private int endColor;


    public Ring(int p,  String value, String name,int startColor, int endColor) {
        this.progress = p;
        this.name = name;
        this.value = value;
        this.startColor = startColor;
        this.endColor = endColor;

    }

    public Ring() {
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getProgress() {
        return progress;
    }

    public void setProgress(int progress) {
        this.progress = progress;
    }

    public RectF getRectFRing() {
        return rectFRing;
    }

    public void setRectFRing(RectF rectFRing) {
        this.rectFRing = rectFRing;
    }


    public int getStartColor() {
        return startColor;
    }

    public void setStartColor(int startColor) {
        this.startColor = startColor;
    }

    public int getEndColor() {
        return endColor;
    }

    public void setEndColor(int endColor) {
        this.endColor = endColor;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
