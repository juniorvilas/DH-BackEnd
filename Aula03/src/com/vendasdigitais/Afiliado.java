package com.vendasdigitais;

public class Afiliado extends Vendedores{

    //O objetivo dos afiliados é realizar vendas (vender),

    public Afiliado(String nome) {super(nome);}

    // mas o cálculo dos pontos é diferente: eles ganham 15 pontos a cada nova venda.
    @Override
    public void vender() {
        int pontos = this.getPontos();
        pontos += 15;
        setPontos(pontos);
    }



}
