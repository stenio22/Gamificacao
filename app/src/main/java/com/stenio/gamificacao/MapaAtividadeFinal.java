package com.stenio.gamificacao;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.ContentValues;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.stenio.gamificacao.adapter.ResultadoAdapter;
import com.stenio.gamificacao.model.DBHelper;
import com.stenio.gamificacao.model.Resultado;
import com.stenio.gamificacao.model.ResultadoDAO;

import java.util.ArrayList;
import java.util.List;

public class MapaAtividadeFinal extends AppCompatActivity {

    ImageView imgFinal;
    int totalPontos;
    int btvoltarclidado = 0;
    TextView txtFinal;
    Button btvoltar;
    RecyclerView recyclerView;
    private List <Resultado> listaResultados = new ArrayList <>();
    private ResultadoAdapter resultadoAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mapa_atividade_final);
        recyclerView = findViewById(R.id.recyclerView);


        txtFinal = findViewById(R.id.txtFinal);
        imgFinal = findViewById(R.id.imgFinal);
        btvoltar = findViewById(R.id.btVoltar);
        Intent intentReceive = getIntent();
        Bundle param = intentReceive.getExtras();
        if (param != null) {
            int total = param.getInt("totalPontos");
            int voltar = param.getInt("voltar");
            totalPontos = total;

            for(int i = 0; i < voltar;i++){
                totalPontos = totalPontos / 2;
            }
            //configurar
            if(totalPontos > 0){
                showAddItemDialog(MapaAtividadeFinal.this);
            }
        }

            imgFinal.setImageResource(R.drawable.robo3);
            txtFinal.setText("Score " + totalPontos + "PONTOS");
    }

    public void carregarLista(){


       ResultadoDAO resultadoDAO = new ResultadoDAO(getApplicationContext());
       listaResultados = resultadoDAO.listar();


        resultadoAdapter = new ResultadoAdapter(listaResultados);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.addItemDecoration(new DividerItemDecoration(getApplicationContext(), LinearLayout.VERTICAL));
        recyclerView.setAdapter(resultadoAdapter);
    }

    @Override
    protected void onStart() {
        carregarLista();
        super.onStart();
    }

    private void showAddItemDialog(Context c) {
        final EditText taskEditText = new EditText(c);
        AlertDialog dialog = new AlertDialog.Builder(c)
                .setTitle(R.string.insira_nome)
                .setView(taskEditText)
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String task = String.valueOf(taskEditText.getText());
                        ResultadoDAO resultadoDAO = new ResultadoDAO(getApplicationContext());
                        Resultado resultado = new Resultado();
                        resultado.setNome(task);
                        resultado.setTotal(totalPontos+"");
                        resultadoDAO.salvar(resultado);
                        resultadoDAO.listar();
                        carregarLista();
                    }
                })
                .setNegativeButton("Cancel", null)
                .create();
        dialog.show();
    }


    public void voltar(View view) {
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
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
