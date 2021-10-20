package com.vendasdigitais;

public class Funcionarios extends Vendedores{

    private int anos;


    public Funcionarios(String nome) {
        super(nome);
        this.anos = 0;

    }

    public int getAnos() { return anos; }

    public void setAnos(int anos) {
        this.anos = anos;
    }

    public void addAnos() {
        anos++;

    }

    //O objetivo dos funcionários é conseguir afiliados (obterAfiliado)
    //Cada um recebe 10 pontos por cada novo afiliado

    public void obterAfiliado() {
        int pontos = this.getPontos();
        pontos += 10;
        setPontos(pontos);

    }

    // 5 pontos por cada venda que fizer e 5 pontos por cada ano de antiguidade que tiver.
    @Override
    public void vender() {
        int pontos = this.getPontos();
        pontos += 5 + (anos * 5);
        setPontos(pontos);

    }






}
