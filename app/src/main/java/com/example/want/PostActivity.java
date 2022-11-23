package com.example.want;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class PostActivity extends AppCompatActivity {
    EditText editTitle, editContents;
    TextView post, cancel;
    Switch sexSwitch, ageSwitch, professionSwitch;
    ImageView homeImage5, searchImage5, postImage5, notificationImage5, mypageImage5;
    private PostDatabaseHelper helper;
    private SQLiteDatabase db;

//    private int id = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post);

        editTitle = findViewById(R.id.textTitle);
        editContents = findViewById(R.id.textContent);
        post = findViewById(R.id.post);
        cancel = findViewById(R.id.cancel);
        sexSwitch = findViewById(R.id.sexSwitch);
        ageSwitch = findViewById(R.id.ageSwitch);
        professionSwitch = findViewById(R.id.professionSwitch);
        homeImage5 = findViewById(R.id.homeImage5);
        searchImage5 = findViewById(R.id.searchImage5);
        postImage5 = findViewById(R.id.postImage5);
        notificationImage5 = findViewById(R.id.notificationImage5);
        mypageImage5 = findViewById(R.id.mypageImage5);


        post.setOnClickListener(v -> {
            if(helper == null){
                helper = new PostDatabaseHelper(getApplicationContext());
            }

            if(db == null){
                db = helper.getWritableDatabase();
            }

            String title = editTitle.getText().toString();
            String contents = editContents.getText().toString();

            //データの挿入
            insertData(db, title, contents);


            Intent intent = new Intent(getApplication(), PostSuccessActivity.class);
            startActivity(intent);

        });

        homeImage5.setOnClickListener(v -> {
            Intent intent = new Intent(getApplication(), MainActivity.class);
            startActivity(intent);
        });
        searchImage5.setOnClickListener(v -> {
            Intent intent = new Intent(getApplication(), MainActivity.class);
            startActivity(intent);
        });
        postImage5.setOnClickListener(v -> {
            Intent intent = new Intent(getApplication(), MainActivity.class);
            startActivity(intent);
        });
        notificationImage5.setOnClickListener(v -> {
            Intent intent = new Intent(getApplication(), MainActivity.class);
            startActivity(intent);
        });
        mypageImage5.setOnClickListener(v -> {
            Intent intent = new Intent(getApplication(), MainActivity.class);
            startActivity(intent);
        });

    }

    private void insertData(SQLiteDatabase db, String title, String contents) {
        ContentValues values = new ContentValues();
        values.put("company", title);
        values.put("stockprice", contents);

        db.insert("postdb", null, values);
    }
}