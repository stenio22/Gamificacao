package com.stenio.gamificacao;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

public class Atividade9 extends AppCompatActivity {

    private int result = 0;
    private int errou = 0;
    public String a,b,c,d,e;
    int totalPontos = 0;
    int total;
    EditText aa,bb,cc,dd,ee;
    Button btConfirmaEx,btVerificaResult;
    int vidasCasoRetry,vidas;
    ImageView r0,r1,r2,r3,r4;
    int mapa = 9;
    int btvoltarclidado = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_atividade9);
        btConfirmaEx = findViewById(R.id.btConfirmaEx);
        btVerificaResult = findViewById(R.id.btVerificaResult);
        r0 = findViewById(R.id.imgR);
        r1 = findViewById(R.id.imgR1);
        r2 = findViewById(R.id.imgR2);
        r3 = findViewById(R.id.imgR3);
        r4 = findViewById(R.id.imgR4);

        aa = findViewById(R.id.rex01a);
        bb = findViewById(R.id.rex01b);
        cc = findViewById(R.id.rex01c);
        dd = findViewById(R.id.rex01d);
        ee = findViewById(R.id.rex01e);
        Intent intentReceive = getIntent();
        Bundle param = intentReceive.getExtras();
        if (param != null) {
            total = param.getInt("totalPontos");
            vidas = param.getInt("vidas");
            btvoltarclidado = param.getInt("voltar");
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

        if (a.equals("Bios") || a.equals("BIOS") || a.equals("bios")) {
            result = result + 1;
            r0.setImageResource(R.drawable.v);
        }else{
            r0.setImageResource(R.drawable.xx);
            errou = errou + 1;
            vidas--;

        }
        if (b.equals("Bluetooth")|| b.equals("BLUETOOTH") || b.equals("bluetooth"))  {
            result = result + 1;
            r1.setImageResource(R.drawable.v);
        }
        else{
            r1.setImageResource(R.drawable.xx);
            errou = errou + 1;
            vidas--;
        }
        if (c.equals("COOKIE")|| c.equals("Cookie") || c.equals("cookie") || c.equals("Cookies") || c.equals("cookies"))  {
            result = result + 1;
            r2.setImageResource(R.drawable.v);
        }
        else{
            r2.setImageResource(R.drawable.xx);
            errou = errou + 1;
            vidas--;
        }
        if (d.equals("GATEWAY")|| d.equals("Gateway") || d.equals("gateway"))  {
            result = result + 1;
            r3.setImageResource(R.drawable.v);
        }
        else{
            r3.setImageResource(R.drawable.xx);
            errou = errou + 1;
            vidas--;
        }
        if (e.equals("JAVA SCRIPT")|| e.equals("Java Script") || e.equals("js")|| e.equals("JS") || e.equals("javascript")|| e.equals("java script"))  {
            result = result + 1;
            r4.setImageResource(R.drawable.v);
        } else {
            r4.setImageResource(R.drawable.xx);
            errou = errou + 1;
            vidas--;
        }


        totalPontos = totalPontos + result;
        btConfirmaEx.setVisibility(View.VISIBLE);
        btVerificaResult.setVisibility(View.INVISIBLE);
        aa.setEnabled(false);
        bb.setEnabled(false);
        cc.setEnabled(false);
        dd.setEnabled(false);
        ee.setEnabled(false);
        //alertaResultado(btConfirmaEx);
    }

    public void alertaResultado(View view){

    AlertDialog alertDialog;
    alertDialog = new AlertDialog.Builder(this).create();
        alertDialog.setCancelable(false);
        alertDialog.setTitle(getString(R.string.msg_result));


        if (result == 5) {
        alertDialog.setMessage(getString(R.string.msgHits) + result);
        alertDialog.setButton(getString(R.string.msgNext), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Intent intent = new Intent(getApplicationContext(), MapaAtividadesGeral.class);
                intent.putExtra("totalPontos", totalPontos);
                intent.putExtra("vidas", vidas);
                intent.putExtra("mapa", mapa);
                intent.putExtra("voltar", btvoltarclidado);

                startActivity(intent);
                finish();
            }
        });
    }
        if (result >= 0 && result <= 4 && vidas >= 0) {
        alertDialog.setMessage(getString(R.string.msgHits) + result);
        alertDialog.setButton(Dialog.BUTTON_NEGATIVE, getString(R.string.msgRetry), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Intent intent = new Intent(getApplicationContext(), Atividade9.class);
                intent.putExtra("vidas", vidasCasoRetry);
                intent.putExtra("totalPontos", total);
                intent.putExtra("voltar", btvoltarclidado +1);
                result = 0;
                startActivity(intent);
                finish();
            }
        });

        alertDialog.setButton(Dialog.BUTTON_POSITIVE, getString(R.string.msgNext), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Intent intent = new Intent(getApplicationContext(), MapaAtividadesGeral.class);
                intent.putExtra("totalPontos", totalPontos);
                intent.putExtra("vidas", vidas);
                intent.putExtra("mapa", mapa);
                intent.putExtra("voltar", btvoltarclidado);
                startActivity(intent);
                finish();
            }
        });
    }
        if (vidas < 0) {

        alertDialog.setTitle(getString(R.string.msgGameOver));
        alertDialog.setMessage(getString(R.string.msgTryAgain));
        alertDialog.setButton(getString(R.string.msgRetry), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                intent.putExtra("vidas", vidasCasoRetry);
                intent.putExtra("mapa", mapa);
                result = 0;
                startActivity(intent);
                finish();

            }
        });

    }

        alertDialog.show();
}

    @Override
    public void onBackPressed() {

        AlertDialog alertDialog;
        alertDialog = new AlertDialog.Builder(this).create();
        alertDialog.setCancelable(false);
        alertDialog.setTitle(getString(R.string.msgAlerta));
        alertDialog.setMessage(getString(R.string.msgSair));

        alertDialog.setButton(Dialog.BUTTON_NEGATIVE,getString(R.string.msgNao), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                closeOptionsMenu();
            }
        });

        alertDialog.setButton(Dialog.BUTTON_POSITIVE,getString(R.string.msgSim), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
        alertDialog.setButton(Dialog.BUTTON_NEUTRAL,getString(R.string.msgReiniciar), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Intent intent = new Intent(getApplicationContext(), Atividade9.class);
                intent.putExtra("vidas", vidasCasoRetry);
                intent.putExtra("totalPontos", total);
                intent.putExtra("voltar", btvoltarclidado +1);
                result = 0;
                startActivity(intent);
                finish();
            }
        });

        alertDialog.show();
    }
}
