package com.example.rahma;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class ViewDataActivity extends AppCompatActivity {
    private ListView listView;
    private DBTokoRahma MyDatabase;
    private ArrayList<String> ListData;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_data);
                getSupportActionBar().setTitle("Daftar Toko Rahma");
                listView = findViewById(R.id.list);
                ListData = new ArrayList<>();
                MyDatabase = new DBTokoRahma(getBaseContext());
                getData();
                listView.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, ListData));
            }
            @SuppressLint("Recycle")
            private void getData(){
                SQLiteDatabase Lihat_Data = MyDatabase.getReadableDatabase();
                Cursor cursor = Lihat_Data.rawQuery("SELECT * FROM "+ DBTokoRahma.MyColumns.NamaTabel,null);

                cursor.moveToFirst();
                for(int count=0; count < cursor.getCount(); count++){

                    cursor.moveToPosition(count);

                    ListData.add(cursor.getString(1));
                }
            }
        }

