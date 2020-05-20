package com.example.rahma;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;

public class DBTokoRahma extends SQLiteOpenHelper {
    static abstract class MyColumns implements BaseColumns {
        static final String NamaTabel = "Gudang_Rahma";
        static final String NamaBarang = "Nama_Barang";
        static final String MerkBarang = "Merk_Barang";
        static final String HargaBarang = "Harga_Barang";
    }

    private static final String NamaDatabse = "TokoRahma.db";
    private static final int VersiDatabase = 1;

    private static final String SQL_CREATE_ENTRIES = "CREATE TABLE "+MyColumns.NamaTabel+
            "("+MyColumns.NamaBarang+" TEXT PRIMARY KEY, "+MyColumns.MerkBarang+" TEXT NOT NULL, "+MyColumns.HargaBarang+
            " TEXT NOT NULL)";

    private static final String SQL_DELETE_ENTRIES = "DROP TABLE IF EXISTS "+MyColumns.NamaTabel;

    DBTokoRahma(Context context) {
        super(context, NamaDatabse, null, VersiDatabase);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_ENTRIES);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL(SQL_DELETE_ENTRIES);
        onCreate(db);
    }

}

