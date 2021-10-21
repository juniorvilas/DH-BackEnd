package com.vacina;

import java.util.Date;

public class Pessoa {
//as pessoas são cadastradas e devem informar os seguintes dados: nome, sobrenome e RG.
//Além disso, quando marcarem uma vacinação,
// uma data lhes é atribuída, bem como o nome da vacina que lhes será aplicada.

    //Atributos
    private String nome;
    private String sobrenome;
    private String RG;
    private String nomeVacina;
    private Date data;

    //Contrutor
    public Pessoa(String nome, String sobrenome, String RG, String nomeVacina, Date data) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.RG = RG;
        this.nomeVacina = nomeVacina;
        this.data = data;
    }
    //Objeto que contem os dados de registro da vacina: RG e Data
    public Object[] dados() {
        Object[] informacao = new Object[2];
        informacao[0] = RG;
        informacao[1] = data;
        return informacao;
    }

    //Getter and Setter



}
