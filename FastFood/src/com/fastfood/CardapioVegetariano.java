package com.fastfood;

public class CardapioVegetariano extends Cardapio{

    public CardapioVegetariano(double precoBase, String comida) {
        super(precoBase, comida);
    }

    @Override
    public void montar() {
        System.out.println("Esse carpio tem uma embalagem especial já que são acrescentados temperos. O custo aumenta com o valor do contêiner e sobretaxa de 1% para os condimentos. ");
    }

    @Override
    public double calcularPreco() {
        return getPrecoBase() * 1.01;
    }
}
