package com.stenio.gamificacao;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class Atividade4 extends AppCompatActivity {

    private int result = 0;
    private int errou = 0;
    public String a,b,c,d,e;
    int totalPontos = 0;
    EditText aa,bb,cc,dd,ee;
    Button btConfirmaEx01;
    int vidasCasoRetry,vidas;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_atividade4);

        btConfirmaEx01 = findViewById(R.id.btConfirmaEx01);
        aa = findViewById(R.id.rex01a);
        bb = findViewById(R.id.rex01b);
        cc = findViewById(R.id.rex01c);
        dd = findViewById(R.id.rex01d);
        ee = findViewById(R.id.rex01e);


        Intent intentReceive = getIntent();
        Bundle param = intentReceive.getExtras();
        if (param != null) {
            int total = param.getInt("totalPontos");
            vidas = param.getInt("vidas");
            vidasCasoRetry = vidas;
            totalPontos =  total;

        }
    }

    public void confirma (View view){

        a = aa.getText().toString();
        b = bb.getText().toString();
        c = cc.getText().toString();
        d = dd.getText().toString();
        e = ee.getText().toString();


        if (a.equals("Array") || a.equals("ARRAY") || a.equals("array")) {
            result = result + 1;
        }else{
            errou = errou + 1;
            vidas--;
            verificaVida();
        }
        if (b.equals("Boolean")|| b.equals("BOOLEAN") || b.equals("boolean"))  {
            result = result + 1;
        }
        else{
            errou = errou + 1;
            vidas--;
            verificaVida();
        }
        if (c.equals("Public")|| c.equals("PUBLIC") || c.equals("public"))  {
            result = result + 1;
        }
        else{
            errou = errou + 1;
            vidas--;
            verificaVida();
        }
        if (d.equals("Ping")|| d.equals("PING") || d.equals("ping"))  {
            result = result + 1;
        }
        else{
            errou = errou + 1;
            vidas--;
            verificaVida();
        }
        if (e.equals("Pop-up")|| e.equals("POP-UP") || e.equals("pop-up")|| e.equals("pop up") || e.equals("POP UP"))  {
            result = result + 1;
        } else {
            errou = errou + 1;
            vidas--;
            verificaVida();
        }
        totalPontos = totalPontos + result;
        alertaResultado(btConfirmaEx01);
    }

    public void alertaResultado(View view) {

        AlertDialog alertDialog;
        alertDialog = new AlertDialog.Builder(this).create();
        alertDialog.setCancelable(false);
        alertDialog.setTitle("Resultado!");

        alertDialog.setMessage("Congratulations, you're done! " +result+" Question accept. and Finish has " +vidas);
        alertDialog.setButton("FINISH", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Intent intent = new Intent(getApplicationContext(), MapaAtividadeFinal.class);
                intent.putExtra("totalPontos", totalPontos);
                startActivity(intent);
                finish();
            }
        });


        alertDialog.show();


    }

    public void verificaVida(){
        if(vidas == 0){
            AlertDialog alertDialog;
            alertDialog = new AlertDialog.Builder(this).create();
            alertDialog.setCancelable(false);
            alertDialog.setTitle("=( Você ficou sem vidas!!");
            alertDialog.setMessage("Você não tem mais Vidas:" + vidas);
            alertDialog.setButton("Tentar Novamente", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    Intent intent = new Intent(getApplicationContext(), Atividade4.class);
                    intent.putExtra("vidas", vidasCasoRetry);
                    startActivity(intent);
                    finish();
                }
            });
        }
    }



}
