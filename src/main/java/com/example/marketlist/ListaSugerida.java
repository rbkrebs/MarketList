package com.example.marketlist;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.example.marketlist.model.ListaProvisoria;

import java.util.List;

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