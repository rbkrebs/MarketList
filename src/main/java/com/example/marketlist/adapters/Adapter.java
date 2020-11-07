package com.example.marketlist.adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.marketlist.FireBase;
import com.example.marketlist.R;
import com.example.marketlist.activities.AlteraItemCompra;
import com.example.marketlist.model.ListaProvisoria;

import java.util.ArrayList;
import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {

    List<ListaProvisoria> listaItens = new ArrayList();
    private Context context;
    public Adapter(List<ListaProvisoria> itens, Context context){
        this.listaItens = itens;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View itemList = LayoutInflater.from(parent.getContext()).
                inflate(R.layout.adapter_card, parent, false);

        return new ViewHolder(itemList);
    }

    @Override
    public void onBindViewHolder(@NonNull Adapter.ViewHolder viewHolder, @SuppressLint("RecyclerView") final int position) {

        ListaProvisoria listaProvisoria = listaItens.get(position);
        //FireBase.inicializarFireBase(this.context);
        

        viewHolder.nomeProduto.setText(listaProvisoria.getNomeProduto());
        viewHolder.quantidade.setText(String.valueOf(listaProvisoria.getQuantidade()));
        viewHolder.observacao.setText(listaProvisoria.getObservacoes());

        viewHolder.btnDeletar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                removerItem(position);
            }
        });

        viewHolder.btnAlterar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, AlteraItemCompra.class);

                intent.putExtra("itemText", listaItens.get(position).getNomeProduto());
                intent.putExtra("editObservacao", listaItens.get(position).getObservacoes());
                intent.putExtra("spinnerQuantidadeItem", listaItens.get(position).getQuantidade());
                //tive que implementar essa flag para contornar um erro!
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);
            }
        });


    }

    private void removerItem(int position){

        listaItens.remove(position);
        notifyItemRemoved(position);
        notifyItemRangeChanged(position, listaItens.size());
    }

    @Override
    public int getItemCount() {

        return listaItens != null? listaItens.size() : 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView nomeProduto;
        TextView quantidade;
        TextView observacao;
        ImageButton btnDeletar;
        ImageButton btnAlterar;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            nomeProduto = itemView.findViewById(R.id.nome_produto);
            quantidade = itemView.findViewById(R.id.quantidade);
            observacao = itemView.findViewById(R.id.observacao);
            btnDeletar = itemView.findViewById(R.id.btn_delete);
            btnAlterar = itemView.findViewById(R.id.btn_altera);
        }
    }
}

