package com.example.marketlist.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class Sobre extends RealmObject implements Serializable, Parcelable {


    @PrimaryKey
    private int id;
    private String nome;
    private String disciplina;
    private String linkedin;
    private String github;

    public Sobre() {
    }

    public Sobre(int id, String nome, String disciplina, String linkedin, String github) {
        this.id = id;
        this.nome = nome;
        this.disciplina = disciplina;
        this.linkedin = linkedin;
        this.github = github;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(String disciplina) {
        this.disciplina = disciplina;
    }

    public String getLinkedin() {
        return linkedin;
    }

    public void setLinkedin(String linkedin) {
        this.linkedin = linkedin;
    }

    public String getGithub() {
        return github;
    }

    public void setGithub(String github) {
        this.github = github;
    }

    protected Sobre(Parcel in) {
    }

    public static final Creator<Sobre> CREATOR = new Creator<Sobre>() {
        @Override
        public Sobre createFromParcel(Parcel in) {
            return new Sobre(in);
        }

        @Override
        public Sobre[] newArray(int size) {
            return new Sobre[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
    }
}
