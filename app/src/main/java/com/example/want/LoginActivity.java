package com.example.want;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        ImageView loginButtonImage = findViewById(R.id.loginButtonImage);
        TextView textSignUp = findViewById(R.id.textSignUp);

        loginButtonImage.setOnClickListener(v -> {
            Intent intent = new Intent(getApplication(), MainActivity.class);
            startActivity(intent);
        });

        textSignUp.setOnClickListener(v -> {
            Intent intent = new Intent(getApplication(), SignUpActivity.class);
            startActivity(intent);
        });

    }
}