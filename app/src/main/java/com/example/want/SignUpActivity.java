package com.example.want;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SignUpActivity extends AppCompatActivity {

    private EditText edUserName, edPassword, edConfirmationPassword;
    private ImageView registerButtonImage;
    private TextView textLogin;
    private TestOpenHelper helper;
    private SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        edUserName = findViewById(R.id.edUserName);
        edPassword = findViewById(R.id.edPassword);
        edConfirmationPassword = findViewById(R.id.edConfirmationPassword);
        textLogin = findViewById(R.id.textLogin);
        registerButtonImage = findViewById(R.id.registerButtonImage);

        registerButtonImage.setOnClickListener(v -> {
            if(helper == null){
                helper = new TestOpenHelper(getApplicationContext());
            }

            if(db == null){
                db = helper.getWritableDatabase();
            }

            String userId = edUserName.getText().toString();
            String password = edPassword.getText().toString();

            //データの挿入
            insertData(db, userId, password);


            Intent intent = new Intent(SignUpActivity.this, DBConfirmationActivity.class);
            intent.putExtra("userId", userId);
            intent.putExtra("password", password);
            startActivity(intent);

        });

        textLogin.setOnClickListener(v -> {
            Intent intent = new Intent(getApplication(), LoginActivity.class);
            startActivity(intent);
        });

    }

    private void insertData(SQLiteDatabase db, String userId, String password) {
        ContentValues values = new ContentValues();
        values.put("userId", userId);
        values.put("password", password);

        db.insert("testdb", null, values);
    }
}