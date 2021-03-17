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
        getSupportActionBar().setTitle("Assignment 6");

        int dog1=R.string.dog1;
        int dog2=R.string.dog2;
        int dog3=R.string.dog3;
        int dog4=R.string.dog4;
        int dog5=R.string.dog5;
        int dog6=R.string.dog6;
        int dog7=R.string.dog7;
        int dog8=R.string.dog8;

        int dog1_img = R.drawable.dog1;
        int dog2_img = R.drawable.dog2;
        int dog3_img = R.drawable.dog3;
        int dog4_img = R.drawable.dog4;
        int dog5_img = R.drawable.dog5;
        int dog6_img = R.drawable.dog6;
        int dog7_img = R.drawable.dog7;
        int dog8_img = R.drawable.dog8;

        ArrayList<Integer> arrayGridView = new ArrayList<Integer>();
        arrayGridView.add(dog1);
        arrayGridView.add(dog2);
        arrayGridView.add(dog3);
        arrayGridView.add(dog4);
        arrayGridView.add(dog5);
        arrayGridView.add(dog6);
        arrayGridView.add(dog7);
        arrayGridView.add(dog8);

        ArrayList<Integer> picArray = new ArrayList<Integer>();
        picArray.add(dog1_img);
        picArray.add(dog2_img);
        picArray.add(dog3_img);
        picArray.add(dog4_img);
        picArray.add(dog5_img);
        picArray.add(dog6_img);
        picArray.add(dog7_img);
        picArray.add(dog8_img);

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