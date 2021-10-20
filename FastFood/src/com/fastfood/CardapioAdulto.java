package com.fastfood;

public class CardapioAdulto extends Cardapio{


    public CardapioAdulto(double precoBase, String comida) {
        super(precoBase, comida);
    }

    @Override
    public void montar() {
        System.out.println("Sem itens adicionais!");
    }

    @Override
    public double calcularPreco() {
        return getPrecoBase();
    }


}
