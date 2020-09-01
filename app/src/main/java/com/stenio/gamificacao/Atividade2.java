package com.stenio.gamificacao;


import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.DecelerateInterpolator;
import android.widget.ImageView;
import android.widget.TextView;

public class Atividade2 extends AppCompatActivity {


    ImageView img1, img2, img3, img4, img5, img6, img7, img8, img9, img10, img11, img12;
    TextView txtTitulo;
    int mapa = 2;
    int imagemaberta1;
    int imagemaberta2;
    int ativo;
    int passarFase = 0;
    int total,totalPontos;
    int vidas = 0;
    int btvoltarclidado = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_atividade2);

        Intent intentReceive = getIntent();
        Bundle param = intentReceive.getExtras();
        if (param != null) {
            total = param.getInt("totalPontos");
            totalPontos = total;
            vidas = param.getInt("vidas");
            btvoltarclidado = param.getInt("voltar");
        }

        img1 = findViewById(R.id.img1);
        img2 = findViewById(R.id.img2);
        img3 = findViewById(R.id.img3);
        img4 = findViewById(R.id.img4);
        img5 = findViewById(R.id.img5);
        img6 = findViewById(R.id.img6);
        img7 = findViewById(R.id.img7);
        img8 = findViewById(R.id.img8);
        img9 = findViewById(R.id.img9);
        img10 = findViewById(R.id.img10);
        img11 = findViewById(R.id.img11);
        img12 = findViewById(R.id.img12);
        txtTitulo = findViewById(R.id.txtTitulo);

        imagemX();
        // a combinação sera
        //img1 e img3
        //img2 e img7
        //img4 e img12
        //img5 e img10
        //img6 e img11
        //img8 e img9

        final Animation fadeIn = new AlphaAnimation(0, 1);
        fadeIn.setInterpolator(new DecelerateInterpolator());
        fadeIn.setDuration(1500);
        fadeIn.reset();
        final AnimationSet animation = new AnimationSet(true);
        animation.addAnimation(fadeIn);



        img1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(ativo == 1){

                }if(ativo == 2){
                    imagemX();
                    ativo = 0;
                }

                img1.setImageResource(R.drawable.windows);
                img1.setAnimation(animation);
                imagemaberta1 = 1;
                ativo++;
                taAtivo();


            }
        });

        img2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(ativo == 1){

                }if(ativo == 2){
                    imagemX();
                    ativo = 0;
                }


                img2.setImageResource(R.drawable.mac);
                img2.setAnimation(animation);
                imagemaberta1 = 2;
                ativo++;
                taAtivo();
            }
        });

        img3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(ativo == 1){

                }if(ativo == 2){
                    imagemX();
                    ativo = 0;
                }


                img3.setImageResource(R.drawable.windows);
                img3.setAnimation(animation);
                imagemaberta2 = 1;
                ativo++;
                taAtivo();

            }
        });

        img4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(ativo == 1){

                }if(ativo == 2){
                    imagemX();
                    ativo = 0;
                }

                img4.setImageResource(R.drawable.ubuntu);
                img4.setAnimation(animation);
                imagemaberta1 = 3;
                ativo++;
                taAtivo();

            }
        });

        img5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(ativo == 1){

                }if(ativo == 2){
                    imagemX();
                    ativo = 0;
                }

                img5.setImageResource(R.drawable.mandriva);
                img5.setAnimation(animation);
                imagemaberta1 = 4;
                ativo++;
                taAtivo();
            }
        });

        img6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(ativo == 1){

                }if(ativo == 2){
                    imagemX();
                    ativo = 0;
                }

                img6.setImageResource(R.drawable.unix);
                img6.setAnimation(animation);
                imagemaberta1 = 5;
                ativo++;
                taAtivo();


            }
        });
        img7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(ativo == 1){

                }if(ativo == 2){
                    imagemX();
                    ativo = 0;
                }


                img7.setImageResource(R.drawable.mac);
                img7.setAnimation(animation);
                imagemaberta2 = 2;
                ativo++;
                taAtivo();
            }
        });
        img8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(ativo == 1){

                }if(ativo == 2){
                    imagemX();
                    ativo = 0;
                }


                img8.setImageResource(R.drawable.suse);
                img8.setAnimation(animation);
                imagemaberta1 = 6;
                ativo++;
                taAtivo();

            }
        });
        img9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(ativo == 1){

                }if(ativo == 2){
                    imagemX();
                    ativo = 0;
                }

                img9.setImageResource(R.drawable.suse);
                img9.setAnimation(animation);
                imagemaberta2 = 6;
                ativo++;
                taAtivo();
            }
        });
        img10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(ativo == 1){

                }if(ativo == 2){
                    imagemX();
                    ativo = 0;
                }

                img10.setImageResource(R.drawable.mandriva);
                img10.setAnimation(animation);
                imagemaberta2 = 4;
                ativo++;
                taAtivo();

            }
        });
        img11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(ativo == 1){

                }if(ativo == 2){
                    imagemX();
                    ativo = 0;
                }
                img11.setImageResource(R.drawable.unix);
                img11.setAnimation(animation);
                imagemaberta2 = 5;
                ativo++;
                taAtivo();
            }
        });
        img12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(ativo == 1){

                }if(ativo == 2){
                    imagemX();
                    ativo = 0;
                }

                img12.setImageResource(R.drawable.ubuntu);
                img12.setAnimation(animation);
                imagemaberta2 = 3;
                ativo++;
                taAtivo();

            }
        });

    }


    public void verificaIgual() {


        // 1
        if (imagemaberta1 == 1 && imagemaberta2 == 1) {
            img1.setVisibility(View.INVISIBLE);
            img3.setVisibility(View.INVISIBLE);
            ativo = 0;
        }
        //2
        if (imagemaberta1 == 2 && imagemaberta2 == 2) {
            img2.setVisibility(View.INVISIBLE);
            img7.setVisibility(View.INVISIBLE);
            ativo = 0;
        }
        //3
        if (imagemaberta1 == 3 && imagemaberta2 == 3) {
            img4.setVisibility(View.INVISIBLE);
            img12.setVisibility(View.INVISIBLE);
            ativo = 0;
        }
        //4
        if (imagemaberta1 == 4 && imagemaberta2 == 4) {
            img5.setVisibility(View.INVISIBLE);
            img10.setVisibility(View.INVISIBLE);
            ativo = 0;
        }
        //5
        if (imagemaberta1 == 5 && imagemaberta2 == 5) {
            img6.setVisibility(View.INVISIBLE);
            img11.setVisibility(View.INVISIBLE);
            ativo = 0;
        }

        //6
        if(imagemaberta1  ==6&&imagemaberta2 ==6)

        {
            img8.setVisibility(View.INVISIBLE);
            img9.setVisibility(View.INVISIBLE);
            ativo = 0;
        }
    }


    public void imagemX(){


        img1.setImageResource(R.drawable.institutofederal);
        img2.setImageResource(R.drawable.institutofederal);
        img3.setImageResource(R.drawable.institutofederal);
        img4.setImageResource(R.drawable.institutofederal);
        img5.setImageResource(R.drawable.institutofederal);
        img6.setImageResource(R.drawable.institutofederal);
        img7.setImageResource(R.drawable.institutofederal);
        img8.setImageResource(R.drawable.institutofederal);
        img9.setImageResource(R.drawable.institutofederal);
        img10.setImageResource(R.drawable.institutofederal);
        img11.setImageResource(R.drawable.institutofederal);
        img12.setImageResource(R.drawable.institutofederal);

    }

    public void taAtivo() {

        if (ativo == 2) {

            if(imagemaberta1 == imagemaberta2){
                verificaIgual();
                passarFase = passarFase + 1;

            }else{
                imagemaberta2 = 0;
                imagemaberta1 = 0;
            }
        }
        if(passarFase == 6) {
            passarFase();
        }
    }

    public void passarFase() {


        Intent intent = new Intent(getApplicationContext(), MapaAtividadesGeral.class);
        intent.putExtra("totalPontos", total + 5);
        intent.putExtra("vidas", vidas);
        intent.putExtra("mapa", mapa);
        intent.putExtra("voltar", btvoltarclidado);
        startActivity(intent);
        finish();

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

