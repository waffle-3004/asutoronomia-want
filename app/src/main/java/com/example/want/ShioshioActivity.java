package com.example.want;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ShioshioActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        ImageView registerButtonImage = findViewById(R.id.registerButtonImage);
        TextView textLogin = findViewById(R.id.textLogin);

        registerButtonImage.setOnClickListener(v -> {
            Intent intent = new Intent(getApplication(), MainActivity.class);
            startActivity(intent);
        });

        textLogin.setOnClickListener(v -> {
            Intent intent = new Intent(getApplication(), LoginActivity.class);
            startActivity(intent);
        });
        System.out.println("shioshio");
        System.out.println("suzuharu");
        System.out.println("tensai");
    }
}
