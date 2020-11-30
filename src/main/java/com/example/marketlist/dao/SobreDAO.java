package com.example.marketlist.dao;

import com.example.marketlist.model.Sobre;

import io.realm.Realm;

public class SobreDAO {

    public String insert(Sobre sobre) {
        try {
            Realm realm = Realm.getDefaultInstance();
            realm.beginTransaction();
            try {
                // Realm não tem um auto incremento, logo é necessário fazer o código abaixo
                sobre.setId(realm.where(Sobre.class).max("id").intValue() + 1);
            } catch (Exception ex) {
                sobre.setId(1);
            }

            //para inserir dados é necessário abrir uma transaction e no final do bloco chamar o método commitTransaction()
            realm.insert(sobre);
            realm.commitTransaction();
            return "Registro Inserido com sucesso";

        } catch (Exception e) {
            e.printStackTrace();
            return "Erro ao inserir registro";
        }
    }

}
