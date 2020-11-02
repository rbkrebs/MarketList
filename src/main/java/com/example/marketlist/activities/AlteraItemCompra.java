package com.example.marketlist.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.marketlist.R;
import com.google.android.material.snackbar.Snackbar;

public class AlteraItemCompra extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_altera_item_compra);

        TextView itemText = findViewById(R.id.itemText);
        EditText editObservacao = findViewById(R.id.editObservacao);
        Spinner spinnerQuantidadeItem = findViewById(R.id.spinnerQuantidadeItem);

        Intent intent = getIntent();
        itemText.setText(intent.getStringExtra("itemText"));
        editObservacao.setText(intent.getStringExtra("editObservacao"));
        spinnerQuantidadeItem.setSelection(intent.getIntExtra("spinnerQuantidadeItem",1)-1);


    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {


    }



    public void onBtnSalvarClicked(View view) {


        Snackbar snackbar = Snackbar.make(view, "Alterações salvas! (Mentirinha!!!)", Snackbar.LENGTH_LONG);
        snackbar.show();


    }


}