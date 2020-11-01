package com.example.marketlist;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.marketlist.model.ListaProvisoria;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {

    List<ListaProvisoria> listaItens = new ArrayList();

    public Adapter(List<ListaProvisoria> itens){
        this.listaItens = itens;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View itemList = LayoutInflater.from(parent.getContext()).
                inflate(R.layout.adapter_card, parent, false);

        return new ViewHolder(itemList);
    }

    @Override
    public void onBindViewHolder(@NonNull Adapter.ViewHolder viewHolder, int position) {

        ListaProvisoria listaProvisoria = listaItens.get(position);
        viewHolder.nomeProduto.setText(listaProvisoria.getNomeProduto());
        viewHolder.quantidade.setText(listaProvisoria.getQuantidade());
        viewHolder.observacao.setText(listaProvisoria.getObservacoes());


    }

    @Override
    public int getItemCount() {

        return listaItens.size();
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

