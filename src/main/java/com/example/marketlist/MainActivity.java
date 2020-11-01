package com.example.marketlist;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity  {

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

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if(item.getItemId() == R.id.action_settings){
            Intent intent = new Intent(getApplicationContext(), Sobre.class);
            startActivity(intent);
        }

        return super.onOptionsItemSelected(item);
    }
}