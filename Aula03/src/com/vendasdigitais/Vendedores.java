package com.vendasdigitais;

public abstract class Vendedores {


    private String nome;
    private int pontos;

    public Vendedores(String nome) {
        this.nome = nome;
        this.pontos = 0;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;

    }

    public int getPontos() {
        return pontos;
    }

    public void setPontos(int pontos) {
        this.pontos = pontos;
    }



    //Cada vendedor retorna uma categoria (mostrarCategoria)
    // de acordo com o número de pontos obtidos.

    public void mostrarCategoria(){
        if(this.getPontos() < 20) {
            System.out.println(nome + " tem um total de: " + this.getPontos() + " pontos e categoriza como vendedor Novato! ");
        } else if (this.getPontos() >= 20 && this.getPontos() <= 30) {
            System.out.println(nome + " tem um total de: " + this.getPontos() + " pontos e categoriza como vendedor Aprendiz! ");
        } else if (this.getPontos() > 30 && this.getPontos() < 41) {
            System.out.println(nome + " tem um total de: " + this.getPontos() + " pontos e categoriza como vendedor Bom! ");
        } else {
            System.out.println(nome + " tem um total de: " + this.getPontos() + " pontos e categoriza como vendedor Mestre! ");
        }

    }

    public abstract void vender();

}
