package com.example.marketlist;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.marketlist.model.ListaProvisoria;

import java.util.ArrayList;
import java.util.List;

public class BasicAdapter extends RecyclerView.Adapter<BasicAdapter.ViewHolder>  {

    List<ListaProvisoria> listaItens = new ArrayList();

    public BasicAdapter(List<ListaProvisoria> itens){
        this.listaItens = itens;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View itemList = LayoutInflater.from(parent.getContext()).
                inflate(R.layout.adapter_card_basic, parent, false);

        return new BasicAdapter.ViewHolder(itemList);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {

        ListaProvisoria listaProvisoria = listaItens.get(position);
        viewHolder.nomeProduto.setText(listaProvisoria.getNomeProduto());
        viewHolder.quantidade.setText(String.valueOf(listaProvisoria.getQuantidade()));
        viewHolder.observacao.setText(listaProvisoria.getObservacoes());
    }

    @Override
    public int getItemCount() {

        return listaItens != null? listaItens.size() : 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView nomeProduto;
        TextView quantidade;
        TextView observacao;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            nomeProduto = itemView.findViewById(R.id.nome_produto);
            quantidade = itemView.findViewById(R.id.quantidade);
            observacao = itemView.findViewById(R.id.observacao);
        }
    }
}
