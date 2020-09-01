package com.stenio.gamificacao;

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

public class MapaAtividades3 extends AppCompatActivity {


    Button btProsseguir3;
    int totalPontos;
    TextView totalaa;
    ImageView star,totalVidas;
    int total = 0;
    int vidas = 0;
    int vidasCasoRetry;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mapa_atividades3);

        star = findViewById(R.id.imgStar);
        totalaa = findViewById(R.id.txtTotalPontos3);
        totalVidas = findViewById(R.id.imgQtdVidas);

        Intent intentReceive = getIntent();
        Bundle param = intentReceive.getExtras();
        if (param != null) {
            total = param.getInt("totalPontos");
            vidas = param.getInt("vidas");
            vidasCasoRetry = vidas;
            if(vidas == 1){
                totalVidas.setImageResource(R.drawable.uma);
            }if(vidas == 2){
                totalVidas.setImageResource(R.drawable.duasvidas);
            }if(vidas == 3){
                totalVidas.setImageResource(R.drawable.tresvidas);
            }if(vidas == 4){
                totalVidas.setImageResource(R.drawable.quatro);
            }else{

            }

            totalPontos = total;
            totalaa.setText(String.valueOf(total));
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

        btProsseguir3 = findViewById(R.id.btProsseguir3);

        btProsseguir3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Atividade3.class);
                intent.putExtra("totalPontos", totalPontos);
                intent.putExtra("vidas", vidas);
                startActivity(intent);
            }
        });
    }
}
