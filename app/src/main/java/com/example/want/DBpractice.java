package com.example.want;
import androidx.appcompat.app.AppCompatActivity;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class DBpractice extends AppCompatActivity {

    private TextView textView;
    private EditText editTextKey, editTextValue;
    private MyOpenHelper helper;
    private SQLiteDatabase db;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dbpractice);

        editTextKey = findViewById(R.id.edit_text_key);
        editTextValue = findViewById(R.id.edit_text_value);

        textView = findViewById(R.id.text_view);

        Button insertButton = findViewById(R.id.button_insert);
        insertButton.setOnClickListener(v -> {

            if(helper == null){
                helper = new MyOpenHelper(getApplicationContext());
            }

            if(db == null){
                db = helper.getWritableDatabase();
            }

            String key = editTextKey.getText().toString();
            String value = editTextValue.getText().toString();

            // 価格は整数を想定
            insertData(db, key, Integer.parseInt(value));
        });

        Button readButton = findViewById(R.id.button_read);
        readButton.setOnClickListener(v -> readData());
    }


    private void readData(){
        if(helper == null){
            helper = new MyOpenHelper(getApplicationContext());
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
        textView.setText(sbuilder.toString());
    }

    private void insertData(SQLiteDatabase db, String com, int price){

        ContentValues values = new ContentValues();
        values.put("company", com);
        values.put("stockprice", price);

        db.insert("testdb", null, values);
    }
}