package com.example.want;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Button loginButton = findViewById(R.id.loginButton);
        Button signUpTransitionButton = findViewById(R.id.signUpTransitionButton);
        ImageView loginImage1 = findViewById(R.id.loginImage1);
        ImageView loginImage2 = findViewById(R.id.loginImage1);


        loginButton.setOnClickListener(v -> {
            Intent intent = new Intent(getApplication(), MainActivity.class);
            startActivity(intent);
        });
        signUpTransitionButton.setOnClickListener(v -> {
            Intent intent = new Intent(getApplication(), SignUpActivity.class);
            startActivity(intent);
        });
        loginImage1.setOnClickListener(v -> {
            Intent intent = new Intent(getApplication(), MainActivity.class);
            startActivity(intent);
        });
    }
}