package com.example.marketlist.fragments;


import android.app.Activity;
import android.app.ListFragment;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.marketlist.R;
import com.example.marketlist.activities.ListaSugerida;
import com.example.marketlist.adapters.Adapter;
import com.example.marketlist.model.ItemComprado;
import com.example.marketlist.model.ListaProvisoria;
import com.example.marketlist.util.ConfiguraFirebase;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;


public class ListaFragment extends Fragment  {

    RecyclerView listaMercado;
    List<ItemComprado> listaProdutos;
    Context context;
    Button adicionaItem;

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View layout = inflater.inflate(R.layout.fragment_lista, container, false);
        listaMercado = layout.findViewById(R.id.lista_mercado);




        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
        listaMercado.setLayoutManager(layoutManager);

        final DatabaseReference reference = ConfiguraFirebase.getNo("produtos");
        listaProdutos = new ArrayList<>();

        reference.addValueEventListener(new ValueEventListener() {
            @Override

            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for(DataSnapshot ds : dataSnapshot.getChildren()) {

                    ItemComprado itemComprado = ds.getValue(ItemComprado.class);
                    itemComprado.setId(ds.getKey());
                    listaProdutos.add(itemComprado);
                    Log.d("produto", itemComprado.toString());
                }
                final Adapter adapter = new Adapter(listaProdutos, getContext());
                listaMercado.setAdapter(adapter);
                listaMercado.setHasFixedSize(true);
                reference.removeEventListener(this);
            }
            @Override
            //chamado quando a requisição é cancelada
            public void onCancelled(@NonNull DatabaseError databaseError) {
            }
        });

/*
        adicionaItem = layout.findViewById(R.id.adiciona_item);
        adicionaItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getContext(), ListaSugerida.class);
                startActivity(intent);

            }
        });
*/
        return layout;

    }



}