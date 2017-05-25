package com.example.android.miwok;

import android.content.Context;

/**
 * Created by mingjingtang on 5/16/17.
 */

public class Word {
    private String miwokWordTranslation;
    private String defaultWordTranslation;
    private int resourceId = NO_IMAGE_PROVIDED;
    private static final int NO_IMAGE_PROVIDED = -1;

    public Word(String one, String lutti) {
        miwokWordTranslation = lutti;
        defaultWordTranslation = one;
    }

    public Word(String one, String lutti, int number_one) {
            miwokWordTranslation = lutti;
            defaultWordTranslation = one;
            resourceId = number_one;
    }

    public String getmiwokWordTranslation(){
        return miwokWordTranslation;
    }

    public String getDefaultWordTranslation(){
        return defaultWordTranslation;
    }

    public int getResourceId(){
        return resourceId;
    }

    public boolean hasImage(){
        return resourceId!=NO_IMAGE_PROVIDED;
    }

}

