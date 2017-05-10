package com.example.android.menu;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void printToLogs(View view) {
        // Find first menu item TextView and print the text to the logs
        TextView firstText = (TextView)findViewById(R.id.menu_item_1);
        String firstString = (String) firstText.getText();
        Log.i("MainActivity.java", firstString);
        // Find second menu item TextView and print the text to the logs
        TextView secondText = (TextView)findViewById(R.id.menu_item_2);
        String secondString = (String)secondText.getText();
        Log.i("MainActivity.java", secondString);
        // Find third menu item TextView and print the text to the logs
        TextView thirdText = (TextView)findViewById(R.id.menu_item_3);
        String thirdString = (String)thirdText.getText();
        Log.i("MainActivity.java", thirdString);
    }
}
