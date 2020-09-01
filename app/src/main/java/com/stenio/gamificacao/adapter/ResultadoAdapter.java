package com.stenio.gamificacao.adapter;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.stenio.gamificacao.R;
import com.stenio.gamificacao.model.Resultado;

import java.util.List;

public class ResultadoAdapter extends RecyclerView.Adapter<ResultadoAdapter.MyViewHolder> {

    private List<Resultado> listaTarefas;

    public ResultadoAdapter(List<Resultado> lista ) {
        this.listaTarefas = lista;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View itemLista = LayoutInflater.from(parent.getContext())
                                        .inflate(R.layout.lista, parent, false);

        return new MyViewHolder(itemLista);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        Resultado tarefa = listaTarefas.get(position);

        holder.tarefa.setText( tarefa.getNome() );
        holder.total.setText(tarefa.getTotal());

    }

    @Override
    public int getItemCount() {
        return this.listaTarefas.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView tarefa,total;

        public MyViewHolder(View itemView) {
            super(itemView);

            tarefa = itemView.findViewById(R.id.idNome);
            total = itemView.findViewById(R.id.idTotal);

        }
    }

}
