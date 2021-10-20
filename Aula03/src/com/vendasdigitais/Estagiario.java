package com.vendasdigitais;

public class Estagiario extends Vendedores{

    public Estagiario(String nome) {super(nome);}

    //objetivo dos estagiários é fazer vendas, onde para cada uma, eles receberão 5 pontos.
    @Override
    public void vender() {
        int pontos = this.getPontos();
        pontos += 5;
        setPontos(pontos);
    }

    @Override
    public void mostrarCategoria(){
        String categoria = this.getPontos() < 50 ? "Novato" : "Experiente";
        System.out.println(this.getNome() + " tem um total de: " + this.getPontos() + " pontos e categoriza como estagiário " + categoria);
    }

}
