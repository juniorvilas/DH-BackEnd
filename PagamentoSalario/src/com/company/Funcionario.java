package com.company;

public abstract class Funcionario {

    //Atributos da Classe Funcionário
    private String nome;
    private String sobrenome;
    private String numeroConta;

    public Funcionario(String nome, String sobrenome, String numeroConta) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.numeroConta = numeroConta;
    }

    public void pagamentoSalario() {
        double quantia;
        quantia = calcularSalario();
        imprimirRecibo(quantia);
        depositar(quantia);
    }

    //Metodo abstract para poder sobreescrevelo fora da Classe
    public abstract double calcularSalario();
    public abstract  void imprimirRecibo(double quantia);
    public abstract void depositar(double quantia);
}
