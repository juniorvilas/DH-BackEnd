package com.fastfood;

public abstract class Cardapio {

    private String comida;
    private double precoBase;

    public Cardapio(double precoBase, String comida) {
        this.precoBase = precoBase;
    }

    public String getComida() {
        return comida;
    }

    public void setComida(String comida) {
        this.comida = comida;
    }

    public double getPrecoBase() {
        return precoBase;
    }

    public void setPrecoBase(double precoBase) {
        this.precoBase = precoBase;
    }

    public void preparacao() {
        montar();
        System.out.println(calcularPreco());
    }

    public abstract void montar();
    public abstract double calcularPreco();


}
