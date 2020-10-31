package com.example.marketlist;

public class ComponenteMenu {
    private String nome;

    public ComponenteMenu(){}

    public ComponenteMenu(String nome){
        this.nome = nome;
    }

    @Override
    public String toString() {
        return  nome;
    }

    public static ComponenteMenu componentes[] = {

            new ComponenteMenu("Ler QR Code"),
            new ComponenteMenu("Lista"),
            new ComponenteMenu("Gastos"),
            new ComponenteMenu("Sobre")
    };
}
