package com.stenio.gamificacao;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class Atividade5 extends AppCompatActivity {

    TextView txtPergunta,txtResposta;
    ImageView imagem;
    Button b1,b2,b3,b4,b5,b6,btok,btClear,btVerifique;
    int qtdresposta;
    int contatodrbt;
    int qtdVidas;
    int respostasCorretas;
    int mapa = 5;
    int btvoltarclidado = 0;
    int total;
    ////////////////////////////////////////////////////////////////////////////////////////////////

    String pergunta1 = "DNS";
    String respostaCorreta1 = " Domain Name System";
    String[] resposta1 = {"Sound","System","Number", "Name","Domain","Datagram"};
    ////////////////////////////////////////////////////////////////////////////////////////////////

    String pergunta2 = "FTP";
    String respostaCorreta2 = " File Transfer Protocol";
    String[] resposta2 = {"Transfer","Files","The", "Protocol","Production","File"};
    ////////////////////////////////////////////////////////////////////////////////////////////////

    String pergunta3 = "HTTP";
    String respostaCorreta3 = " Hypertext Transfer Protocol";
    String[] resposta3 = {"Hyper","Text","Hypertext", "Protocol","Prototype","Transfer"};
    ////////////////////////////////////////////////////////////////////////////////////////////////

    String pergunta4 = "WWW";
    String respostaCorreta4 = " World Wide Web";
    String[] resposta4 = {"Wide","Web","Where", "World","Word","Wire"};
    ////////////////////////////////////////////////////////////////////////////////////////////////

    String pergunta5 = "NAT";
    String respostaCorreta5 = " Network Address Translation";
    String[] resposta5 = {"Translation","Network","New", "Address","Area","Trasfer"};
    ////////////////////////////////////////////////////////////////////////////////////////////////
    // RESPOSTA DEFINIDA POR MIM MAX 6




    String pergunta;
    String respostaCorreta;
    String[] resposta = {};
    int randomico = 0;
    int vidas,vidasCasoRetry,totalPontos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_atividade5);

        Intent intentReceive = getIntent();
        Bundle param = intentReceive.getExtras();
        if (param != null) {
            total = param.getInt("totalPontos");
            vidas = param.getInt("vidas");
            btvoltarclidado = param.getInt("voltar");
            vidasCasoRetry = vidas;
            totalPontos = total;
        }

        btClear = findViewById(R.id.btClear);
        btVerifique = findViewById(R.id.botaoVerifique);
        btClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtResposta.setText("");
            }
        });
        txtPergunta = findViewById(R.id.txtTitulo);
        txtResposta = findViewById(R.id.txResposta);
        imagem = findViewById(R.id.imgResposta5);
        btok = findViewById(R.id.botaoOk);

        b1 = findViewById(R.id.bt1);
        b2 = findViewById(R.id.bt2);
        b3 = findViewById(R.id.bt3);
        b4 = findViewById(R.id.bt4);
        b5 = findViewById(R.id.bt5);
        b6 = findViewById(R.id.bt6);

        execucao();
    }

    public void execucao(){

        switch (randomico){
            case 0:
                pergunta = pergunta1;
                respostaCorreta = respostaCorreta1;
                resposta = resposta1;

                break;
            case 1:
                pergunta = pergunta2;
                respostaCorreta = respostaCorreta2;
                resposta = resposta2;
                break;
            case 2:
                pergunta = pergunta3;
                respostaCorreta = respostaCorreta3;
                resposta = resposta3;
                break;
            case 3:
                pergunta = pergunta4;
                respostaCorreta = respostaCorreta4;
                resposta = resposta4;
                break;
            case 4:
                pergunta = pergunta5;
                respostaCorreta = respostaCorreta5;
                resposta = resposta5;
                break;
        }
        txtPergunta.setText(pergunta);
        b1.setText(resposta[0]);
        b2.setText(resposta[1]);
        b3.setText(resposta[2]);
        b4.setText(resposta[3]);
        b5.setText(resposta[4]);
        b6.setText(resposta[5]);
        b1.setEnabled(true);
        b2.setEnabled(true);
        b3.setEnabled(true);
        b4.setEnabled(true);
        b5.setEnabled(true);
        b6.setEnabled(true);

        qtdresposta = respostaCorreta.length();

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtResposta.setText(txtResposta.getText().toString() +" "+resposta[0]);
                contatodrbt = txtResposta.length();
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtResposta.setText(txtResposta.getText().toString() +" "+resposta[1]);
                contatodrbt = txtResposta.length();
            }
        });

        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtResposta.setText(txtResposta.getText().toString() +" "+resposta[2]);
                contatodrbt = txtResposta.length();
            }
        });

        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtResposta.setText(txtResposta.getText().toString() +" "+resposta[3]);
                contatodrbt = txtResposta.length();
            }
        });
        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtResposta.setText(txtResposta.getText().toString() +" "+resposta[4]);
                contatodrbt = txtResposta.length();
            }
        });
        b6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtResposta.setText(txtResposta.getText().toString() +" "+resposta[5]);
                contatodrbt = txtResposta.length();
            }
        });

        btVerifique.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                confereResultado();
                btVerifique.setVisibility(View.INVISIBLE);
                btok.setVisibility(View.VISIBLE);
                btClear.setVisibility(View.INVISIBLE);
            }
        });

    }


    public void confereResultado(){
        String respondido = txtResposta.getText().toString();


            if(respondido.equals(respostaCorreta)){
                respostasCorretas++;
                imagem.setVisibility(View.VISIBLE);
                imagem.setImageResource(R.drawable.v);


                b1.setEnabled(false);
                b2.setEnabled(false);
                b3.setEnabled(false);
                b4.setEnabled(false);
                b5.setEnabled(false);
                b6.setEnabled(false);


            }else{
                vidas--;
                imagem.setVisibility(View.VISIBLE);
                imagem.setImageResource(R.drawable.xx);


                b1.setEnabled(false);
                b2.setEnabled(false);
                b3.setEnabled(false);
                b4.setEnabled(false);
                b5.setEnabled(false);
                b6.setEnabled(false);

            }


    }

    public void atualizaPerguntas(View view){

        randomico++;
        txtResposta.setText("");
        imagem.setVisibility(View.INVISIBLE);

        if(randomico == 5){

            AlertDialog alertDialog;
            alertDialog = new AlertDialog.Builder(this).create();
            alertDialog.setCancelable(false);
            alertDialog.setTitle(getString(R.string.msg_result));

                if(vidas < 0){
                    alertDialog.setMessage(getString(R.string.msgGamerOL) +vidas);
                    alertDialog.setButton(getString(R.string.msgTryAgain), new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                            startActivity(intent);
                            finish();
                        }
                    });
                }else {
                    alertDialog.setMessage(getString(R.string.msgHits) +respostasCorretas);
                    alertDialog.setButton(getString(R.string.msgNext), new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Intent intent = new Intent(getApplicationContext(), MapaAtividadesGeral.class);
                            intent.putExtra("vidas", vidas);
                            totalPontos = totalPontos + respostasCorretas;
                            intent.putExtra("totalPontos", totalPontos);
                            intent.putExtra("mapa", mapa);
                            intent.putExtra("voltar", btvoltarclidado);
                            startActivity(intent);
                            finish();
                        }
                    });

                    if (respostasCorretas > 0 && respostasCorretas <= 4) {
                        alertDialog.setButton(Dialog.BUTTON_NEGATIVE, getString(R.string.msgRetry), new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Intent intent = new Intent(getApplicationContext(), Atividade5.class);
                                intent.putExtra("vidas", vidasCasoRetry);
                                intent.putExtra("totalPontos", total);
                                intent.putExtra("voltar", btvoltarclidado +1);
                                startActivity(intent);
                            }
                        });
                    }

            }


            alertDialog.show();

        }
        btVerifique.setVisibility(View.VISIBLE);
        btok.setVisibility(View.INVISIBLE);
        btClear.setVisibility(View.VISIBLE);
        execucao();

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
                Intent intent = new Intent(getApplicationContext(), Atividade5.class);
                intent.putExtra("vidas", vidasCasoRetry);
                intent.putExtra("totalPontos", total);
                intent.putExtra("voltar", btvoltarclidado +1);
                startActivity(intent);
            }
        });

        alertDialog.show();
    }
}
