package com.example.want;

import static com.example.want.DBContract.DBEntry;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Switch;

import androidx.appcompat.app.AppCompatActivity;

public class PostActivity extends AppCompatActivity {
    EditText editTitle, editContents;
    Switch sexSwitch, ageSwitch, professionSwitch;
    ImageView post, cancel, homeImage5, searchImage5, postImage5, notificationImage5, mypageImage5;
    private PostDatabaseHelper helper;
    private SQLiteDatabase db;



    private int id = 0;

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

        //インテント取得
        Intent intent = getIntent();

        //Intentのデータ取得（データがない場合第2引数を返す）
        id = intent.getIntExtra(DBEntry._ID, 0);
        String title = intent.getStringExtra(DBEntry.COLUMN_NAME_TITLE);
        String contents = intent.getStringExtra(DBEntry.COLUMN_NAME_CONTENTS);

        // データ更新の場合
        if (id > 0) {
            editTitle.setText(title);
            editContents.setText(contents);
        }

        homeImage5.setOnClickListener(v -> {
            Intent mainIntent = new Intent(getApplication(), MainActivity.class);
            startActivity(mainIntent);
        });
//        searchImage5.setOnClickListener(v -> {
//            Intent Intent = new Intent(getApplication(), MainActivity.class);
//            startActivity(intent);
//        });
        postImage5.setOnClickListener(v -> {
            Intent postIntent = new Intent(getApplication(), PostActivity.class);
            startActivity(postIntent);
        });
        notificationImage5.setOnClickListener(v -> {
            Intent notificationIntent = new Intent(getApplication(), NotificationActivity.class);
            startActivity(notificationIntent);
        });
        mypageImage5.setOnClickListener(v -> {
            Intent mypageIntent = new Intent(getApplication(), AccountActivity.class);
            startActivity(mypageIntent);
        });

    }
    //投稿ボタンを押した時の呼び出されるメソッド
    public void post(View view) {

        // ヘルパーを準備
        PostDatabaseHelper helper = new PostDatabaseHelper(this);

        // 入力欄に入力されたタイトルとコンテンツを取得
        String title    = editTitle.getText().toString();
        String contents = editContents.getText().toString();

        // 書き込みモードでデータベースをオープン
        try (SQLiteDatabase db = helper.getWritableDatabase()) {

            // 入力されたタイトルとコンテンツをContentValuesに設定
            // ContentValuesは、項目名と値をセットで保存できるオブジェクト
            ContentValues cv = new ContentValues();
            cv.put(DBEntry.COLUMN_NAME_TITLE, title);
            cv.put(DBEntry.COLUMN_NAME_CONTENTS, contents);

            if(id == 0) {
                // データ新規登録
                db.insert(DBEntry.TABLE_NAME, null, cv);
            } else {
                // データ更新
                db.update(DBEntry.TABLE_NAME, cv, DBEntry._ID + " = ?", new String[] {String.valueOf(id)});
            }
        }

        // PostActivityを終了
        Intent intent = new Intent(getApplication(), MainTextActivity.class);
        startActivity(intent);

    }

    public void cancel(View view) {

        // PostActivityを終了
        finish();
    }

//        post.setOnClickListener(v -> {
//            if(helper == null){
//                helper = new PostDatabaseHelper(getApplicationContext());
//            }
//
//            if(db == null){
//                db = helper.getWritableDatabase();
//            }
//
//            //データの挿入
//            insertData(db, title, contents);
//
//
//            Intent postSuccessIntent = new Intent(getApplication(), PostSuccessActivity.class);
//            startActivity(postSuccessIntent);
//
//        });
//
//    private void insertData(SQLiteDatabase db, String title, String contents) {
//        ContentValues values = new ContentValues();
//        values.put("company", title);
//        values.put("stockprice", contents);
//
//        db.insert("postdb", null, values);
//    }
}