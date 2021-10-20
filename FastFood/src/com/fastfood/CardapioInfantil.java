package com.fastfood;

public class CardapioInfantil extends Cardapio{

    private double presenteSupresa;
        public CardapioInfantil(double precoBase, String comida, double presenteSupresa) {
        super(precoBase, comida);
        this.presenteSupresa = presenteSupresa;
    }

    @Override
    public void montar() {
        System.out.println("Esse menu teve um presente Supresa no valor de: " + presenteSupresa);
    }

    @Override
    public double calcularPreco() {
        return getPrecoBase() + presenteSupresa;
    }
}
