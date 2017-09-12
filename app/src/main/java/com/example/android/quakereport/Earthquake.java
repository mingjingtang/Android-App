package com.example.android.quakereport;

/**
 * Created by mingjingtang on 6/26/17.
 */

public class Earthquake {
    private double magnitude;
    private String place;
    private long mTimeInMilliseconds;
    private String url;

    public Earthquake(double mag, String pla, long tim, String ur){
        magnitude = mag;
        place = pla;
        mTimeInMilliseconds = tim;
        url = ur;
    }

    public double getMagnitude(){
        return magnitude;
    }

    public String getPlace(){
        return place;
    }

    public long getmTimeInMilliseconds(){
        return mTimeInMilliseconds;
    }

    public String getUrl(){
        return url;
    }
}
