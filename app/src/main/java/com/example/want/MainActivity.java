package com.example.want;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button1 = findViewById(R.id.button1);
        Button accountButton = findViewById(R.id.accountButton);
        Button postButton = findViewById(R.id.postButton);

        button1.setOnClickListener(v -> {
            Intent intent = new Intent(getApplication(), NotificationActivity.class);
            startActivity(intent);
        });

        accountButton.setOnClickListener(v -> {
            Intent intent = new Intent(getApplication(), AccountActivity.class);
            startActivity(intent);
        });

        postButton.setOnClickListener(v -> {
            Intent intent = new Intent(getApplication(), PostActivity.class);
            startActivity(intent);
        });
    }
}