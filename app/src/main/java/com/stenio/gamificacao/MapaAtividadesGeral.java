package com.stenio.gamificacao;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MapaAtividadesGeral extends AppCompatActivity {

    Button btProsseguir5;
    int totalPontos;
    TextView totalaa,qtdVoltou;
    ImageView star,totalVidas;
    int vidas;
    int mapa;
    int btvoltarclidado = 0;
    ImageView b1,b2,b3,b4,b5,b6,b7,b8,b9,b10;
    int e1,e2,e3,e4,e5,e6,e7,e8,e9,e10;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mapa_atividades_geral);

        btProsseguir5 = findViewById(R.id.btProsseguir5);
        totalVidas = findViewById(R.id.imgQtdVidas);
        qtdVoltou = findViewById(R.id.txtQtdVoltou);

        b1 = findViewById(R.id.imgB1);
        b2 = findViewById(R.id.imgB2);
        b3 = findViewById(R.id.imgB3);
        b4 = findViewById(R.id.imgB4);
        b5 = findViewById(R.id.imgB5);
        b6 = findViewById(R.id.imgB6);
        b7 = findViewById(R.id.imgB7);
        b8 = findViewById(R.id.imgB8);
        b9 = findViewById(R.id.imgB9);
        b10 = findViewById(R.id.imgB10);





        star = findViewById(R.id.imgStar);
        totalaa = findViewById(R.id.txtTotalPontos4);

        Intent intentReceive = getIntent();
        Bundle param = intentReceive.getExtras();
        if (param != null) {
            int total = param.getInt("totalPontos");
            vidas = param.getInt("vidas");
            mapa = param.getInt("mapa");
            btvoltarclidado = param.getInt("voltar");
            totalPontos = total;

            if(vidas == 1){
                totalVidas.setImageResource(R.drawable.uma);
            }if(vidas == 2){
                totalVidas.setImageResource(R.drawable.duasvidas);
            }if(vidas == 3){
                totalVidas.setImageResource(R.drawable.tresvidas);
            }if(vidas == 4){
                totalVidas.setImageResource(R.drawable.quatro);
            }if(vidas == 5){
                totalVidas.setImageResource(R.drawable.cincocoracoes);
            }if(vidas == 6){
                totalVidas.setImageResource(R.drawable.seiscoracoes);
            }

            totalPontos = total;
            totalaa.setText(String.valueOf(total));
            qtdVoltou.setText(String.valueOf(btvoltarclidado));

            if(mapa == 1){
                b2.setVisibility(View.VISIBLE);
            } if(mapa == 2){
                b3.setVisibility(View.VISIBLE);
            } if(mapa == 3){
                b4.setVisibility(View.VISIBLE);
            } if(mapa == 4){
                b5.setVisibility(View.VISIBLE);
            } if(mapa == 5){
                b6.setVisibility(View.VISIBLE);
            } if(mapa == 6){
                b7.setVisibility(View.VISIBLE);
            } if(mapa == 7){
                b8.setVisibility(View.VISIBLE);
            } if(mapa == 8){
                b9.setVisibility(View.VISIBLE);
            } if(mapa == 9){
                b10.setVisibility(View.VISIBLE);
            }

        }

        if (totalPontos >= 5) {

            star.setVisibility(View.VISIBLE);

            RotateAnimation anim = new RotateAnimation(0.0f, 360.0f, Animation.RESTART, 0.5f, Animation.REVERSE, 0.5f);

            //Setup anim with desired properties
            anim.setInterpolator(new LinearInterpolator());
            //anim.setRepeatCount(Animation.INFINITE); //Repeat animation indefinitely
            anim.setDuration(700); //Put desired duration per anim cycle here, in milliseconds

            //Start animation
            star.startAnimation(anim);
            //Later on, use view.setAnimation(null) to stop it.

        }


        btProsseguir5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                switch (mapa){
                    case 0:
                        e1 = totalPontos;
                        Intent intent = new Intent(getApplicationContext(), Atividade1.class);
                        intent.putExtra("totalPontos", e1);
                        intent.putExtra("vidas",vidas);
                        intent.putExtra("voltar", btvoltarclidado);
                        startActivity(intent);
                        break;

                    case 1:
                        e2 = totalPontos;
                        Intent intent1 = new Intent(getApplicationContext(), Atividade2.class);
                        intent1.putExtra("totalPontos", e2);
                        intent1.putExtra("vidas",vidas);
                        intent1.putExtra("voltar", btvoltarclidado);
                        startActivity(intent1);
                        break;
                    case 2:
                        e3 = totalPontos;
                        Intent intent2 = new Intent(getApplicationContext(), Atividade3.class);
                        intent2.putExtra("totalPontos", e3);
                        intent2.putExtra("vidas",vidas);
                        intent2.putExtra("voltar", btvoltarclidado);
                        startActivity(intent2);
                        break;
                    case 3:
                        e4 = totalPontos;
                        Intent intent3 = new Intent(getApplicationContext(), Atividade4.class);
                        intent3.putExtra("totalPontos", e4);
                        intent3.putExtra("vidas",vidas);
                        intent3.putExtra("voltar", btvoltarclidado);
                        startActivity(intent3);
                        break;
                    case 4:
                        e5 = totalPontos;
                        Intent intent4 = new Intent(getApplicationContext(), Atividade5.class);
                        intent4.putExtra("totalPontos", e5);
                        intent4.putExtra("vidas",vidas);
                        intent4.putExtra("voltar", btvoltarclidado);
                        startActivity(intent4);
                        break;
                    case 5:
                        e6 = totalPontos;
                        Intent intent5 = new Intent(getApplicationContext(), Atividade6.class);
                        intent5.putExtra("totalPontos", e6);
                        intent5.putExtra("vidas",vidas);
                        intent5.putExtra("voltar", btvoltarclidado);
                        startActivity(intent5);
                        break;
                    case 6:
                        e7 = totalPontos;
                        Intent intent6 = new Intent(getApplicationContext(), Atividade7.class);
                        intent6.putExtra("totalPontos", e7);
                        intent6.putExtra("vidas",vidas);
                        intent6.putExtra("voltar", btvoltarclidado);
                        startActivity(intent6);
                        break;
                    case 7:
                        e8 = totalPontos;
                        Intent intent7 = new Intent(getApplicationContext(), Atividade8.class);
                        intent7.putExtra("totalPontos", e8);
                        intent7.putExtra("vidas",vidas);
                        intent7.putExtra("voltar", btvoltarclidado);
                        startActivity(intent7);
                        break;
                    case 8:
                        e9 = totalPontos;
                        Intent intent8 = new Intent(getApplicationContext(), Atividade9.class);
                        intent8.putExtra("totalPontos", e9);
                        intent8.putExtra("vidas",vidas);
                        intent8.putExtra("voltar", btvoltarclidado);
                        startActivity(intent8);
                        break;
                    case 9:
                        e10 = totalPontos;
                        Intent intent9 = new Intent(getApplicationContext(), Atividade10.class);
                        intent9.putExtra("totalPontos", e10);
                        intent9.putExtra("vidas",vidas);
                        intent9.putExtra("voltar", btvoltarclidado);
                        startActivity(intent9);
                        break;
                    case 10:
                        Intent intent10 = new Intent(getApplicationContext(), MapaAtividadeFinal.class);
                        intent10.putExtra("totalPontos", totalPontos);
                        intent10.putExtra("vidas",vidas);
                        intent10.putExtra("voltar", btvoltarclidado);
                        startActivity(intent10);
                        break;
                }



            }
        });
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

        alertDialog.show();
    }
}
