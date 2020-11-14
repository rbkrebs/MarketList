package com.example.marketlist.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.marketlist.adapters.Adapter;
import com.example.marketlist.R;
import com.example.marketlist.fragments.ListaFragment;
import com.example.marketlist.model.ListaProvisoria;

public class ListaMercado extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_mercado);


    }

}