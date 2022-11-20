package com.example.want;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

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

            String userName = edUserName.getText().toString();
            String password = edPassword.getText().toString();

            //データの挿入
            insertData(db, userName, password);


            Intent intent = new Intent(getApplication(), DBConfirmationActivity.class);
            startActivity(intent);

        });

        textLogin.setOnClickListener(v -> {
            Intent intent = new Intent(getApplication(), LoginActivity.class);
            startActivity(intent);
        });

    }

    private void insertData(SQLiteDatabase db, String userName, String password) {
        ContentValues values = new ContentValues();
        values.put("company", userName);
        values.put("stockprice", password);

        db.insert("testdb", null, values);
    }
}