package com.example.myhoih.midtermandroid;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class MyDatabase extends SQLiteOpenHelper {
    private static String DATABASE_NAME="class19B.db";
    private String TABLE_NAME="bills";
    private String CREATE_TABLE = "create table bills(productName TEXT, price REAL, quantity INTEGER)";
    private String DELETE_TABLE = "drop table if exists bills";

    public MyDatabase(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DATABASE_NAME, factory, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(DELETE_TABLE);
        onCreate(db);
    }

    public  void insertBill(String productName, double price, int quantity){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("productName",productName);
        values.put("price", price);
        values.put("quantity", quantity);
        db.insert(TABLE_NAME, null, values);
    }

    public ArrayList<Bill> getBills(){
        SQLiteDatabase db = this.getReadableDatabase();
        String sql = "select * from bills";
        Cursor cursor = db.rawQuery(sql, null);

        ArrayList<Bill> billList = new ArrayList<>();
        while (cursor.moveToNext()){
            String productName = cursor.getString(cursor.getColumnIndexOrThrow("productName"));
            double price = cursor.getDouble(cursor.getColumnIndexOrThrow("price"));
            int quantity = cursor.getInt(cursor.getColumnIndexOrThrow("quantity"));
            Bill bill = new Bill(productName, price, quantity);
            billList.add(bill);
        }

        return billList;
    }
}
