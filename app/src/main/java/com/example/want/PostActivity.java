package com.example.want;

import static com.example.want.DBContract.DBEntry;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class PostActivity extends AppCompatActivity {
    EditText editTitle = null;
    EditText editContents = null;
    TextView post, cancel;
    private int id = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post);

        // ビューオブジェクトを取得
        editTitle = findViewById(R.id.textTitle);
        editContents = findViewById(R.id.textContent);
        post = findViewById(R.id.post);
        cancel = findViewById(R.id.cancel);

        // インテントを取得
        Intent intent = getIntent();

        //intentのデータを取得(データがない場合、第２引数の 0 が返る)
        id = intent.getIntExtra(DBEntry._ID,0);
        String title = intent.getStringExtra(DBEntry.COLUMN_NAME_TITLE);
        String contents = intent.getStringExtra(DBEntry.COLUMN_NAME_CONTENTS);

        // データ更新の場合
        if (id > 0){
            editTitle.setText(title);
            editContents.setText(contents);
        }
        //キャンセルボタン押された時
        cancel.setOnClickListener(v -> {
            Intent cancelIntent = new Intent(getApplication(), MainActivity.class);
            startActivity(cancelIntent);
        });

//        post.setOnClickListener(v -> {
//            // ヘルパーを準備
//            PostDatabaseHelper helper = new PostDatabaseHelper(this);
//
//            // 入力欄に入力されたタイトルとコンテンツを取得
//            String postTitle = editTitle.getText().toString();
//            String postContents = editContents.getText().toString();
//
//            // 書き込みモードでデータベースをオープン
//            try (SQLiteDatabase db = helper.getWritableDatabase()) {
//
//                // 入力されたタイトルとコンテンツをContentValuesに設定
//                // ContentValuesは、項目名と値をセットで保存できるオブジェクト
//                ContentValues cv = new ContentValues();
//                cv.put(DBEntry.COLUMN_NAME_TITLE, postTitle);
//                cv.put(DBEntry.COLUMN_NAME_CONTENTS, postContents);
//
//                if(id == 0) {
//                    // データ新規登録
//                    db.insert(DBEntry.TABLE_NAME, null, cv);
//                } else {
//                    // データ更新
//                    db.update(DBEntry.TABLE_NAME, cv, DBEntry._ID + " = ?", new String[] {String.valueOf(id)});
//                }
//            }
//            Intent postIntent = new Intent(getApplication(), PostInfoActivity.class);
//            startActivity(postIntent);
//        });

    }

    // 「登録」ボタン　タップ時に呼び出されるメソッド
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
        finish();
    }




}