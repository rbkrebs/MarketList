package com.example.marketlist;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    private ListView lista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lista = findViewById(R.id.lista_menu);
        ComponenteMenu[] componenteMenus = ComponenteMenu.componentes;
        ArrayAdapter<ComponenteMenu> listaAdapter = new ArrayAdapter(this,
                                                    android.R.layout.simple_list_item_1,
                                                    componenteMenus);
        lista.setAdapter(listaAdapter);
        lista.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        if(position == 0){//componente QRCode
            Intent intent = new Intent(this, QRCode.class);
            startActivity(intent);
        }

        if(position == 1){//componente Lista
            Intent intent = new Intent(this, ListaMercado.class);
            startActivity(intent);
        }

        if(position == 2){//componente Gastos
            Intent intent = new Intent(this, Gastos.class);
            startActivity(intent);
        }
        if(position == 3){//componente Sobre
            Intent intent = new Intent(this, Sobre.class);
            startActivity(intent);
        }

    }
}