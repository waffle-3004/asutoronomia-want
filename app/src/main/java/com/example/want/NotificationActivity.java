package com.example.want;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NotificationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);

        ListView notificationList = findViewById(R.id.postList);

        List<Map<String,String>> notification = new ArrayList<>();

        Map<String,String> List = new HashMap<>();
        List.put("day","2022-10-03");
        List.put("comment","ああああああああああ");
        notification.add(List);

        List = new HashMap<>();
        List.put("day","2022-11-03");
        List.put("comment","いいいいいいいいいいい");
        notification.add(List);

        List = new HashMap<>();
        List.put("day","2022-11-05");
        List.put("comment","ううううううううううう");
        notification.add(List);

        String[] from = {"day","comment"};
        int[] to = {android.R.id.text1,android.R.id.text2};
        SimpleAdapter adapter = new SimpleAdapter(NotificationActivity.this,notification, android.R.layout.simple_list_item_2,from,to);

        notificationList.setAdapter(adapter);


        ImageView homeImage = findViewById(R.id.homeImage2);
        ImageView searchImage = findViewById(R.id.searchImage2);
        ImageView postImage = findViewById(R.id.postImage2);
        ImageView notificationImage = findViewById(R.id.notificationImage2);
        ImageView mypageImage = findViewById(R.id.mypageImage2);


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

    }
}