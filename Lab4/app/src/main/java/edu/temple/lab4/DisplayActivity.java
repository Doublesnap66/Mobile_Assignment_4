package edu.temple.lab4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class DisplayActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Intent intent = getIntent();
        int pic = intent.getIntExtra("position", -1);
        String value = intent.getStringExtra("value");
        if (pic >= 0) {
            ImageView imageView = findViewById(R.id.imageView);
            imageView.setImageResource(pic);

            TextView textView = findViewById((R.id.second_textView));
            textView.setText(value);
        }
        findViewById(R.id.closeButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}