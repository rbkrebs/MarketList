package com.example.marketlist.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;

import com.example.marketlist.adapters.BasicAdapter;
import com.example.marketlist.R;
import com.example.marketlist.listener.RecyclerItemClickListener;
import com.example.marketlist.model.ListaProvisoria;
import com.google.android.material.snackbar.Snackbar;

public class ListaSugerida extends AppCompatActivity {

    /*Essa classe deve ter outra lista mais completa, mas utilizei a mesma por praticidade.
    * Então será igual a classe listaMercado*/

    private RecyclerView listaMercado;
    private Button adicionaItem;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_lista_sugerida);

        listaMercado = findViewById(R.id.lista_sugerida);

        BasicAdapter adapter = new BasicAdapter(ListaProvisoria.criaLista());
        listaMercado.setAdapter(adapter);
        listaMercado.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        listaMercado.setLayoutManager(layoutManager);

        listaMercado.addOnItemTouchListener(new RecyclerItemClickListener(getApplicationContext(),
                listaMercado, new RecyclerItemClickListener.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Snackbar snackbar = Snackbar.make(view, "Pressione no item para adicioná-lo",
                        Snackbar.LENGTH_LONG);
                snackbar.show();
            }

            @Override
            public void onLongItemClick(View view, int position) {
                Snackbar snackbar = Snackbar.make(view, "Item adicionado... mentirinha!!!!",
                        Snackbar.LENGTH_LONG);
                snackbar.show();
            }

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            }
        }));




        adicionaItem = findViewById(R.id.cria_item);
        adicionaItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent( ListaSugerida.this, CriaItemLista.class);
                startActivity(intent);

            }
        });


    }


}