package com.stenio.gamificacao.model;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class ResultadoDAO implements IResultado {
    private SQLiteDatabase escreve;
    private SQLiteDatabase le;


    public  ResultadoDAO(Context context){
        DBHelper db = new DBHelper(context);
        escreve = db.getWritableDatabase();
        le = db.getReadableDatabase();
    }

    @Override
    public boolean salvar(Resultado resultado) {
        ContentValues cv = new ContentValues();
        cv.put("nome", resultado.getNome());
        cv.put("total", resultado.getTotal());


    try {

        Log.i("INFO DB", "SUCESSO AO SALVAR DADOS");
        escreve.insert(DBHelper.TABELA_APP, null, cv);

    }catch (Exception e){
        Log.i("INFO DB", "ERRO AO SALVAR" +e.getLocalizedMessage() );
        return false;
    }

        return true;
    }

    @Override
    public List<Resultado> listar() {

        List<Resultado> resultados = new ArrayList <>();
        String sql = "SELECT * FROM " +DBHelper.TABELA_APP + " ORDER BY total DESC;";
        Cursor c = le.rawQuery(sql, null);

        while (c.moveToNext()){
            Resultado resultado = new Resultado();
            Long id = c.getLong(c.getColumnIndex("id"));
            String nomeResultado = c.getString(c.getColumnIndex("nome"));
            String totalResultado = c.getString(c.getColumnIndex("total"));

            resultado.setId(id);
            resultado.setNome(nomeResultado);
            resultado.setTotal(totalResultado);
            resultados.add(resultado);

        }

        return resultados;
    }
}
