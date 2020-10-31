package com.example.marketlist;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

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

    public void onCheckBoxClicked(View view) {

        boolean checked = ((CheckBox) view).isChecked();

        switch(view.getId()){
            case R.id.checkExcluir:
                if(checked)
                    Toast.makeText(AlteraItemCompra.this,
                            "Este item será excluído da lista", Toast.LENGTH_SHORT).show();
                break;
        }

    }

    public void onBtnSalvarClicked(View view) {

        Toast.makeText(AlteraItemCompra.this,
                "Alterações salvas! (Mentirinha!!!)", Toast.LENGTH_SHORT).show();


    }


}