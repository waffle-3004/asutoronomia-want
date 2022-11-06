package com.example.want;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

public class PostActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post);

        ImageView homeImage = findViewById(R.id.homeImage5);
        ImageView searchImage = findViewById(R.id.searchImage5);
        ImageView postImage = findViewById(R.id.postImage5);
        ImageView notificationImage = findViewById(R.id.notificationImage5);
        ImageView mypageImage = findViewById(R.id.mypageImage5);


        homeImage.setOnClickListener(v -> {
            Intent intent = new Intent(getApplication(), MainActivity.class);
            startActivity(intent);
        });

        postImage.setOnClickListener(v -> {
            Intent intent = new Intent(getApplication(), PostActivity.class);
            startActivity(intent);
        });

        notificationImage.setOnClickListener(v -> {
            Intent intent = new Intent(getApplication(), NotificationActivity.class);
            startActivity(intent);
        });

        mypageImage.setOnClickListener(v -> {
            Intent intent = new Intent(getApplication(), AccountActivity.class);
            startActivity(intent);
        });
    }
}