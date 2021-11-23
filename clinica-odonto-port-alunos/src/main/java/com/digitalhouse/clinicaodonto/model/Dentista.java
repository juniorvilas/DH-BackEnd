package com.digitalhouse.clinicaodonto.model;

public class Dentista {

    private Integer id;
    private String nome;
    private String sobrenome;
    private String matricula;
    private Endereco endereco;



    public Dentista(Integer id, String nome, String sobrenome, String matricula, Endereco endereco) {
        this.id = id;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.matricula = matricula;
        this.endereco = endereco;
    }

    public Dentista(String nome, String sobrenome, String matricula, Endereco endereco) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.matricula = matricula;
        this.endereco = endereco;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }
}
