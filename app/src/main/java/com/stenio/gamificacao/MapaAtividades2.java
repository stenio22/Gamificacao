package com.stenio.gamificacao;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MapaAtividades2 extends AppCompatActivity {


    Button btProsseguir2;
    int totalPontos;
    TextView totalaa;
    ImageView star,totalVidas;
    int vidas = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mapa_atividades2);
        btProsseguir2 = findViewById(R.id.btProsseguir2);
        star = findViewById(R.id.imgStar);
        totalVidas = findViewById(R.id.imgQtdVidas);
        totalaa = findViewById(R.id.txtTotalPontos2);
        Intent intentReceive = getIntent();
        Bundle param = intentReceive.getExtras();
        if (param != null) {
            int total = param.getInt("totalPontos");
            vidas = param.getInt("vidas");
            if(vidas == 1){
                totalVidas.setImageResource(R.drawable.uma);
            }if(vidas == 2){
                totalVidas.setImageResource(R.drawable.duasvidas);
            }if(vidas == 3){
                totalVidas.setImageResource(R.drawable.tresvidas);
            }if(vidas == 4){
                totalVidas.setImageResource(R.drawable.quatro);
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



        btProsseguir2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Atividade2.class);
                intent.putExtra("totalPontos", totalPontos);

                intent.putExtra("vidas", vidas);
                startActivity(intent);
            }
        });

    }
}
