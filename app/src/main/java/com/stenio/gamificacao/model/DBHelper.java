package com.stenio.gamificacao.model;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DBHelper extends SQLiteOpenHelper {
    public static int VERSION = 1;
    public static String NOME_DB = "DB_APP";
    public static  String TABELA_APP = "gamificacao";


    public DBHelper(Context context) {
        super(context,NOME_DB, null,VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE IF NOT EXISTS " +TABELA_APP +
                " (id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                " nome TEXT NOT NULL, " +
                " total INTEGER NOT NULL ); ";

        try{
            db.execSQL(sql);
            Log.i("INFO DB", "SUCESSO AO CRIAR BANCO DE DADOS");
        }catch (Exception e){
            Log.i("INFO DB", "ERRO AO CRIAR A TABELA" +e.getLocalizedMessage() );
        }

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String sql = "DROP TABLE IF EXISTS " +TABELA_APP +" ;";
        try{
            db.execSQL(sql);
            Log.i("INFO DB", "SUCESSO AO ATUALIZAR BANCO DE DADOS");
        }catch (Exception e){
            Log.i("INFO DB", "ERRO AO ATUALIZAR A TABELA" +e.getLocalizedMessage() );
        }
    }

}
