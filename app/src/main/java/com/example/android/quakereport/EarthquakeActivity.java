/*
 * Copyright (C) 2016 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.android.quakereport;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class EarthquakeActivity extends AppCompatActivity {

    public static final String LOG_TAG = EarthquakeActivity.class.getName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.earthquake_activity);

//        // Create a fake list of earthquake locations.
//        ArrayList<Earthquake> earthquake = new ArrayList<Earthquake>();
//        earthquake.add(new Earthquake("7.2", "San Francisco", "Feb 2,2016"));
//        earthquake.add(new Earthquake("6.1", "London", "July 20,2015"));
//        earthquake.add(new Earthquake("3.9", "Tokyo", "Nov 10,2014"));
//        earthquake.add(new Earthquake("5.4", "Mexico City", "May 3,2014"));
//        earthquake.add(new Earthquake("2.8", "Moscow", "Jan 31,2013"));
//        earthquake.add(new Earthquake("4.9", "Rio de Janeiro", "Aug 19,2012"));
//        earthquake.add(new Earthquake("1.6", "Paris", "Oct 30,2011"));

        // Create a fake list of earthquakes.
        ArrayList<Earthquake> earthquakes = QueryUtils.extractEarthquakes();

        // Create a new {@link ArrayAdapter} of earthquakes
        final EarthquakesAdapter ea = new EarthquakesAdapter(this,earthquakes);

        // Find a reference to the {@link ListView} in the layout
        ListView earthquakeListView = (ListView) findViewById(R.id.list);

        // Set the adapter on the {@link ListView}
        // so the list can be populated in the user interface
        earthquakeListView.setAdapter(ea);

        earthquakeListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                // Find the current earthquake that was clicked on
                Earthquake currentEarthquake = ea.getItem(position);

                // Convert the String URL into a URI object (to pass into the Intent constructor)
                Uri earthquakeUri = Uri.parse(currentEarthquake.getUrl());

                // Create a new intent to view the earthquake URI
                Intent websiteIntent = new Intent(Intent.ACTION_VIEW, earthquakeUri);

                // Send the intent to launch a new activity
                startActivity(websiteIntent);
            }
        });
    }
}
