package com.stenio.gamificacao;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class Atividade8 extends AppCompatActivity {

    TextView txtPista, t1, t2, t3, t4, t5, t6, t7, t8, t9, t10;
    ImageView forca;
    Button btA, btB, btC, btD, btE, btF, btG, btH, btI, btJ, btK, btL, btM, btN, btO, btP, btQ, btR, btS, btT, btU, btV, btX, btY, btZ,btW;
    String respostaAtual;
    int resultadoFinal,totalPontos;
    int vidas,total;
    int vidasCasoRetry;
    int mapa = 8;
    int btvoltarclidado = 0;
    String[] pistas = {"Fazer uma cópia de programas ou dados para evitar perda dos mesmos",
            "Sistema básico de entrada e saída é o programa mais elementar existente no computador.",
            "É um aplicativo cuja função é navegar pelas páginas da internet.",
            " Na informática chamamos de um mal funcionamento do sistema, uma falha de desenvolvimento.",
            "Registrado, protegido por direitos autorais",
            "Resolver, decifrar, na informática é um programa criado para violar outros programas sem permissão do autor",
    };

    String[] respostas = {
            "Backup",
            "BIOS",
            "Browser",
            "Bug",
            "Copyright",
            "Crack",
    };

    int tentativa = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_atividade8);

        Intent intentReceive = getIntent();
        Bundle param = intentReceive.getExtras();
        if (param != null) {
            total = param.getInt("totalPontos");
            vidas = param.getInt("vidas");
            btvoltarclidado = param.getInt("voltar");
            vidasCasoRetry = vidas;
            totalPontos = total;
        }


        forca = findViewById(R.id.imgTitulo);
        txtPista = findViewById(R.id.txtTitulo);
        t1 = findViewById(R.id.t1);
        t2 = findViewById(R.id.t2);
        t3 = findViewById(R.id.t3);
        t4 = findViewById(R.id.t4);
        t5 = findViewById(R.id.t5);
        t6 = findViewById(R.id.t6);
        t7 = findViewById(R.id.t7);
        t8 = findViewById(R.id.t8);
        t9 = findViewById(R.id.t9);
        t10 = findViewById(R.id.t10);
        btA = findViewById(R.id.btLetraA);
        btB = findViewById(R.id.btLetraB);
        btC = findViewById(R.id.btLetraC);
        btD = findViewById(R.id.btLetraD);
        btE = findViewById(R.id.btLetraE);
        btF = findViewById(R.id.btLetraF);
        btG = findViewById(R.id.btLetraG);
        btH = findViewById(R.id.btLetraH);
        btI = findViewById(R.id.btLetraI);
        btJ = findViewById(R.id.btLetraJ);
        btK = findViewById(R.id.btLetraK);
        btL = findViewById(R.id.btLetraL);
        btM = findViewById(R.id.btLetraM);
        btN = findViewById(R.id.btLetraN);
        btO = findViewById(R.id.btLetraO);
        btP = findViewById(R.id.btLetraP);
        btQ = findViewById(R.id.btLetraQ);
        btR = findViewById(R.id.btLetraR);
        btS = findViewById(R.id.btLetraS);
        btT = findViewById(R.id.btLetraT);
        btU = findViewById(R.id.btLetraU);
        btV = findViewById(R.id.btLetraV);
        btX = findViewById(R.id.btLetraX);
        btY = findViewById(R.id.btLetraY);
        btZ = findViewById(R.id.btLetraZ);
        btW = findViewById(R.id.btLetraW);

        int randomico = new Random().nextInt(pistas.length);
        txtPista.setText(pistas[randomico]);
        respostaAtual = respostas[randomico];

        int conta = 0;
        conta = respostas[randomico].length();
        if(conta == 1 ){
            t1.setText("__");
        }if(conta == 2){
            t1.setText("__");
            t2.setText("__");
        }if(conta == 3){
            t1.setText("__");
            t2.setText("__");
            t3.setText("__");
        }if(conta == 4){
            t1.setText("__");
            t2.setText("__");
            t3.setText("__");
            t4.setText("__");
        }if(conta == 5){
            t1.setText("__");
            t2.setText("__");
            t3.setText("__");
            t4.setText("__");
            t5.setText("__");
        }if(conta == 6){
            t1.setText("__");
            t2.setText("__");
            t3.setText("__");
            t4.setText("__");
            t5.setText("__");
            t6.setText("__");
        }if(conta == 7){
            t1.setText("__");
            t2.setText("__");
            t3.setText("__");
            t4.setText("__");
            t5.setText("__");
            t6.setText("__");
            t7.setText("__");
        }if(conta == 8){
            t1.setText("__");
            t2.setText("__");
            t3.setText("__");
            t4.setText("__");
            t5.setText("__");
            t6.setText("__");
            t7.setText("__");
            t8.setText("__");
        }if(conta == 9){
            t1.setText("__");
            t2.setText("__");
            t3.setText("__");
            t4.setText("__");
            t5.setText("__");
            t6.setText("__");
            t7.setText("__");
            t8.setText("__");
            t9.setText("__");
        }if(conta == 10){
            t1.setText("__");
            t2.setText("__");
            t3.setText("__");
            t4.setText("__");
            t5.setText("__");
            t6.setText("__");
            t7.setText("__");
            t8.setText("__");
            t9.setText("__");
            t10.setText("__");
        }else {
        }
    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btLetraA:
                btA.setBackgroundColor(Color.parseColor("#CCCCCC"));
                if (respostaAtual == "Backup") {
                    t2.setText("A");
                    if( t1.getText().toString() == "B" &&
                            t2.getText().toString() == "A" &&
                            t3.getText().toString() == "C" &&
                            t4.getText().toString() == "K" &&
                            t5.getText().toString() == "U" &&
                            t6.getText().toString() == "P"
                    ){

                        resultadoFinal = 1;
                        alertaResultado(btA);
                    }
                    break;
                }
                if (respostaAtual == "Crack") {
                    t3.setText("A");
                    if(
                            t1.getText().toString() == "C" &&
                                    t2.getText().toString() == "R" &&
                                    t3.getText().toString() == "A" &&
                                    t4.getText().toString() == "C" &&
                                    t5.getText().toString() == "K")
                    {
                        resultadoFinal = 1;
                        alertaResultado(btA);
                    }
                    break;
                }
                if (respostaAtual == "Download") {
                    t7.setText("A");

                    if(
                            t1.getText().toString() == "D" &&
                                    t2.getText().toString() == "O" &&
                                    t3.getText().toString() == "W" &&
                                    t4.getText().toString() == "N" &&
                                    t5.getText().toString() == "L" &&
                                    t6.getText().toString() == "O" &&
                                    t7.getText().toString() == "A" &&
                                    t8.getText().toString() == "D" )
                    {
                        resultadoFinal = 1;
                        alertaResultado(btA);
                    }


                    break;
                }
                if (respostaAtual == "Database") {
                    t2.setText("A");
                    t4.setText("A");
                    t6.setText("A");
                    if(
                            t1.getText().toString() == "D" &&
                                    t2.getText().toString() == "A" &&
                                    t3.getText().toString() == "T" &&
                                    t4.getText().toString() == "A" &&
                                    t5.getText().toString() == "B" &&
                                    t6.getText().toString() == "A" &&
                                    t7.getText().toString() == "S" &&
                                    t8.getText().toString() == "E" )
                    {
                        resultadoFinal = 1;
                        alertaResultado(btA);
                    }
                    break;
                }
                if (respostaAtual == "Freeware") {
                    t6.setText("A");

                    if(
                            t1.getText().toString() == "F" &&
                                    t2.getText().toString() == "R" &&
                                    t3.getText().toString() == "E" &&
                                    t4.getText().toString() == "E" &&
                                    t5.getText().toString() == "W" &&
                                    t6.getText().toString() == "A" &&
                                    t7.getText().toString() == "R" &&
                                    t8.getText().toString() == "E" )
                    {
                        resultadoFinal = 1;
                        alertaResultado(btA);
                    }
                    break;
                } else {
                    tentativa++;
                    seNaoFor();
                    break;
                }

            case R.id.btLetraB:
                btB.setBackgroundColor(Color.parseColor("#CCCCCC"));
                if(respostaAtual == "Database") {
                    t5.setText("B");
                    if (
                            t1.getText().toString() == "D" &&
                                    t2.getText().toString() == "A" &&
                                    t3.getText().toString() == "T" &&
                                    t4.getText().toString() == "A" &&
                                    t5.getText().toString() == "B" &&
                                    t6.getText().toString() == "A" &&
                                    t7.getText().toString() == "S" &&
                                    t8.getText().toString() == "E") {
                        resultadoFinal = 1;
                        alertaResultado(btA);
                    }
                    break;
                }
                if (respostaAtual == "Backup") {
                    t1.setText("B");
                    if( t1.getText().toString() == "B" &&
                            t2.getText().toString() == "A" &&
                            t3.getText().toString() == "C" &&
                            t4.getText().toString() == "K" &&
                            t5.getText().toString() == "U" &&
                            t6.getText().toString() == "P"
                    ){resultadoFinal = 1;
                        alertaResultado(btB);
                    }
                    break;
                }
                if (respostaAtual == "BIOS") {
                    t1.setText("B");
                    if(
                            t1.getText().toString() == "B" &&
                                    t2.getText().toString() == "I" &&
                                    t3.getText().toString() == "O" &&
                                    t4.getText().toString() == "S" )
                    {
                        resultadoFinal = 1;
                        alertaResultado(btB);
                    }
                    break;
                }
                if (respostaAtual == "Browser") {
                    t1.setText("B");
                    if(
                            t1.getText().toString() == "B" &&
                                    t2.getText().toString() == "R" &&
                                    t3.getText().toString() == "O" &&
                                    t4.getText().toString() == "W" &&
                                    t5.getText().toString() == "S" &&
                                    t6.getText().toString() == "E" &&
                                    t7.getText().toString() == "R")
                    {
                        resultadoFinal = 1;
                        alertaResultado(btB);
                    }


                    break;
                }
                if (respostaAtual == "Bug") {
                    t1.setText("B");
                    if(
                            t1.getText().toString() == "B" &&
                                    t2.getText().toString() == "U" &&
                                    t3.getText().toString() == "G" )
                    {
                        resultadoFinal = 1;
                        alertaResultado(btB);
                    }
                    break;
                }
                else {
                    tentativa++;
                    seNaoFor();
                    break;
                }

            case R.id.btLetraC:
                btC.setBackgroundColor(Color.parseColor("#CCCCCC"));
                if (respostaAtual == "Backup") {
                    t3.setText("C");
                    if( t1.getText().toString() == "B" &&
                            t2.getText().toString() == "A" &&
                            t3.getText().toString() == "C" &&
                            t4.getText().toString() == "K" &&
                            t5.getText().toString() == "U" &&
                            t6.getText().toString() == "P"
                    ){resultadoFinal = 1;
                        alertaResultado(btC);
                    }
                    break;
                }
                if (respostaAtual == "Copyright") {
                    t1.setText("C");
                    if(
                            t1.getText().toString() == "C" &&
                                    t2.getText().toString() == "O" &&
                                    t3.getText().toString() == "P" &&
                                    t4.getText().toString() == "Y" &&
                                    t5.getText().toString() == "R" &&
                                    t6.getText().toString() == "I" &&
                                    t7.getText().toString() == "G" &&
                                    t8.getText().toString() == "H"&&
                                    t9.getText().toString() == "T" )
                    {
                        resultadoFinal = 1;
                        alertaResultado(btC);
                    }
                    break;
                }
                if (respostaAtual == "Crack") {
                    t1.setText("C");
                    t4.setText("C");
                    if(
                            t1.getText().toString() == "C" &&
                                    t2.getText().toString() == "R" &&
                                    t3.getText().toString() == "A" &&
                                    t4.getText().toString() == "C" &&
                                    t5.getText().toString() == "K")
                    {
                        resultadoFinal = 1;
                        alertaResultado(btC);
                    }

                    break;
                } else {
                    tentativa++;
                    seNaoFor();
                    break;
                }

            case R.id.btLetraD:
                btD.setBackgroundColor(Color.parseColor("#CCCCCC"));
                if (respostaAtual == "Download") {
                    t1.setText("D");
                    t8.setText("D");
                    if(
                            t1.getText().toString() == "D" &&
                                    t2.getText().toString() == "O" &&
                                    t3.getText().toString() == "W" &&
                                    t4.getText().toString() == "N" &&
                                    t5.getText().toString() == "L" &&
                                    t6.getText().toString() == "O" &&
                                    t7.getText().toString() == "A" &&
                                    t8.getText().toString() == "D" )
                    {
                        resultadoFinal = 1;
                        alertaResultado(btD);
                    }
                    break;
                }
                if (respostaAtual == "Database") {
                    t1.setText("D");
                    if(
                            t1.getText().toString() == "D" &&
                                    t2.getText().toString() == "A" &&
                                    t3.getText().toString() == "T" &&
                                    t4.getText().toString() == "A" &&
                                    t5.getText().toString() == "B" &&
                                    t6.getText().toString() == "A" &&
                                    t7.getText().toString() == "S" &&
                                    t8.getText().toString() == "E" )
                    {
                        resultadoFinal = 1;
                        alertaResultado(btD);
                    }
                    break;
                }
                if (respostaAtual == "Keyword") {
                    t7.setText("D");
                    if(
                            t1.getText().toString() == "K" &&
                                    t2.getText().toString() == "E" &&
                                    t3.getText().toString() == "Y" &&
                                    t4.getText().toString() == "W" &&
                                    t5.getText().toString() == "O" &&
                                    t6.getText().toString() == "R" &&
                                    t7.getText().toString() == "D" )
                    {
                        resultadoFinal = 1;
                        alertaResultado(btD);
                    }

                    break;
                } else {
                    tentativa++;
                    seNaoFor();
                    break;
                }

            case R.id.btLetraE:
                btE.setBackgroundColor(Color.parseColor("#CCCCCC"));
                if (respostaAtual == "Browser") {
                    t6.setText("E");
                    if(
                            t1.getText().toString() == "B" &&
                                    t2.getText().toString() == "R" &&
                                    t3.getText().toString() == "O" &&
                                    t4.getText().toString() == "W" &&
                                    t5.getText().toString() == "S" &&
                                    t6.getText().toString() == "E" &&
                                    t7.getText().toString() == "R")
                    {
                        resultadoFinal = 1;
                        alertaResultado(btE);
                    }
                    break;
                }
                if (respostaAtual == "Database") {
                    t8.setText("E");
                    if(
                            t1.getText().toString() == "D" &&
                                    t2.getText().toString() == "A" &&
                                    t3.getText().toString() == "T" &&
                                    t4.getText().toString() == "A" &&
                                    t5.getText().toString() == "B" &&
                                    t6.getText().toString() == "A" &&
                                    t7.getText().toString() == "S" &&
                                    t8.getText().toString() == "E" )
                    {
                        resultadoFinal = 1;
                        alertaResultado(btE);
                    }
                    break;
                }
                if (respostaAtual == "Freeware") {
                    t3.setText("E");
                    t4.setText("E");
                    t8.setText("E");
                    if(
                            t1.getText().toString() == "F" &&
                                    t2.getText().toString() == "R" &&
                                    t3.getText().toString() == "E" &&
                                    t4.getText().toString() == "E" &&
                                    t5.getText().toString() == "W" &&
                                    t6.getText().toString() == "A" &&
                                    t7.getText().toString() == "R" &&
                                    t8.getText().toString() == "E" )
                    {
                        resultadoFinal = 1;
                        alertaResultado(btE);
                    }
                    break;
                }
                if (respostaAtual == "Keyword") {
                    t2.setText("E");
                    if(
                            t1.getText().toString() == "K" &&
                                    t2.getText().toString() == "E" &&
                                    t3.getText().toString() == "Y" &&
                                    t4.getText().toString() == "W" &&
                                    t5.getText().toString() == "O" &&
                                    t6.getText().toString() == "R" &&
                                    t7.getText().toString() == "D" )
                    {
                        resultadoFinal = 1;
                        alertaResultado(btE);
                    }
                    break;
                }
                if (respostaAtual == "Network") {
                    t2.setText("E");
                    if(
                            t1.getText().toString() == "N" &&
                                    t2.getText().toString() == "E" &&
                                    t3.getText().toString() == "T" &&
                                    t4.getText().toString() == "W" &&
                                    t5.getText().toString() == "O" &&
                                    t6.getText().toString() == "R" &&
                                    t7.getText().toString() == "K" )
                    {
                        resultadoFinal = 1;
                        alertaResultado(btE);
                    }

                    break;
                } else {
                    tentativa++;
                    seNaoFor();
                    break;
                }

            case R.id.btLetraF:
                btF.setBackgroundColor(Color.parseColor("#CCCCCC"));
                if (respostaAtual == "Freeware") {
                    t1.setText("F");
                    if(
                            t1.getText().toString() == "F" &&
                                    t2.getText().toString() == "R" &&
                                    t3.getText().toString() == "E" &&
                                    t4.getText().toString() == "E" &&
                                    t5.getText().toString() == "W" &&
                                    t6.getText().toString() == "A" &&
                                    t7.getText().toString() == "R" &&
                                    t8.getText().toString() == "E" )
                    {
                        resultadoFinal = 1;
                        alertaResultado(btF);
                    }
                    break;
                } else {
                    tentativa++;
                    seNaoFor();
                    break;
                }

            case R.id.btLetraG:
                btG.setBackgroundColor(Color.parseColor("#CCCCCC"));
                if (respostaAtual == "Bug") {
                    t3.setText("G");
                    if(
                            t1.getText().toString() == "B" &&
                                    t2.getText().toString() == "U" &&
                                    t3.getText().toString() == "G" )
                    {
                        resultadoFinal = 1;
                        alertaResultado(btG);
                    }
                    break;
                }
                if (respostaAtual == "Copyright") {
                    t7.setText("G");
                    if(
                            t1.getText().toString() == "C" &&
                                    t2.getText().toString() == "O" &&
                                    t3.getText().toString() == "P" &&
                                    t4.getText().toString() == "Y" &&
                                    t5.getText().toString() == "R" &&
                                    t6.getText().toString() == "I" &&
                                    t7.getText().toString() == "G" &&
                                    t8.getText().toString() == "H"&&
                                    t9.getText().toString() == "T" )
                    {
                        resultadoFinal = 1;
                        alertaResultado(btG);
                    }
                    break;
                } else {
                    tentativa++;
                    seNaoFor();
                    break;
                }

            case R.id.btLetraH:
                btH.setBackgroundColor(Color.parseColor("#CCCCCC"));
                if (respostaAtual == "Copyright") {
                    t8.setText("H");
                    if(
                            t1.getText().toString() == "C" &&
                                    t2.getText().toString() == "O" &&
                                    t3.getText().toString() == "P" &&
                                    t4.getText().toString() == "Y" &&
                                    t5.getText().toString() == "R" &&
                                    t6.getText().toString() == "I" &&
                                    t7.getText().toString() == "G" &&
                                    t8.getText().toString() == "H"&&
                                    t9.getText().toString() == "T" )
                    {
                        resultadoFinal = 1;
                        alertaResultado(btH);
                    }
                    break;
                } else {
                    tentativa++;
                    seNaoFor();
                    break;
                }

            case R.id.btLetraI:
                btI.setBackgroundColor(Color.parseColor("#CCCCCC"));
                if (respostaAtual == "BIOS") {
                    t2.setText("I");
                    if(
                            t1.getText().toString() == "B" &&
                                    t2.getText().toString() == "I" &&
                                    t3.getText().toString() == "O" &&
                                    t4.getText().toString() == "S" )
                    {
                        resultadoFinal = 1;
                        alertaResultado(btI);
                    }
                    break;
                }
                if (respostaAtual == "Copyright") {
                    t6.setText("I");
                    if(
                            t1.getText().toString() == "C" &&
                                    t2.getText().toString() == "O" &&
                                    t3.getText().toString() == "P" &&
                                    t4.getText().toString() == "Y" &&
                                    t5.getText().toString() == "R" &&
                                    t6.getText().toString() == "I" &&
                                    t7.getText().toString() == "G" &&
                                    t8.getText().toString() == "H"&&
                                    t9.getText().toString() == "T" )
                    {
                        resultadoFinal = 1;
                        alertaResultado(btI);
                    }
                    break;
                } else {
                    tentativa++;
                    seNaoFor();
                    break;
                }


            case R.id.btLetraJ:
                btJ.setBackgroundColor(Color.parseColor("#CCCCCC"));

                tentativa++;
                seNaoFor();

                break;

            case R.id.btLetraK:
                btK.setBackgroundColor(Color.parseColor("#CCCCCC"));
                if (respostaAtual == "Backup") {
                    t4.setText("K");
                    if( t1.getText().toString() == "B" &&
                            t2.getText().toString() == "A" &&
                            t3.getText().toString() == "C" &&
                            t4.getText().toString() == "K" &&
                            t5.getText().toString() == "U" &&
                            t6.getText().toString() == "P"
                    ){resultadoFinal = 1;
                        alertaResultado(btK);
                    }
                    break;
                }
                if (respostaAtual == "Crack") {
                    t5.setText("K");
                    if(
                            t1.getText().toString() == "C" &&
                                    t2.getText().toString() == "R" &&
                                    t3.getText().toString() == "A" &&
                                    t4.getText().toString() == "C" &&
                                    t5.getText().toString() == "K")
                    {
                        resultadoFinal = 1;
                        alertaResultado(btK);
                    }
                    break;
                }
                if (respostaAtual == "Keyword") {
                    t1.setText("K");
                    if(
                            t1.getText().toString() == "K" &&
                                    t2.getText().toString() == "E" &&
                                    t3.getText().toString() == "Y" &&
                                    t4.getText().toString() == "W" &&
                                    t5.getText().toString() == "O" &&
                                    t6.getText().toString() == "R" &&
                                    t7.getText().toString() == "D" )
                    {
                        resultadoFinal = 1;
                        alertaResultado(btK);
                    }
                    break;
                }
                if (respostaAtual == "Network") {
                    t7.setText("K");
                    if(
                            t1.getText().toString() == "N" &&
                                    t2.getText().toString() == "E" &&
                                    t3.getText().toString() == "T" &&
                                    t4.getText().toString() == "W" &&
                                    t5.getText().toString() == "O" &&
                                    t6.getText().toString() == "R" &&
                                    t7.getText().toString() == "K" )
                    {
                        resultadoFinal = 1;
                        alertaResultado(btK);
                    }
                    break;
                } else {
                    tentativa++;
                    seNaoFor();
                    break;
                }

            case R.id.btLetraL:
                btL.setBackgroundColor(Color.parseColor("#CCCCCC"));
                if (respostaAtual == "Download") {
                    t5.setText("L");
                    if(
                            t1.getText().toString() == "D" &&
                                    t2.getText().toString() == "O" &&
                                    t3.getText().toString() == "W" &&
                                    t4.getText().toString() == "N" &&
                                    t5.getText().toString() == "L" &&
                                    t6.getText().toString() == "O" &&
                                    t7.getText().toString() == "A" &&
                                    t8.getText().toString() == "D" )
                    {
                        resultadoFinal = 1;
                        alertaResultado(btL);
                    }
                    break;
                } else {
                    tentativa++;
                    seNaoFor();
                    break;
                }


            case R.id.btLetraM:
                btM.setBackgroundColor(Color.parseColor("#CCCCCC"));
                tentativa++;
                seNaoFor();

                break;

            case R.id.btLetraN:
                btN.setBackgroundColor(Color.parseColor("#CCCCCC"));
                if (respostaAtual == "Network") {
                    t1.setText("N");
                    if(
                            t1.getText().toString() == "N" &&
                                    t2.getText().toString() == "E" &&
                                    t3.getText().toString() == "T" &&
                                    t4.getText().toString() == "W" &&
                                    t5.getText().toString() == "O" &&
                                    t6.getText().toString() == "R" &&
                                    t7.getText().toString() == "K" )
                    {
                        resultadoFinal = 1;
                        alertaResultado(btN);
                    }
                    break;
                }

                if (respostaAtual == "Download") {
                    t4.setText("N");
                    if(
                            t1.getText().toString() == "D" &&
                                    t2.getText().toString() == "O" &&
                                    t3.getText().toString() == "W" &&
                                    t4.getText().toString() == "N" &&
                                    t5.getText().toString() == "L" &&
                                    t6.getText().toString() == "O" &&
                                    t7.getText().toString() == "A" &&
                                    t8.getText().toString() == "D" )
                    {
                        resultadoFinal = 1;
                        alertaResultado(btN);
                    }
                    break;
                } else {
                    tentativa++;
                    seNaoFor();
                    break;
                }

            case R.id.btLetraO:
                btO.setBackgroundColor(Color.parseColor("#CCCCCC"));
                if (respostaAtual == "BIOS") {
                    t3.setText("O");
                    if(
                            t1.getText().toString() == "B" &&
                                    t2.getText().toString() == "I" &&
                                    t3.getText().toString() == "O" &&
                                    t4.getText().toString() == "S" )
                    {
                        resultadoFinal = 1;
                        alertaResultado(btO);
                    }
                    break;
                }
                if (respostaAtual == "Browser") {
                    t3.setText("O");
                    if(
                            t1.getText().toString() == "B" &&
                                    t2.getText().toString() == "R" &&
                                    t3.getText().toString() == "O" &&
                                    t4.getText().toString() == "W" &&
                                    t5.getText().toString() == "S" &&
                                    t6.getText().toString() == "E" &&
                                    t7.getText().toString() == "R")
                    {
                        resultadoFinal = 1;
                        alertaResultado(btO);
                    }
                    break;
                }
                if (respostaAtual == "Copyright") {
                    t2.setText("O");
                    if(
                            t1.getText().toString() == "C" &&
                                    t2.getText().toString() == "O" &&
                                    t3.getText().toString() == "P" &&
                                    t4.getText().toString() == "Y" &&
                                    t5.getText().toString() == "R" &&
                                    t6.getText().toString() == "I" &&
                                    t7.getText().toString() == "G" &&
                                    t8.getText().toString() == "H"&&
                                    t9.getText().toString() == "T" )
                    {
                        resultadoFinal = 1;
                        alertaResultado(btO);
                    }
                    break;
                }
                if (respostaAtual == "Download") {
                    t2.setText("O");
                    t6.setText("O");
                    if(
                            t1.getText().toString() == "D" &&
                                    t2.getText().toString() == "O" &&
                                    t3.getText().toString() == "W" &&
                                    t4.getText().toString() == "N" &&
                                    t5.getText().toString() == "L" &&
                                    t6.getText().toString() == "O" &&
                                    t7.getText().toString() == "A" &&
                                    t8.getText().toString() == "D" )
                    {
                        resultadoFinal = 1;
                        alertaResultado(btO);
                    }
                    break;
                }
                if (respostaAtual == "Keyword") {
                    t5.setText("O");
                    if(
                            t1.getText().toString() == "K" &&
                                    t2.getText().toString() == "E" &&
                                    t3.getText().toString() == "Y" &&
                                    t4.getText().toString() == "W" &&
                                    t5.getText().toString() == "O" &&
                                    t6.getText().toString() == "R" &&
                                    t7.getText().toString() == "D" )
                    {
                        resultadoFinal = 1;
                        alertaResultado(btO);
                    }
                    break;
                }
                if (respostaAtual == "Network") {
                    t5.setText("O");
                    if(
                            t1.getText().toString() == "N" &&
                                    t2.getText().toString() == "E" &&
                                    t3.getText().toString() == "T" &&
                                    t4.getText().toString() == "W" &&
                                    t5.getText().toString() == "O" &&
                                    t6.getText().toString() == "R" &&
                                    t7.getText().toString() == "K" )
                    {
                        resultadoFinal = 1;
                        alertaResultado(btO);
                    }
                    break;
                } else {
                    tentativa++;
                    seNaoFor();
                    break;
                }

            case R.id.btLetraP:
                btP.setBackgroundColor(Color.parseColor("#CCCCCC"));
                if (respostaAtual == "Backup") {
                    t6.setText("P");
                    if( t1.getText().toString() == "B" &&
                            t2.getText().toString() == "A" &&
                            t3.getText().toString() == "C" &&
                            t4.getText().toString() == "K" &&
                            t5.getText().toString() == "U" &&
                            t6.getText().toString() == "P"
                    ){resultadoFinal = 1;
                        alertaResultado(btP);
                    }
                    break;
                }
                if (respostaAtual == "Copyright") {
                    t3.setText("P");
                    if(
                            t1.getText().toString() == "C" &&
                                    t2.getText().toString() == "O" &&
                                    t3.getText().toString() == "P" &&
                                    t4.getText().toString() == "Y" &&
                                    t5.getText().toString() == "R" &&
                                    t6.getText().toString() == "I" &&
                                    t7.getText().toString() == "G" &&
                                    t8.getText().toString() == "H"&&
                                    t9.getText().toString() == "T" )
                    {
                        resultadoFinal = 1;
                        alertaResultado(btP);
                    }
                    break;
                } else {
                    tentativa++;
                    seNaoFor();
                    break;
                }

            case R.id.btLetraQ:
                btQ.setBackgroundColor(Color.parseColor("#CCCCCC"));
                tentativa++;
                seNaoFor();
                break;

            case R.id.btLetraR:
                btR.setBackgroundColor(Color.parseColor("#CCCCCC"));
                if (respostaAtual == "Keyword") {
                    t6.setText("R");
                    if(
                            t1.getText().toString() == "K" &&
                                    t2.getText().toString() == "E" &&
                                    t3.getText().toString() == "Y" &&
                                    t4.getText().toString() == "W" &&
                                    t5.getText().toString() == "O" &&
                                    t6.getText().toString() == "R" &&
                                    t7.getText().toString() == "D" )
                    {
                        resultadoFinal = 1;
                        alertaResultado(btR);
                    }
                    break;
                }

                if (respostaAtual == "Network") {
                    t6.setText("R");
                    if(
                            t1.getText().toString() == "N" &&
                                    t2.getText().toString() == "E" &&
                                    t3.getText().toString() == "T" &&
                                    t4.getText().toString() == "W" &&
                                    t5.getText().toString() == "O" &&
                                    t6.getText().toString() == "R" &&
                                    t7.getText().toString() == "K" )
                    {
                        resultadoFinal = 1;
                        alertaResultado(btR);
                    }
                    break;
                }
                if (respostaAtual == "Browser") {
                    t2.setText("R");
                    t7.setText("R");
                    if(
                            t1.getText().toString() == "B" &&
                                    t2.getText().toString() == "R" &&
                                    t3.getText().toString() == "O" &&
                                    t4.getText().toString() == "W" &&
                                    t5.getText().toString() == "S" &&
                                    t6.getText().toString() == "E" &&
                                    t7.getText().toString() == "R")
                    {
                        resultadoFinal = 1;
                        alertaResultado(btR);
                    }
                    break;
                }
                if (respostaAtual == "Copyright") {
                    t5.setText("R");
                    if(
                            t1.getText().toString() == "C" &&
                                    t2.getText().toString() == "O" &&
                                    t3.getText().toString() == "P" &&
                                    t4.getText().toString() == "Y" &&
                                    t5.getText().toString() == "R" &&
                                    t6.getText().toString() == "I" &&
                                    t7.getText().toString() == "G" &&
                                    t8.getText().toString() == "H"&&
                                    t9.getText().toString() == "T" )
                    {
                        resultadoFinal = 1;
                        alertaResultado(btR);
                    }
                    break;
                }
                if (respostaAtual == "Crack") {
                    t2.setText("R");
                    if(
                            t1.getText().toString() == "C" &&
                                    t2.getText().toString() == "R" &&
                                    t3.getText().toString() == "A" &&
                                    t4.getText().toString() == "C" &&
                                    t5.getText().toString() == "K")
                    {
                        resultadoFinal = 1;
                        alertaResultado(btR);
                    }
                    break;
                }
                if (respostaAtual == "Freeware") {
                    t2.setText("R");
                    t7.setText("R");
                    if(
                            t1.getText().toString() == "F" &&
                                    t2.getText().toString() == "R" &&
                                    t3.getText().toString() == "E" &&
                                    t4.getText().toString() == "E" &&
                                    t5.getText().toString() == "W" &&
                                    t6.getText().toString() == "A" &&
                                    t7.getText().toString() == "R" &&
                                    t8.getText().toString() == "E" )
                    {
                        resultadoFinal = 1;
                        alertaResultado(btR);
                    }
                    break;
                } else {
                    tentativa++;
                    seNaoFor();
                    break;
                }


            case R.id.btLetraS:
                btS.setBackgroundColor(Color.parseColor("#CCCCCC"));

                if (respostaAtual == "BIOS") {
                    t4.setText("S");
                    if(
                            t1.getText().toString() == "B" &&
                                    t2.getText().toString() == "I" &&
                                    t3.getText().toString() == "O" &&
                                    t4.getText().toString() == "S" )
                    {
                        resultadoFinal = 1;
                        alertaResultado(btS);
                    }
                    break;
                }
                if (respostaAtual == "Browser") {
                    t5.setText("S");
                    if(
                            t1.getText().toString() == "B" &&
                                    t2.getText().toString() == "R" &&
                                    t3.getText().toString() == "O" &&
                                    t4.getText().toString() == "W" &&
                                    t5.getText().toString() == "S" &&
                                    t6.getText().toString() == "E" &&
                                    t7.getText().toString() == "R")
                    {
                        resultadoFinal = 1;
                        alertaResultado(btS);
                    }

                    break;
                }
                if (respostaAtual == "Database") {
                    t7.setText("S");
                    if(
                            t1.getText().toString() == "D" &&
                                    t2.getText().toString() == "A" &&
                                    t3.getText().toString() == "T" &&
                                    t4.getText().toString() == "A" &&
                                    t5.getText().toString() == "B" &&
                                    t6.getText().toString() == "A" &&
                                    t7.getText().toString() == "S" &&
                                    t8.getText().toString() == "E" )
                    {
                        resultadoFinal = 1;
                        alertaResultado(btS);
                    }
                    break;
                } else {
                    tentativa++;
                    seNaoFor();
                    break;
                }

            case R.id.btLetraT:
                btT.setBackgroundColor(Color.parseColor("#CCCCCC"));

                if (respostaAtual == "Copyright") {
                    t9.setText("T");
                    if(
                            t1.getText().toString() == "C" &&
                                    t2.getText().toString() == "O" &&
                                    t3.getText().toString() == "P" &&
                                    t4.getText().toString() == "Y" &&
                                    t5.getText().toString() == "R" &&
                                    t6.getText().toString() == "I" &&
                                    t7.getText().toString() == "G" &&
                                    t8.getText().toString() == "H"&&
                                    t9.getText().toString() == "T" )
                    {
                        resultadoFinal = 1;
                        alertaResultado(btT);
                    }
                    break;
                }
                if (respostaAtual == "Database") {
                    t3.setText("T");
                    if(
                            t1.getText().toString() == "D" &&
                                    t2.getText().toString() == "A" &&
                                    t3.getText().toString() == "T" &&
                                    t4.getText().toString() == "A" &&
                                    t5.getText().toString() == "B" &&
                                    t6.getText().toString() == "A" &&
                                    t7.getText().toString() == "S" &&
                                    t8.getText().toString() == "E" )
                    {
                        resultadoFinal = 1;
                        alertaResultado(btT);
                    }
                    break;
                }
                if (respostaAtual == "Network") {
                    t3.setText("T");
                    if(
                            t1.getText().toString() == "N" &&
                                    t2.getText().toString() == "E" &&
                                    t3.getText().toString() == "T" &&
                                    t4.getText().toString() == "W" &&
                                    t5.getText().toString() == "O" &&
                                    t6.getText().toString() == "R" &&
                                    t7.getText().toString() == "K" )
                    {
                        resultadoFinal = 1;
                        alertaResultado(btT);
                    }
                    break;
                } else {
                    tentativa++;
                    seNaoFor();
                    break;
                }


            case R.id.btLetraU:
                btU.setBackgroundColor(Color.parseColor("#CCCCCC"));

                if (respostaAtual == "Backup") {
                    t5.setText("U");
                    if( t1.getText().toString() == "B" &&
                            t2.getText().toString() == "A" &&
                            t3.getText().toString() == "C" &&
                            t4.getText().toString() == "K" &&
                            t5.getText().toString() == "U" &&
                            t6.getText().toString() == "P"
                    ){resultadoFinal = 1;
                        alertaResultado(btU);
                    }
                    break;
                }
                if (respostaAtual == "Bug") {
                    t2.setText("U");
                    if(
                            t1.getText().toString() == "B" &&
                                    t2.getText().toString() == "U" &&
                                    t3.getText().toString() == "G" )
                    {
                        resultadoFinal = 1;
                        alertaResultado(btU);
                    }
                    break;
                } else {
                    tentativa++;
                    seNaoFor();
                    break;
                }

            case R.id.btLetraV:
                btV.setBackgroundColor(Color.parseColor("#CCCCCC"));
                tentativa++;
                seNaoFor();

                break;

            case R.id.btLetraX:
                btX.setBackgroundColor(Color.parseColor("#CCCCCC"));
                tentativa++;
                seNaoFor();
                break;

            case R.id.btLetraY:
                btY.setBackgroundColor(Color.parseColor("#CCCCCC"));

                if (respostaAtual == "Copyright") {
                    t4.setText("Y");
                    if(
                            t1.getText().toString() == "C" &&
                                    t2.getText().toString() == "O" &&
                                    t3.getText().toString() == "P" &&
                                    t4.getText().toString() == "Y" &&
                                    t5.getText().toString() == "R" &&
                                    t6.getText().toString() == "I" &&
                                    t7.getText().toString() == "G" &&
                                    t8.getText().toString() == "H"&&
                                    t9.getText().toString() == "T" )
                    {
                        resultadoFinal = 1;
                        alertaResultado(btY);
                    }
                    break;
                }
                if (respostaAtual == "Keyword") {
                    t3.setText("Y");
                    if(
                            t1.getText().toString() == "K" &&
                                    t2.getText().toString() == "E" &&
                                    t3.getText().toString() == "Y" &&
                                    t4.getText().toString() == "W" &&
                                    t5.getText().toString() == "O" &&
                                    t6.getText().toString() == "R" &&
                                    t7.getText().toString() == "D" )
                    {
                        resultadoFinal = 1;
                        alertaResultado(btY);
                    }
                    break;
                } else {
                    tentativa++;
                    seNaoFor();
                    break;
                }


            case R.id.btLetraZ:
                btZ.setBackgroundColor(Color.parseColor("#CCCCCC"));
                tentativa++;
                seNaoFor();
                break;

            case R.id.btLetraW:
                btW.setBackgroundColor(Color.parseColor("#CCCCCC"));

                if (respostaAtual == "Network") {
                    t4.setText("W");
                    if(
                            t1.getText().toString() == "N" &&
                                    t2.getText().toString() == "E" &&
                                    t3.getText().toString() == "T" &&
                                    t4.getText().toString() == "W" &&
                                    t5.getText().toString() == "O" &&
                                    t6.getText().toString() == "R" &&
                                    t7.getText().toString() == "K" )
                    {
                        resultadoFinal = 1;
                        alertaResultado(btW);
                    }

                    break;
                }

                if (respostaAtual == "Keyword") {
                    t4.setText("W");
                    if(
                            t1.getText().toString() == "K" &&
                                    t2.getText().toString() == "E" &&
                                    t3.getText().toString() == "Y" &&
                                    t4.getText().toString() == "W" &&
                                    t5.getText().toString() == "O" &&
                                    t6.getText().toString() == "R" &&
                                    t7.getText().toString() == "D" )
                    {
                        resultadoFinal = 1;
                        alertaResultado(btW);
                    }
                    break;
                }

                if (respostaAtual == "Freeware") {
                    t5.setText("W");
                    if(
                            t1.getText().toString() == "F" &&
                                    t2.getText().toString() == "R" &&
                                    t3.getText().toString() == "E" &&
                                    t4.getText().toString() == "E" &&
                                    t5.getText().toString() == "W" &&
                                    t6.getText().toString() == "A" &&
                                    t7.getText().toString() == "R" &&
                                    t8.getText().toString() == "E" )
                    {
                        resultadoFinal = 1;
                        alertaResultado(btW);
                    }
                    break;
                }
                if (respostaAtual == "Download") {
                    t3.setText("W");
                    if(
                            t1.getText().toString() == "D" &&
                                    t2.getText().toString() == "O" &&
                                    t3.getText().toString() == "W" &&
                                    t4.getText().toString() == "N" &&
                                    t5.getText().toString() == "L" &&
                                    t6.getText().toString() == "O" &&
                                    t7.getText().toString() == "A" &&
                                    t8.getText().toString() == "D" )
                    {
                        resultadoFinal = 1;
                        alertaResultado(btW);
                    }
                    break;
                }

                if (respostaAtual == "Browser") {
                    t4.setText("W");
                    if(
                            t1.getText().toString() == "B" &&
                                    t2.getText().toString() == "R" &&
                                    t3.getText().toString() == "O" &&
                                    t4.getText().toString() == "W" &&
                                    t5.getText().toString() == "S" &&
                                    t6.getText().toString() == "E" &&
                                    t7.getText().toString() == "R")
                    {
                        resultadoFinal = 1;
                        alertaResultado(btW);
                    }

                    break;
                }

                if (respostaAtual == "Keyword") {
                    t4.setText("W");

                    if(
                            t1.getText().toString() == "K" &&
                                    t2.getText().toString() == "E" &&
                                    t3.getText().toString() == "Y" &&
                                    t4.getText().toString() == "W" &&
                                    t5.getText().toString() == "O" &&
                                    t6.getText().toString() == "R" &&
                                    t7.getText().toString() == "D" )
                    {
                        resultadoFinal = 1;
                        alertaResultado(btW);
                    }
                    break;
                }
                else {
                    tentativa++;
                    seNaoFor();
                    break;
                }

        }

    }

    public void seNaoFor() {


        switch (tentativa) {
            case 1:
                forca.setImageResource(R.drawable.forca2);
                break;
            case 2:

                forca.setImageResource(R.drawable.forca3);
                break;
            case 3:

                forca.setImageResource(R.drawable.forca4);
                break;
            case 4:

                forca.setImageResource(R.drawable.forca5);
                break;
            case 5:

                forca.setImageResource(R.drawable.forca6);
                break;
            case 6:

                forca.setImageResource(R.drawable.forca7);
                resultadoFinal = 0;
                alertaResultado(btA);
                alertaResultado(btB);
                alertaResultado(btC);
                alertaResultado(btD);
                alertaResultado(btE);
                alertaResultado(btF);
                alertaResultado(btG);
                alertaResultado(btH);
                alertaResultado(btI);
                alertaResultado(btJ);
                alertaResultado(btK);
                alertaResultado(btL);
                alertaResultado(btM);
                alertaResultado(btN);
                alertaResultado(btO);
                alertaResultado(btP);
                alertaResultado(btQ);
                alertaResultado(btR);
                alertaResultado(btS);
                alertaResultado(btT);
                alertaResultado(btU);
                alertaResultado(btV);
                alertaResultado(btX);
                alertaResultado(btY);
                alertaResultado(btZ);
                alertaResultado(btW);
                break;
        }
    }
    public void alertaResultado(View view) {

        AlertDialog alertDialog;
        alertDialog = new AlertDialog.Builder(this).create();
        alertDialog.setCancelable(false);
        alertDialog.setTitle(getString(R.string.msg_result));

        if(resultadoFinal == 0) {
            if(vidas == 0){
                alertDialog.setMessage(getString(R.string.msgGamerOL) +vidas);
                alertDialog.setButton(getString(R.string.msgTryAgain), new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                        intent.putExtra("vidas", vidasCasoRetry);
                        startActivity(intent);
                        finish();
                    }
                });
            }else {
                alertDialog.setMessage(getString(R.string.msgYouDie));
                alertDialog.setButton(getString(R.string.msgTryAgain), new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        vidas--;
                        Intent intent = new Intent(getApplicationContext(), Atividade8.class);
                        intent.putExtra("voltar", btvoltarclidado);
                        intent.putExtra("vidas", vidasCasoRetry - 1);
                        intent.putExtra("totalPontos", totalPontos);
                        startActivity(intent);
                        finish();
                    }
                });
            }
        }if(resultadoFinal == 1){
            alertDialog.setMessage(getString(R.string.msgParabens));
            alertDialog.setButton(getString(R.string.msgNext), new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    Intent intent = new Intent(getApplicationContext(), MapaAtividadesGeral.class);
                    totalPontos = totalPontos + 5;
                    intent.putExtra("totalPontos", totalPontos);
                    intent.putExtra("vidas", vidas);
                    intent.putExtra("mapa", mapa);
                    intent.putExtra("voltar", btvoltarclidado);
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

        alertDialog.show();
    }
}
