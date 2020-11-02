package com.example.marketlist.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.marketlist.adapters.Adapter;
import com.example.marketlist.R;
import com.example.marketlist.model.ListaProvisoria;

public class ListaMercado extends AppCompatActivity{

    private RecyclerView listaMercado;
    private Button adicionaItem;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_mercado);

        listaMercado = findViewById(R.id.lista_mercado);


        Adapter adapter = new Adapter(ListaProvisoria.criaLista(), getApplicationContext());
        listaMercado.setAdapter(adapter);
        listaMercado.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        listaMercado.setLayoutManager(layoutManager);


        adicionaItem = findViewById(R.id.adiciona_item);
        adicionaItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent( ListaMercado.this, ListaSugerida.class);
                startActivity(intent);

            }
        });


    }


}