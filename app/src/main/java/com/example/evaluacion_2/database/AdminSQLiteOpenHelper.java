package com.example.evaluacion_2.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class AdminSQLiteOpenHelper extends  SQLiteOpenHelper{

    //construtor para instaciar el database
    public AdminSQLiteOpenHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    //permite definir la configuración de mi database
    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("CREATE TABLE clases (codigo int primary key, nombre text, direccion text)");
    }

    //realiza cambios esquematicos de mi database
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {

    }
}
