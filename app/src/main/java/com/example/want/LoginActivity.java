package com.example.want;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    EditText email,password;
    CheckBox remember;
    ImageView login;
    TextView textSignUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        email = findViewById(R.id.textUserName);
        password = findViewById(R.id.textPassword);
        remember = findViewById(R.id.rememberMe);
        login = findViewById(R.id.loginButtonImage);
        textSignUp = findViewById(R.id.textSignUp);

        login.setOnClickListener(v -> {
            Intent intent = new Intent(getApplication(), MainActivity.class);
            startActivity(intent);
        });

        textSignUp.setOnClickListener(v -> {
            Intent intent = new Intent(getApplication(), SignUpActivity.class);
            startActivity(intent);
        });

    }
}