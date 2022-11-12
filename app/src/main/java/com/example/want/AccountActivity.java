package com.example.want;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class AccountActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);

        ImageView imageView6 = findViewById(R.id.imageView6);

        ImageView homeImage = findViewById(R.id.homeImage3);
        ImageView searchImage = findViewById(R.id.searchImage3);
        ImageView postImage = findViewById(R.id.postImage3);
        ImageView notificationImage = findViewById(R.id.notificationImage3);
        ImageView mypageImage = findViewById(R.id.mypageImage3);
        ImageView logoutImage = findViewById(R.id.logoutImage);
        ImageView accountChange = findViewById(R.id.accountChange);
        ImageView accountSetting = findViewById(R.id.accountSetting);

        logoutImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                SharedPreferences preferences = getSharedPreferences("checkBox", MODE_PRIVATE);
                SharedPreferences.Editor editor = preferences.edit();
                editor.putString("remember", "false");
                editor.apply();

                Intent intent = new Intent(getApplication(), LoginActivity.class);
                startActivity(intent);

            }
        });

        accountSetting.setOnClickListener(v -> {
            Intent intent = new Intent(getApplication(), ProfileActivity.class);
            startActivity(intent);
        });

        accountChange.setOnClickListener(v -> {
            Intent intent = new Intent(getApplication(), LoginActivity.class);
            startActivity(intent);
        });

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

        imageView6.setOnClickListener(v -> {
            Intent intent = new Intent(getApplication(), NotificationActivity.class);
            startActivity(intent);
        });
    }
}