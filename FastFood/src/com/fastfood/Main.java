package com.fastfood;

import javax.xml.catalog.Catalog;

public class Main {
    public static void main(String[] args) {
        Cardapio cardapio = new CardapioAdulto(100,"Lasanha");
        cardapio.preparacao();
        System.out.println("------------------------------------------------------------");
        Cardapio infantil = new CardapioInfantil(50,"Mc Lanche Feliz",50);
        infantil.preparacao();
        System.out.println("------------------------------------------------------------");
        Cardapio vegetariano = new CardapioVegetariano(100,"vegetariana");
        vegetariano.preparacao();
    }
}
