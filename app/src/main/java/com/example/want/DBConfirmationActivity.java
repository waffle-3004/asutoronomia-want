package com.example.want;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

public class DBConfirmationActivity extends AppCompatActivity {

    ListView userInfo;
    Button btnDelete;
    private TestOpenHelper helper;
    private SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dbconfirmation);

        userInfo = findViewById(R.id.userInfo);
        btnDelete = findViewById(R.id.btnDelete);

        btnDelete.setOnClickListener(v -> {
            db.delete("testdb", null, null);

            Intent intent = new Intent(getApplication(), DBConfirmationActivity.class);
            startActivity(intent);
        });
        readData();

    }

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
//        userInfo.setText(sbuilder.toString());
    }

}