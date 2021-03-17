package edu.temple.lab4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Locale;

public class SelectionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Resources resources = getResources();
        getSupportActionBar().setTitle("Assignment 6");
        String[] pets = {};
        Log.d("test language", Locale.getDefault().getLanguage());
        if (Locale.getDefault().getLanguage().equals("fr")) {
            TextView view = (TextView) findViewById(R.id.textView);
            view.setText(resources.getString(R.string.french_instructions));
            pets = resources.getStringArray(R.array.french_pets);
        }
        else {
            TextView view = (TextView) findViewById(R.id.textView);
            view.setText(resources.getString(R.string.instructions));
            pets = resources.getStringArray(R.array.pets);
        }

        int fish_img = R.drawable.fish;
        int cat_img = R.drawable.cat;
        int dog_img = R.drawable.dog;
        int bird_img = R.drawable.bird;
        int snake_img = R.drawable.snake;
        int rabbit_img = R.drawable.rabbit;
        int mouse_img = R.drawable.mouse;
        int lizard_img = R.drawable.lizard;

        ArrayList<String> arrayGridView = new ArrayList<String>();
        arrayGridView.add(pets[0]);
        arrayGridView.add(pets[1]);
        arrayGridView.add(pets[2]);
        arrayGridView.add(pets[3]);
        arrayGridView.add(pets[4]);
        arrayGridView.add(pets[5]);
        arrayGridView.add(pets[6]);
        arrayGridView.add(pets[7]);

        ArrayList<Integer> picArray = new ArrayList<Integer>();
        picArray.add(fish_img);
        picArray.add(cat_img);
        picArray.add(dog_img);
        picArray.add(bird_img);
        picArray.add(snake_img);
        picArray.add(rabbit_img);
        picArray.add(mouse_img);
        picArray.add(lizard_img);

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