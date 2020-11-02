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

import com.example.marketlist.R;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class CriaItemLista extends AppCompatActivity implements AdapterView.OnItemSelectedListener{

    private TextInputLayout criaitemTextLabel;
    private TextInputEditText itemText;
    private TextInputLayout criaObservacaoLabel;
    private TextInputEditText editObservacao;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cria_item_lista);
        criaitemTextLabel = findViewById(R.id.criaitemTextLabel);
        itemText = findViewById(R.id.criaItem);
        criaObservacaoLabel = findViewById(R.id.criaObservacaoLabel);
        editObservacao = findViewById(R.id.criaObservacao);
        Spinner spinner = findViewById(R.id.pesquisarInternet);
        spinner.setSelection(0,false);
        spinner.setOnItemSelectedListener(this);
        Button btnSalvar = findViewById(R.id.btnSalvar);

        btnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(validarCampos()){
                    Intent intent = new Intent(v.getContext(), MainActivity.class);
                    startActivity(intent);
                }
                else {
                    Snackbar snackbar = Snackbar.make(v, "Cadastro Incorreto!!", Snackbar.LENGTH_LONG);
                    snackbar.show();
                }
            }
        });
    }

    private boolean validarCampos(){

        if (itemText.getText().toString().isEmpty()){
            criaitemTextLabel.setErrorEnabled(true);
            criaitemTextLabel.setError("Este campo é obrigatório");
            return false;
        }else if(itemText.getText().toString().length()> criaitemTextLabel.getCounterMaxLength()){
            criaitemTextLabel.setErrorEnabled(true);
            criaitemTextLabel.setError("Número de caracteres maior que o permitido");
            return false;
        }

        else{
            criaitemTextLabel.setErrorEnabled(false);
        }
        return true;
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