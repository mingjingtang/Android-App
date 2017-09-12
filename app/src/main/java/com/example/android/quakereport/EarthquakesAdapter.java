package com.example.android.quakereport;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import android.graphics.drawable.GradientDrawable;
import android.support.v4.content.ContextCompat;

import static com.example.android.quakereport.R.id.magnitude;


/**
 * Created by mingjingtang on 6/26/17.
 */

public class EarthquakesAdapter extends ArrayAdapter<Earthquake> {
    private static final String LOG_TAG = EarthquakesAdapter.class.getSimpleName();

    public EarthquakesAdapter(Activity content, ArrayList<Earthquake> earthquakerses){
        super(content,0, earthquakerses);
    }

    public View getView(int positon, View convertView, ViewGroup parent){
        View listItermView = convertView;
        if(listItermView == null){
            listItermView = LayoutInflater.from(getContext()).inflate(R.layout.list_item,parent,false);
        }

        Earthquake currentEarthquake = getItem(positon);

        TextView magitudeTextView = (TextView)listItermView.findViewById(magnitude);
        double magdouble = currentEarthquake.getMagnitude();
        magitudeTextView.setText(format(magdouble));


        // Set the proper background color on the magnitude circle.
        // Fetch the background from the TextView, which is a GradientDrawable.
        GradientDrawable magnitudeCircle = (GradientDrawable)magitudeTextView.getBackground();

        // Get the appropriate background color based on the current earthquake magnitude
        int magnitudeColor = getMagnitudeColor(magdouble);

        // Set the color on the magnitude circle
        magnitudeCircle.setColor(magnitudeColor);


        TextView locationTextView = (TextView)listItermView.findViewById(R.id.location);
        String place = currentEarthquake.getPlace();
        locationTextView.setText(split1(place));

        TextView cityTextView = (TextView)listItermView.findViewById(R.id.city);
        cityTextView.setText(split2(place));


        Date dateObject = new Date(currentEarthquake.getmTimeInMilliseconds());

        TextView dateTextView = (TextView)listItermView.findViewById(R.id.date);
        String formattedDate = formateDate(dateObject);
        dateTextView.setText(formattedDate);

        TextView timeTextView = (TextView)listItermView.findViewById(R.id.time);
        String formattedTime = formattedTime(dateObject);
        timeTextView.setText(formattedTime);

        return listItermView;
    }

    public String formateDate(Date dateObject){
        SimpleDateFormat dateFormat = new SimpleDateFormat("LLL dd, yyyy");
        return dateFormat.format(dateObject);
    }

    public String formattedTime(Date dateObject){
        SimpleDateFormat timeFormat = new SimpleDateFormat("h:mm a");
        return timeFormat.format(dateObject);
    }

    public String split1 (String place){
        String location;
        if(place.contains("of")){
            String[] parts = place.split("(?<=of )");
            location = parts[0];
        }
        else{
            location = "Near the";
        }
        return location;
    }

    public String split2(String place){
        String city;
        if(place.contains("of")){
            String[] parts = place.split("(?<=of )");
            city = parts[1];
        }
        else{
            city = place;
        }
        return city;
    }

    public String format(double magdouble){
        DecimalFormat formatter = new DecimalFormat("0.0");
        String output = formatter.format(magdouble);
        return output;
    }

    public int getMagnitudeColor(double magdouble){
        int magnitudeColorResourceId;
        int magnitudeFloor = (int) Math.floor(magdouble);
        switch (magnitudeFloor) {
            case 0:
            case 1:
                magnitudeColorResourceId = R.color.magnitude1;
                break;
            case 2:
                magnitudeColorResourceId = R.color.magnitude2;
                break;
            case 3:
                magnitudeColorResourceId = R.color.magnitude3;
                break;
            case 4:
                magnitudeColorResourceId = R.color.magnitude4;
                break;
            case 5:
                magnitudeColorResourceId = R.color.magnitude5;
                break;
            case 6:
                magnitudeColorResourceId = R.color.magnitude6;
                break;
            case 7:
                magnitudeColorResourceId = R.color.magnitude7;
                break;
            case 8:
                magnitudeColorResourceId = R.color.magnitude8;
                break;
            case 9:
                magnitudeColorResourceId = R.color.magnitude9;
                break;
            default:
                magnitudeColorResourceId = R.color.magnitude10plus;
                break;
        }
        return ContextCompat.getColor(getContext(), magnitudeColorResourceId);
    }

}
