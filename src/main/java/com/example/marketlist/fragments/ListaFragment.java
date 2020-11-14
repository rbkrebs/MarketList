package com.example.marketlist.fragments;


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
import com.example.marketlist.model.ListaProvisoria;



public class ListaFragment extends Fragment {

    RecyclerView listaMercado;
    Button adicionaItem;

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View layout = inflater.inflate(R.layout.fragment_lista, container, false);
        listaMercado = layout.findViewById(R.id.lista_mercado);

        Adapter adapter = new Adapter(ListaProvisoria.criaLista(), getContext());
        listaMercado.setAdapter(adapter);
        listaMercado.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
        listaMercado.setLayoutManager(layoutManager);
        Log.d("FragmentLista", "Yeah baby");

        adicionaItem = layout.findViewById(R.id.adiciona_item);
        adicionaItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("FragmentLista", "adiciona");
                Intent intent = new Intent(getContext(), ListaSugerida.class);
                startActivity(intent);

            }
        });

        return layout;

    }



}