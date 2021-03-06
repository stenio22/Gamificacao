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
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;


public class Atividade1 extends AppCompatActivity {

    int mapa = 1;
    TextView titulo;
    ImageView imgVerificar,imgTitulo;
    Button btOk;
    RadioButton opcaoA,opcaoB,opcaoC;
    RadioGroup radio;
    int posicaoPergunta = 0;
    int respostasCorretas = 0;
    int indice = 0;
    int btvoltarclidado = 0;

    String pergunta1 = "What is it?";
//    String pergunta2 = "";
//    String pergunta3 = "";
//    String pergunta4 = "";
//    String pergunta5 = "";

    String resposta1a = "Hard Drive";
    String resposta1b = "Hard Disc";
    String resposta1c = "Hard Burn";

    String resposta2a = "Touch Screen";
    String resposta2b = "Monitor";
    String resposta2c = "Wide Screen";

    String resposta3a = "GPU";
    String resposta3b = "Processor";
    String resposta3c = "Calculator";

    String resposta4a = "Video Card";
    String resposta4b = "Dashboard";
    String resposta4c = "Motherboard";

    String resposta5a = "Ram memory";
    String resposta5b = "Rom memory";
    String resposta5c = "Cache memory";


int valorNivel,vidasCasoRetry,vidas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_atividade1);



        Intent intentReceive = getIntent();
        Bundle param = intentReceive.getExtras();
        if (param != null) {
            valorNivel = param.getInt("vidas");
            btvoltarclidado = param.getInt("voltar");
            vidasCasoRetry = valorNivel;
            vidas = valorNivel;
        }

        titulo = findViewById(R.id.txtTitulo);
        imgVerificar = findViewById(R.id.imgVerificar);
        imgTitulo = findViewById(R.id.imgTitulo);
        btOk = findViewById(R.id.botaoOk);
        opcaoA = findViewById(R.id.opcaoA);
        opcaoB = findViewById(R.id.opcaoB);
        opcaoC = findViewById(R.id.opcaoC);
        radio = findViewById(R.id.grupoRadio);


        atualizarFormulario();



        radio.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.opcaoA:
                        imgVerificar.setVisibility(View.VISIBLE);
                        if(posicaoPergunta == 1 || posicaoPergunta == 5){
                            respostasCorretas++;
                            imgVerificar.setImageResource(R.drawable.v);
                        }else{
                            vidas--;
                            imgVerificar.setImageResource(R.drawable.xx);
                        }
                        opcaoA.setEnabled(false);
                        opcaoB.setEnabled(false);
                        opcaoC.setEnabled(false);
                        radio.clearCheck();
                        btOk.setEnabled(true);
                        break;

                    case R.id.opcaoB:
                        imgVerificar.setVisibility(View.VISIBLE);
                        if(posicaoPergunta == 2 || posicaoPergunta == 3){
                            respostasCorretas++;
                            imgVerificar.setImageResource(R.drawable.v);
                        }else{
                            vidas--;
                            imgVerificar.setImageResource(R.drawable.xx);
                        }
                        opcaoA.setEnabled(false);
                        opcaoB.setEnabled(false);
                        opcaoC.setEnabled(false);
                        radio.clearCheck();
                        btOk.setEnabled(true);

                        break;
                    case R.id.opcaoC:
                        imgVerificar.setVisibility(View.VISIBLE);
                        if(posicaoPergunta == 4 ){
                            respostasCorretas++;
                            imgVerificar.setImageResource(R.drawable.v);
                        }else{
                            vidas--;
                            imgVerificar.setImageResource(R.drawable.xx);
                        }
                        opcaoA.setEnabled(false);
                        opcaoB.setEnabled(false);
                        opcaoC.setEnabled(false);
                        radio.clearCheck();
                        btOk.setEnabled(true);
                        break;
                }

                btOk.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        atualizarFormulario();
                        opcaoA.setEnabled(true);
                        opcaoB.setEnabled(true);
                        opcaoC.setEnabled(true);
                        imgVerificar.setVisibility(View.INVISIBLE);
                        btOk.setEnabled(false);

                    }
                });
            }
        });


    }

    public  void atualizarFormulario(){
        imgVerificar.setVisibility(View.INVISIBLE);


        switch (posicaoPergunta){
            case 0:
                imgTitulo.setImageResource(R.drawable.hd);
                titulo.setText(pergunta1);
                opcaoA.setText(resposta1a);
                opcaoB.setText(resposta1b);
                opcaoC.setText(resposta1c);
                posicaoPergunta++;
                break;

            case 1:
                imgTitulo.setImageResource(R.drawable.monitor);
                titulo.setText(pergunta1);
                opcaoA.setText(resposta2a);
                opcaoB.setText(resposta2b);
                opcaoC.setText(resposta2c);
                radio.clearCheck();
                posicaoPergunta++;

                break;

            case 2:
                imgTitulo.setImageResource(R.drawable.processador);
                titulo.setText(pergunta1);
                opcaoA.setText(resposta3a);
                opcaoB.setText(resposta3b);
                opcaoC.setText(resposta3c);
                posicaoPergunta++;
                break;

            case 3:
                imgTitulo.setImageResource(R.drawable.placamae);
                titulo.setText(pergunta1);
                opcaoA.setText(resposta4a);
                opcaoB.setText(resposta4b);
                opcaoC.setText(resposta4c);
                posicaoPergunta++;
                break;
            case 4:
                imgTitulo.setImageResource(R.drawable.memoria);
                titulo.setText(pergunta1);
                opcaoA.setText(resposta5a);
                opcaoB.setText(resposta5b);
                opcaoC.setText(resposta5c);
                posicaoPergunta++;
                break;
            case 5:
                alertaResultado();
        }

    }


    public void alertaResultado() {
        AlertDialog alertDialog;
        alertDialog = new AlertDialog.Builder(this).create();
        alertDialog.setCancelable(false);
        alertDialog.setTitle(getString(R.string.msg_result));

        if(respostasCorretas == 5) {
            alertDialog.setMessage(getString(R.string.msgHits) + respostasCorretas );
            alertDialog.setButton(getString(R.string.msgNext), new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    Intent intent = new Intent(getApplicationContext(), MapaAtividadesGeral.class);
                    intent.putExtra("totalPontos", respostasCorretas);
                    intent.putExtra("vidas", vidas);
                    intent.putExtra("mapa", mapa);
                    intent.putExtra("voltar", btvoltarclidado);

                    startActivity(intent);
                    finish();
                }
            });
        }if(respostasCorretas >= 0 && respostasCorretas <= 4 && vidas >= 0){
            alertDialog.setMessage(getString(R.string.msgHits)  + respostasCorretas );
            alertDialog.setButton(Dialog.BUTTON_NEGATIVE,getString(R.string.msgRetry), new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    Intent intent = new Intent(getApplicationContext(), Atividade1.class);
                    intent.putExtra("vidas", vidasCasoRetry);
                    intent.putExtra("voltar", btvoltarclidado + 1);
                    respostasCorretas = 0;
                    startActivity(intent);
                    finish();
                }
            });

            alertDialog.setButton(Dialog.BUTTON_POSITIVE,getString(R.string.msgNext), new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    Intent intent = new Intent(getApplicationContext(), MapaAtividadesGeral.class);
                    intent.putExtra("totalPontos", respostasCorretas);
                    intent.putExtra("vidas", vidas);
                    intent.putExtra("mapa", mapa);
                    intent.putExtra("voltar", btvoltarclidado);
                    startActivity(intent);
                    finish();
                }
            });
        }if (vidas < 0) {
            alertDialog.setTitle(getString(R.string.msgGameOver));
            alertDialog.setMessage(getString(R.string.msgGamerOL) +vidas);
            alertDialog.setButton(getString(R.string.msgRetry), new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                    intent.putExtra("vidas", vidasCasoRetry);
                    intent.putExtra("mapa", mapa);
                    respostasCorretas = 0;
                    startActivity(intent);
                    finish();

                }
            });

        }
        alertDialog.show();
        btOk.setEnabled(false);
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


