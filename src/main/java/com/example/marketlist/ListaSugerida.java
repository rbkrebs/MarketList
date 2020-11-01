package com.example.marketlist;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.example.marketlist.model.ListaProvisoria;

public class ListaSugerida extends AppCompatActivity {

    /*Essa classe deve ter outra lista mais completa, mas utilizei a mesma por praticidade.
    * Então será igual a classe listaMercado*/

    private ListView listaMercado;
    private Button adicionaItem;
    ListaProvisoria[] listaProvisorias = ListaProvisoria.lista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_lista_sugerida);

        listaMercado = findViewById(R.id.lista_sugerida);

        ArrayAdapter<ListaProvisoria> listaAdapter = new ArrayAdapter(this,
                android.R.layout.simple_list_item_1,
                listaProvisorias);
        listaMercado.setAdapter(listaAdapter);


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