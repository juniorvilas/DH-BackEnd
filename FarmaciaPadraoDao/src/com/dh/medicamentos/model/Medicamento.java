package com.dh.medicamentos.model;

public class Medicamento {

    //Atributos
    private Integer id;
    private String nome;
    private String laboratorio;
    private Integer quantidade;
    private Double preco;

    // Construtor-padrão
    public Medicamento (){

    }

    //Construtor completo
    public Medicamento(Integer id, String nome, String laboratorio, Integer quantidade, Double preco) {
        this.id = id;
        this.nome = nome;
        this.laboratorio = laboratorio;
        this.quantidade = quantidade;
        this.preco = preco;
    }

    //Construtor sem id
    public Medicamento(String nome, String laboratorio, Integer quantidade, Double preco) {
        this.nome = nome;
        this.laboratorio = laboratorio;
        this.quantidade = quantidade;
        this.preco = preco;
    }

    //Getters and Setters
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

    public String getLaboratorio() {
        return laboratorio;
    }

    public void setLaboratorio(String laboratorio) {
        this.laboratorio = laboratorio;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    @Override
    public String toString() {
        return "Medicamento{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", laboratorio='" + laboratorio + '\'' +
                ", quantidade=" + quantidade +
                ", preco=" + preco +
                '}';
    }
}