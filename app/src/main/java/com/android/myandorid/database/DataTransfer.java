package com.android.myandorid.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DataTransfer extends SQLiteOpenHelper {
    public DataTransfer(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    public DataTransfer(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version, @Nullable DatabaseErrorHandler errorHandler) {
        super(context, name, factory, version, errorHandler);
    }

//    public DataTransder(@Nullable Context context, @Nullable String name, int version, @NonNull SQLiteDatabase.OpenParams openParams) {
//        super(context, name, version, openParams);
//    }

    private static final String TABLE_NAME = "user";
    private static final String ID_COL = "id";
    private static final String USER_NAME_COL = "userName";
    private static final String EMAIL_COL = "email";
    private static final String PASSWORD_COL = "password";

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
//        String query = "CREATE TABLE user (id INTEGER PRIMARY KEY AUTOINCREMENT," +
//        "user_name TEXT," +
//        "email TEXT," +
//        "password TEXT)";

        String query2 = "CREATE TABLE " + TABLE_NAME + "("
                + ID_COL + "INTEGER PRIMARY KEY AUTOINCREMENT,"
                + USER_NAME_COL + "TEXT,"
                + EMAIL_COL + "TEXT,"
                + PASSWORD_COL + "TEXT)";

        sqLiteDatabase.execSQL(query2);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public void addNewUser(String userName, String email, String password){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values =  new ContentValues();
        values.put("user_name", userName);
        values.put("user_name", userName);
        values.put("user_name", userName);
        db.insert(TABLE_NAME, null, values);
    }
}
