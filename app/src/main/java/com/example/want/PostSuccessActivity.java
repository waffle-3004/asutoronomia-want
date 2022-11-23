package com.example.want;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

public class PostSuccessActivity extends AppCompatActivity {


    ListView postInfo;
    private PostDatabaseHelper helper;
    private SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_success);

        postInfo = findViewById(R.id.postInfo);

//        btnDelete.setOnClickListener(v -> {
//            db.delete("testdb", null, null);
//
//            Intent intent = new Intent(getApplication(), DBConfirmationActivity.class);
//            startActivity(intent);
//        });
        readData();

    }

    private void readData(){
        if(helper == null){
            helper = new PostDatabaseHelper(getApplicationContext());
        }

        if(db == null){
            db = helper.getReadableDatabase();
        }
        Log.d("debug","**********Cursor");

        Cursor cursor = db.query(
                "postdb",
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
//        postInfo.setText(sbuilder.toString());
    }
}