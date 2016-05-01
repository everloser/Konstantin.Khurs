package com.google.everloser12.eleven;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by al-ev on 29.04.2016.
 */
public class DbHelper extends SQLiteOpenHelper {


    private static final String DATABASE_NAME = "myDB";
    private static final int DATABASE_VERSION = 1;

    public DbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        Log.d("Moi", "onCreate");

        db.execSQL("CREATE TABLE users (id INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT)");
        db.execSQL("CREATE TABLE usersage (id INTEGER PRIMARY KEY AUTOINCREMENT, age INTEGER)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        Log.d("Moi", "onUpgrade");
    }

    public void save(String name, int id)
    {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        if (id == 0)
        {
            values.put("name", name);

            // db.update("users", values, "id=?", new String[] {String.valueOf(id)});
            db.insert("users", null, values);

            db.close();
        }
        else
        {
            values.put("name", name);
            values.put("id", id);
            db.update("users", values, "id=?", new String[]{String.valueOf(id)});
            db.close();
        }

    }

    public String[] getUser()
    {

        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.query("users", null, null, null, null, null, null);
        List<String> userlist = new ArrayList<String>();
        if (cursor.moveToFirst()) {
            int id;
            String name = null;
            int age = 0;
            do {
                id = cursor.getInt(0);
                name = cursor.getString(cursor.getColumnIndex("name"));
                if (cursor.getColumnCount() > 2)
                    age = cursor.getInt(cursor.getColumnIndex("age"));
                User user = new User();
                user.setId(id);
                user.setName(name);
                if (age !=0)
                    user.setAge(age);
                userlist.add(user.toString());
            }
            while (cursor.moveToNext());
            cursor.close();
            db.close();
            String[] array = userlist.toArray(new String[userlist.size()]);
            return array;

        }
        else{
            cursor.close();
            db.close();
            return new String[]{""};
        }

    }

    public String[] join()
    {
            SQLiteDatabase db = getWritableDatabase();
        Cursor cursor = db.query("users INNER JOIN usersage ON users.id=usersage.id", null, null,
                null, null, null, "users.id");
        List<String> userlist = new ArrayList<String>();
        if (cursor.moveToFirst()) {
            int id;
            String name = null;
            int age = 0;
            do {
                id = cursor.getInt(0);
                name = cursor.getString(cursor.getColumnIndex("name"));
                if (cursor.getColumnCount() > 2)
                    age = cursor.getInt(cursor.getColumnIndex("age"));
                User user = new User();
                user.setId(id);
                user.setName(name);
                if (age !=0)
                    user.setAge(age);
                userlist.add(user.toString());
            }
            while (cursor.moveToNext());
            cursor.close();
            db.close();
            String[] array = userlist.toArray(new String[userlist.size()]);
            return array;

        }
        else{
            cursor.close();
            db.close();
            return new String[]{""};
        }

    }


    public void loadDataToSecondTable()
    {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("age", "30");
        db.insert("usersage", null, values);
        values.clear();
        values.put("age", "33");
        db.insert("usersage", null, values);
        values.clear();
        values.put("age", "35");
        db.insert("usersage", null, values);
        db.close();
    }



}
