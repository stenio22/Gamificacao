package com.stenio.gamificacao;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MapaAtividades extends AppCompatActivity {

    Button btProsseguir,btEasy,btMedium,btHard,btFaq;
    int nivel;
    ImageView totalVidas;
    int btvoltarclidado = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mapa_atividades);
        btProsseguir = findViewById(R.id.btProsseguir);
        btEasy = findViewById(R.id.btEasy);
        btMedium = findViewById(R.id.btMedium);
        btHard = findViewById(R.id.btHard);
        totalVidas = findViewById(R.id.imgQtdVidas);
        btFaq = findViewById(R.id.btFaq);

        btEasy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nivel = 6;
                totalVidas.setImageResource(R.drawable.seiscoracoes);
                btEasy.setVisibility(View.GONE);
                btHard.setVisibility(View.GONE);
                btMedium.setVisibility(View.GONE);
                btProsseguir.setVisibility(View.VISIBLE);
            }
        });
        btMedium.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nivel = 4;
                totalVidas.setImageResource(R.drawable.quatro);
                btEasy.setVisibility(View.GONE);
                btHard.setVisibility(View.GONE);
                btMedium.setVisibility(View.GONE);
                btProsseguir.setVisibility(View.VISIBLE);
            }
        });
        btHard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nivel = 2;
                totalVidas.setImageResource(R.drawable.duasvidas);
                btEasy.setVisibility(View.GONE);
                btHard.setVisibility(View.GONE);
                btMedium.setVisibility(View.GONE);
                btProsseguir.setVisibility(View.VISIBLE);
            }
        });

        btProsseguir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Atividade1.class);
                intent.putExtra("vidas", nivel);
                startActivity(intent);
                finish();

            }
        });

        btFaq.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Faq.class);
                startActivity(intent);

            }
        });
    }

}
