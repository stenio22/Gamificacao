package com.stenio.gamificacao;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.Map;

public class MainActivity extends AppCompatActivity {
    Button botaoSim,botaoNao;
    int mapa = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        botaoSim = findViewById(R.id.btYes);



        botaoSim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MapaAtividades.class);
                intent.putExtra("mapa", mapa);
                //intent.putExtra("voltar", 1);
                //intent.putExtra("totalPontos", 53);
                startActivity(intent);

            }
        });






    }
}
