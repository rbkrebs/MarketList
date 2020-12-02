package com.example.marketlist.fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.marketlist.R;
import com.example.marketlist.activities.MainActivity;
import com.example.marketlist.adapters.Adapter;
import com.example.marketlist.model.ListaProvisoria;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;


public class FormItemFragment extends Fragment {

    public static final String TAG_DETALHE = "tagDetalhe";
    private TextInputLayout itemTextLabel;
    private TextInputEditText itemTextInput;
    private TextInputLayout observacaoLabel;
    private TextInputEditText observacaoInput;
    private ListaProvisoria itemLista;

    public static FormItemFragment novaInstancia(ListaProvisoria listaProvisoria){

        Bundle parametros = new Bundle();
        parametros.putSerializable("item", listaProvisoria);
        FormItemFragment fragment = new FormItemFragment();
        fragment.setArguments(parametros);
        return fragment;
    }


    public FormItemFragment(){

    }



    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

        try{
            itemLista = (ListaProvisoria) getArguments().getSerializable("item");
        }catch (NullPointerException e){
            itemLista = null;
        }

        setHasOptionsMenu(true);
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        View layout = inflater.inflate(R.layout.fragment_form_item, container, false);

        itemTextLabel = layout.findViewById(R.id.itemTextLabel);
        itemTextInput = layout.findViewById(R.id.itemText);

        observacaoLabel = layout.findViewById(R.id.editObservacaoLabel);
        observacaoInput = layout.findViewById(R.id.editObservacao);

        Spinner spinner = layout.findViewById(R.id.spinnerQuantidadeItem);
        spinner.setSelection(0,false);

        if(itemLista != null){

            itemTextInput.setText(itemLista.getNomeProduto());
            observacaoInput.setText(itemLista.getObservacoes());
            spinner.setSelection(itemLista.getQuantidade()-1);

        }
        Button btnSalvar = layout.findViewById(R.id.btnSalvar);

        btnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(validarCampos()){
                    Intent intent = new Intent(v.getContext(), MainActivity.class);
                    Snackbar snackbar = Snackbar.make(v, "Dados Salvos!!", Snackbar.LENGTH_LONG);
                    snackbar.show();
                    startActivity(intent);
                }
                else {
                    Snackbar snackbar = Snackbar.make(v, "Cadastro Incorreto!!", Snackbar.LENGTH_LONG);
                    snackbar.show();
                }
            }
        });

        return layout;
    }

    private boolean validarCampos(){

        if (itemTextInput.getText().toString().isEmpty()){

            itemTextLabel.setErrorEnabled(true);
            itemTextLabel.setError("Este campo é obrigatório");
            return false;
        }else if(itemTextInput.getText().toString().length()> itemTextLabel.getCounterMaxLength()){
            itemTextLabel.setErrorEnabled(true);
            itemTextLabel.setError("Número de caracteres maior que o permitido");
            return false;
        }

        else{
            itemTextLabel.setErrorEnabled(false);
        }
        return true;
    }



}