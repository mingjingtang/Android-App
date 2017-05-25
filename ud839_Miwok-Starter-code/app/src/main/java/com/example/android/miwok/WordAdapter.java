package com.example.android.miwok;

import android.app.Activity;
import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by mingjingtang on 5/16/17.
 */

public class WordAdapter extends ArrayAdapter<Word> {
    private int mcolorResouceId;

    public WordAdapter(Context context, ArrayList<Word>words, int colorResouceId){
        super(context,0,words);
        mcolorResouceId = colorResouceId;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listItemView = convertView;
        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        Word currentWord = getItem(position);

            ImageView image = (ImageView)listItemView.findViewById(R.id.image);
            if(currentWord.hasImage()){
                image.setImageResource(currentWord.getResourceId());
                image.setVisibility(View.VISIBLE);
            }
            else{
                image.setVisibility(View.GONE);
            }

            TextView miwokTextView = (TextView) listItemView.findViewById(R.id.miwok_text_view);
            miwokTextView.setText(currentWord.getmiwokWordTranslation());

            TextView defaultTextView = (TextView) listItemView.findViewById(R.id.default_text_view);
            defaultTextView.setText(currentWord.getDefaultWordTranslation());

        View textContainner = listItemView.findViewById(R.id.text_container);
        int color = ContextCompat.getColor(getContext(),mcolorResouceId);
        textContainner.setBackgroundColor(color);

        return listItemView;
    }
}

