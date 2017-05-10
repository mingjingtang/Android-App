package com.example.android.android_thirdapp;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import static android.R.id.message;
import static android.icu.lang.UCharacter.GraphemeClusterBreak.V;

public class MainActivity extends AppCompatActivity {
  @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        TextView textView = new TextView(this);
        textView.setTextSize(38);
        textView.setText("Wow! That's Amazing.Lalalalalalalalallalalallalalallalallalalalalallalallalalallala");
        textView.setMaxLines(2);
        textView.setTextColor(Color.MAGENTA);

        setContentView(textView);
    }
}
