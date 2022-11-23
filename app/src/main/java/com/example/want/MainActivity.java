package com.example.want;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        adapter.add("A型");
        adapter.add("B型");
        adapter.add("AB型");
        adapter.add("O型");
        Spinner spinner = (Spinner) findViewById(R.id.spinner);
        spinner.setAdapter(adapter);



        ImageView searchImage = findViewById(R.id.searchImage);
        ImageView postImage = findViewById(R.id.postImage);
        ImageView notificationImage = findViewById(R.id.notificationImage);
        ImageView mypageImage = findViewById(R.id.mypageImage);
        ImageView postHistory = findViewById(R.id.view1);
        ImageView postInformation = findViewById(R.id.view2);
        ImageView questionPost = findViewById(R.id.view3);
        ImageView question = findViewById(R.id.view4);
        ImageView privatePage = findViewById(R.id.view5);
        ImageView register = findViewById(R.id.view6);

        register.setOnClickListener(v -> {
            Intent intent = new Intent(getApplication(), PostInfoActivity.class);
            startActivity(intent);
        });

        privatePage.setOnClickListener(v -> {
            Intent intent = new Intent(getApplication(), PrivateActivity.class);
            startActivity(intent);
        });

        question.setOnClickListener(v -> {
            Intent intent = new Intent(getApplication(), QuestionActivity.class);
            startActivity(intent);
        });

        questionPost.setOnClickListener(v -> {
            Intent intent = new Intent(getApplication(), QuestionPostActivity.class);
            startActivity(intent);
        });


        postInformation.setOnClickListener(v -> {
            Intent intent = new Intent(getApplication(), PostInformationActivity.class);
            startActivity(intent);
        });


//        postHistory.setOnClickListener(v -> {
//            Intent intent = new Intent(getApplication(), DBCreateActivity.class);
//            startActivity(intent);
//        });

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

    }
}