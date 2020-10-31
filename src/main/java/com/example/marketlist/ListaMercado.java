package com.example.marketlist;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

public class ListaMercado extends AppCompatActivity implements AdapterView.OnItemClickListener{

    private ListView listaMercado;
    private Button adicionaItem;
    ListaProvisoria[] listaProvisorias = ListaProvisoria.lista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_mercado);

        listaMercado = findViewById(R.id.lista_mercado);

        ArrayAdapter<ListaProvisoria> listaAdapter = new ArrayAdapter(this,
                android.R.layout.simple_list_item_1,
                listaProvisorias);
        listaMercado.setAdapter(listaAdapter);
        listaMercado.setOnItemClickListener(this);

        adicionaItem = findViewById(R.id.adiciona_item);
        adicionaItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent( ListaMercado.this, ListaSugerida.class);
                startActivity(intent);

            }
        });


    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            Intent intent = new Intent(this, AlteraItemCompra.class);
            intent.putExtra("itemText", listaProvisorias[position].getNomeProduto());
            intent.putExtra("editObservacao", listaProvisorias[position].getObservacoes());
            intent.putExtra("spinnerQuantidadeItem", listaProvisorias[position].getQuantidade());
            startActivity(intent);

    }
}