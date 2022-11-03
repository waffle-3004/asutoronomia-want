package com.example.want;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

public class AccountActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);

        ImageView imageView6 = findViewById(R.id.imageView6);

        imageView6.setOnClickListener(v -> {
            Intent intent = new Intent(getApplication(), NotificationActivity.class);
            startActivity(intent);
        });
    }
}