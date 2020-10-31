package com.example.marketlist;

import android.app.SearchManager;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class CriaItemLista extends AppCompatActivity implements AdapterView.OnItemSelectedListener{





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cria_item_lista);
        EditText itemText = findViewById(R.id.criaItem);
        EditText editObservacao = findViewById(R.id.criaeditObservacao);
        Spinner spinner = findViewById(R.id.pesquisarInternet);
        spinner.setSelection(0,false);
        spinner.setOnItemSelectedListener(this);
    }


    public void onBtnSalvarClicked(View view) {

        Toast.makeText(CriaItemLista.this,
                "Alterações salvas! (Mentirinha!!!)", Toast.LENGTH_SHORT).show();


    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

        Intent intent = new Intent(Intent.ACTION_WEB_SEARCH);
        intent.putExtra(SearchManager.QUERY, "dieta "+parent.getSelectedItem().toString() + " alimentos");
        startActivity(intent);
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}