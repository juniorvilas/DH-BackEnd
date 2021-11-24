package com.aula29mesa.futebol.model;


import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table
public class Time {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String cidade;
    @OneToMany(mappedBy = "time", fetch = FetchType.LAZY)
    private Set<Jogador> jogador = new HashSet<>();

    public Time() {
    }

    public Time(String nome, String cidade, Set<Jogador> jogador) {
        this.nome = nome;
        this.cidade = cidade;
        this.jogador = jogador;
    }


    public Time(Long id, String nome, String cidade, Set<Jogador> jogador) {
        this.id = id;
        this.nome = nome;
        this.cidade = cidade;
        this.jogador = jogador;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public Set<Jogador> getJogador() {
        return jogador;
    }

    public void setJogador(Set<Jogador> jogador) {
        this.jogador = jogador;
    }
}
