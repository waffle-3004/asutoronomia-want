package com.example.want;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DBConfirmationActivity extends AppCompatActivity {

    TextView userInfoText;
    ListView userInfo;
    Button btnDelete;
    private TestOpenHelper helper;
    private SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dbconfirmation);


        userInfoText = findViewById(R.id.userInfoText);
        userInfo = findViewById(R.id.userInfo);
        btnDelete = findViewById(R.id.btnDelete);

        //データ削除
        btnDelete.setOnClickListener(v -> {
            db.delete("testdb", null, null);

            Intent intent = new Intent(getApplication(), DBConfirmationActivity.class);
            startActivity(intent);
        });
        readData();

        List<Map<String,String>> signUpList = new ArrayList<>();
        int i = 0;
        while(i < 10) {
            Intent intent = getIntent();
            String userId = intent.getStringExtra("userId");
            String password = intent.getStringExtra("password");
            Map<String,String> List = new HashMap<>();
            List.put("userId",userId);
            List.put("password",password);
            signUpList.add(List);
            i++;
        }

        String[] from = {"userId","password"};
        int[] to = {android.R.id.text1,android.R.id.text2};
        SimpleAdapter adapter = new SimpleAdapter(DBConfirmationActivity.this,signUpList, android.R.layout.simple_list_item_2,from,to);

        userInfo.setAdapter(adapter);

    }
    //データを画面に表示
    private void readData(){
        if(helper == null){
            helper = new TestOpenHelper(getApplicationContext());
        }

        if(db == null){
            db = helper.getReadableDatabase();
        }
        Log.d("debug","**********Cursor");

        Cursor cursor = db.query(
                "testdb",
                new String[] { "company", "stockprice" },
                null,
                null,
                null,
                null,
                null
        );

        cursor.moveToFirst();

        StringBuilder sbuilder = new StringBuilder();

        for (int i = 0; i < cursor.getCount(); i++) {
            sbuilder.append(cursor.getString(0));
            sbuilder.append(": ");
            sbuilder.append(cursor.getInt(1));
            sbuilder.append("\n");
            cursor.moveToNext();
        }

        // 忘れずに！
        cursor.close();

        Log.d("debug","**********"+sbuilder);
        userInfoText.setText(sbuilder.toString());
    }

}