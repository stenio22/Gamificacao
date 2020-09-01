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
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class Atividade1 extends AppCompatActivity {


    public RadioGroup radioGroup;
    public TextView textoPergunta;
    public RadioButton opcaoA;
    public RadioButton opcaoB;
    public RadioButton opcaoC;
    public Button botaoOk;



    //intenção buscar perguntas e respostas via DB no entanto coloquei como string dentro de vetores
    String Perguntas[] = {"what is it ?",
            "what is it ?",
            "what is it ?",
            "what is it ?",
            "what is it ?"};

    String OpcaoA[] = {"Hard Drive",
            "Screen",
            "GPU",
            "Video Card",
            "RAM memory"};

    String OpcaoB[] = {"Hard Disc",
            "Monitor",
            "Processor",
            "Network card",
            "ROM memory"};

    String OpcaoC[] = {"Head Fone",
            "Wide Screen",
            "Calculator",
            "Motherboard",
            "Cache memory"};


    int[] listaRespostas = new int[Perguntas.length];
    int listaGabarito[] = {1, 2, 2, 3, 1};
    int respostasCorretas = 0;
    int numeroPergunta = 0;
    int nivel;
    int vidasCasoRetry;
    int valorNivel = 0;
    int erros = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_atividade1);


        Intent intentReceive = getIntent();
        Bundle param = intentReceive.getExtras();
        if (param != null) {
            valorNivel = param.getInt("vidas");
            vidasCasoRetry = valorNivel;
            nivel = valorNivel;
        }


        botaoOk = (Button) findViewById(R.id.botaoOk);
        botaoOk.setEnabled(false);
        textoPergunta = (TextView) findViewById(R.id.txtPistaForca);
        opcaoA = (RadioButton) findViewById(R.id.opcaoA);
        opcaoB = (RadioButton) findViewById(R.id.opcaoB);
        opcaoC = (RadioButton) findViewById(R.id.opcaoC);
        radioGroup = (RadioGroup) findViewById(R.id.grupoRadio);
        atualizaPerguntas(botaoOk);
        final ListView listView;

        // só ativa o botão OK
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.opcaoA:
                        Log.d("s", "Opcao n1!");
                        listaRespostas[numeroPergunta - 1] = 1;
                        break;

                    case R.id.opcaoB:
                        Log.d("s", "Opcao n2!");
                        listaRespostas[numeroPergunta - 1] = 2;
                        break;

                    case R.id.opcaoC:
                        Log.d("s", "Opcao n3!");
                        listaRespostas[numeroPergunta - 1] = 3;
                        break;
                }

                botaoOk.setEnabled(true);

            }
        });
    }

    public void atualizaPerguntas(View view) {
        if (numeroPergunta == 0) {
            ImageView imagemC = (ImageView) findViewById(R.id.imgForca);
            imagemC.setImageResource(R.drawable.hd);
        }
        if (numeroPergunta == 1) {
            ImageView imagemC = (ImageView) findViewById(R.id.imgForca);
            imagemC.setImageResource(R.drawable.monitor);
        }
        if (numeroPergunta == 2) {
            ImageView imagemC = (ImageView) findViewById(R.id.imgForca);
            imagemC.setImageResource(R.drawable.processador);
        }
        if (numeroPergunta == 3) {
            ImageView imagemC = (ImageView) findViewById(R.id.imgForca);
            imagemC.setImageResource(R.drawable.placamae);
        }
        if (numeroPergunta == 4) {
            ImageView imagemC = (ImageView) findViewById(R.id.imgForca);
            imagemC.setImageResource(R.drawable.memoria);
        }
        if (numeroPergunta == Perguntas.length) {
            opcaoA.setEnabled(false);
            opcaoB.setEnabled(false);
            opcaoC.setEnabled(false);
            radioGroup.clearCheck();
            confereResultado();
        } else {
            textoPergunta.setText(Perguntas[numeroPergunta]);
            opcaoA.setText(OpcaoA[numeroPergunta]);
            opcaoB.setText(OpcaoB[numeroPergunta]);
            opcaoC.setText(OpcaoC[numeroPergunta]);
            numeroPergunta++;
            botaoOk.setEnabled(false);
            radioGroup.clearCheck();
        }
    }

    public void confereResultado() {
        int contadorLista = 0;


        for (int numero : listaRespostas) {
            System.out.println(numero);
            if (numero == listaGabarito[contadorLista]) {
                respostasCorretas++;

                System.out.println("Resposta Correta!!!");

            } else {

                erros++;
                nivel--;


            System.out.println("Resposta Errada!!!");
        }
        contadorLista++;
    }

    alertaResultado(botaoOk);

}



    public void alertaResultado(View view) {
        AlertDialog alertDialog;
        alertDialog = new AlertDialog.Builder(this).create();
        alertDialog.setCancelable(false);
        alertDialog.setTitle("Resultado!");


        if(respostasCorretas == 5) {
            alertDialog.setMessage("Voce acertou " + respostasCorretas + " questoes!");
            alertDialog.setButton("GO NEXT", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    Intent intent = new Intent(getApplicationContext(), MapaAtividades2.class);
                    intent.putExtra("totalPontos", respostasCorretas);
                    intent.putExtra("vidas", nivel);

                    startActivity(intent);
                    finish();
                }
            });
        }if(respostasCorretas > 0 && respostasCorretas <= 4){
            alertDialog.setMessage("Você acertou " + respostasCorretas );
            alertDialog.setButton(Dialog.BUTTON_NEGATIVE,"Tentar Novamente", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    Intent intent = new Intent(getApplicationContext(), Atividade1.class);
                    intent.putExtra("vidas", vidasCasoRetry);
                    respostasCorretas = 0;
                    startActivity(intent);
                    finish();
                }
            });

            alertDialog.setButton(Dialog.BUTTON_POSITIVE,"Avançar", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    Intent intent = new Intent(getApplicationContext(), MapaAtividades2.class);
                    intent.putExtra("totalPontos", respostasCorretas);
                    intent.putExtra("vidas", nivel);
                    startActivity(intent);
                    finish();
                }
            });
         }if (nivel < 0) {

            alertDialog.setTitle("='( Você ficou sem vidas!!");
            alertDialog.setMessage(" Você não tem mais Vidas ");
            alertDialog.setButton("Tentar Novamente", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    Intent intent = new Intent(getApplicationContext(), Atividade1.class);
                    intent.putExtra("vidas", vidasCasoRetry);
                    respostasCorretas = 0;
                    startActivity(intent);
                    finish();

                }
            });

        }

        alertDialog.show();

        botaoOk.setEnabled(false);

    }

}


