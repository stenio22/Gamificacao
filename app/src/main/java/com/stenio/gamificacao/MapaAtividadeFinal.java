package com.stenio.gamificacao;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class MapaAtividadeFinal extends AppCompatActivity {

    ImageView imgFinal;
    int totalPontos;
    TextView txtFinal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mapa_atividade_final);

        txtFinal = findViewById(R.id.txtFinal);
        imgFinal = findViewById(R.id.imgFinal);

        Intent intentReceive = getIntent();
        Bundle param = intentReceive.getExtras();
        if (param != null) {
            int total = param.getInt("totalPontos");
            totalPontos = total;
        }




        if(totalPontos >= 20){
            imgFinal.setImageResource(R.drawable.ouro);


            txtFinal.setText("Congratulations, you're done!"+totalPontos +"PONTOS");


        }else if(totalPontos <= 19 && totalPontos >= 16){

            txtFinal.setText("Congratulations, you're done!" +totalPontos +"PONTOS");
            imgFinal.setImageResource(R.drawable.silver);

        }else if(totalPontos <= 15 && totalPontos >= 10 ){

            txtFinal.setText("Congratulations, you're done! "+totalPontos +"PONTOS");
            imgFinal.setImageResource(R.drawable.bronze);

        }else{
            imgFinal.setImageResource(R.drawable.x);
            txtFinal.setText("Sorry you did not reach the minimum grade! "+totalPontos +"PONTOS");

        }


    }
}
