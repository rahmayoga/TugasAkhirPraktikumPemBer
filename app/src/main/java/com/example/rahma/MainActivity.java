package com.example.rahma;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText Nama_Barang, Merk_Barang, Harga_Barang;

    private String setNama_Barang, setMerk_Barang, setHarga_Barang;

    private DBTokoRahma dbTokoRahma;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button Tambah_Data = findViewById(R.id.Tambah_Data);
        Button Lihat_Data = findViewById(R.id.Lihat_Data);
        Nama_Barang = findViewById(R.id.Nama_Barang);
        Merk_Barang = findViewById(R.id.Merk_Barang);
        Harga_Barang = findViewById(R.id.Harga_Barang);

        dbTokoRahma = new DBTokoRahma(getBaseContext());

        Tambah_Data.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setData();
                saveData();
                Toast.makeText(getApplicationContext(),"Data Berhasil Ditambah", Toast.LENGTH_SHORT).show();
                clearData();
            }
        });
        Lihat_Data.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, ViewDataActivity.class));
            }
        });
    }
    private void setData(){
        setNama_Barang = Nama_Barang.getText().toString();
        setMerk_Barang = Merk_Barang.getText().toString();
        setHarga_Barang = Harga_Barang.getText().toString();
    }

    private void saveData(){
        SQLiteDatabase create = dbTokoRahma.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(DBTokoRahma.MyColumns.NamaBarang, setNama_Barang);
        values.put(DBTokoRahma.MyColumns.MerkBarang, setMerk_Barang);
        values.put(DBTokoRahma.MyColumns.HargaBarang, setHarga_Barang);

        create.insert(DBTokoRahma.MyColumns.NamaTabel, null, values);
    }

    private void clearData(){
        Nama_Barang.setText("");
        Merk_Barang.setText("");
        Harga_Barang.setText("");
    }

    }

