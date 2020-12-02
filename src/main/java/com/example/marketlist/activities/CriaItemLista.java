package com.example.marketlist.activities;

import android.app.SearchManager;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.marketlist.R;
import com.example.marketlist.fragments.FormItemFragment;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class CriaItemLista extends AppCompatActivity implements AdapterView.OnItemSelectedListener{



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cria_item_lista);

        Spinner spinner = findViewById(R.id.pesquisarInternet);
        spinner.setSelection(0,false);
        spinner.setOnItemSelectedListener(this);

        FormItemFragment formItemFragment =  new FormItemFragment();
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.cria_item,formItemFragment, FormItemFragment.TAG_DETALHE);
        ft.commit();


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