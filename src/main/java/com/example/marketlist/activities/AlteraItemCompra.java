package com.example.marketlist.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.marketlist.R;
import com.example.marketlist.fragments.FormItemFragment;
import com.example.marketlist.model.ItemComprado;
import com.example.marketlist.model.ListaProvisoria;
import com.google.android.material.snackbar.Snackbar;

public class AlteraItemCompra extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_altera_item_compra);

        Intent intent = getIntent();
        ItemComprado itemComprado = (ItemComprado) intent.getSerializableExtra("item");
        FormItemFragment formItemFragment =  FormItemFragment.novaInstancia(itemComprado);
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.altera_itens,formItemFragment, FormItemFragment.TAG_DETALHE);
        ft.commit();


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