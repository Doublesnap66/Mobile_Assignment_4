package edu.temple.lab4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Spinner;

import java.util.ArrayList;

public class SelectionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Resources resources = getResources();
        getSupportActionBar().setTitle("Assignment 5");

        String dog1="Labrador";
        String dog2="German Shepard";
        String dog3="Bulldog";
        String dog4="Rottweiler";

        int dog1_img = R.drawable.dog1;
        int dog2_img = R.drawable.dog2;
        int dog3_img = R.drawable.dog3;
        int dog4_img = R.drawable.dog4;

        ArrayList<String> arrayGridView = new ArrayList<String>();
        arrayGridView.add(dog1);
        arrayGridView.add(dog2);
        arrayGridView.add(dog3);
        arrayGridView.add(dog4);

        ArrayList<Integer> picArray = new ArrayList<Integer>();
        picArray.add(dog1_img);
        picArray.add(dog2_img);
        picArray.add(dog3_img);
        picArray.add(dog4_img);

        GridView gridView = findViewById(R.id.grid);

        ImageAdapter adapter = new ImageAdapter(this, arrayGridView, picArray);
        gridView.setAdapter(adapter);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                if(position >= 0) {
                    Intent launchIntent = new Intent(SelectionActivity.this, DisplayActivity.class);
                    launchIntent.putExtra("position", picArray.get(position));
                    launchIntent.putExtra("value", arrayGridView.get(position));
                    startActivity(launchIntent);
                }
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        GridView gridView = findViewById(R.id.grid);
    }
}