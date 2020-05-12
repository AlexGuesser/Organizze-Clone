package com.example.organizze.adapter;

import android.content.Context;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.organizze.R;
import com.example.organizze.model.Movimentacao;

import java.text.DecimalFormat;
import java.util.List;

/**
 * Created by Jamilton Damasceno
 */

public class AdapterMovimentacao extends RecyclerView.Adapter<AdapterMovimentacao.MyViewHolder> {

    List<Movimentacao> movimentacoes;
    Context context;

    public AdapterMovimentacao(List<Movimentacao> movimentacoes, Context context) {
        this.movimentacoes = movimentacoes;
        this.context = context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemLista = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_movimentacao, parent, false);
        return new MyViewHolder(itemLista);
    }


    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Movimentacao movimentacao = movimentacoes.get(position);

        DecimalFormat decimalFormat = new DecimalFormat("0.00");
        String valorFormatado = String.valueOf(decimalFormat.format(movimentacao.getValor()));
        holder.titulo.setText(movimentacao.getDescricao());
        holder.valor.setText("R$ " + valorFormatado);
        holder.categoria.setText(movimentacao.getCategoria());
        holder.valor.setTextColor(context.getResources().getColor(R.color.colorAccentReceita));

        if (movimentacao.getTipo() == "D" || movimentacao.getTipo().equals("D")) {
            holder.valor.setTextColor(context.getResources().getColor(R.color.colorAccentDespesa));
            holder.valor.setText("-" + "R$ "+ valorFormatado);
        }
    }


    @Override
    public int getItemCount() {
        return movimentacoes.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView titulo, valor, categoria;

        public MyViewHolder(View itemView) {
            super(itemView);

            titulo = itemView.findViewById(R.id.textAdapterTitulo);
            valor = itemView.findViewById(R.id.textAdapterValor);
            categoria = itemView.findViewById(R.id.textAdapterCategoria);
        }

    }

}
