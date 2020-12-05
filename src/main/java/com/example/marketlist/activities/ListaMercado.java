package com.example.marketlist.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.marketlist.adapters.Adapter;
import com.example.marketlist.R;
import com.example.marketlist.fragments.ListaFragment;
import com.example.marketlist.model.ItemComprado;
import com.example.marketlist.model.ListaProvisoria;

public class ListaMercado extends AppCompatActivity implements Adapter.ListaProvisoriaListener {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_mercado);


    }

    @Override
    public void onClickItem(ItemComprado itemComprado) {
        Intent intent = new Intent(this, AlteraItemCompra.class);
        intent.putExtra("item", itemComprado);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        this.startActivity(intent);

    }
}