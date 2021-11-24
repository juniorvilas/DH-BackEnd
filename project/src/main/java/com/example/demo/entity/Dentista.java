package com.example.demo.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table
public class Dentista {

    //Atributos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;
    private String sobrenome;
    private Integer matricula;
    @OneToMany(mappedBy = "dentista", fetch = FetchType.LAZY)
    private Set<Consulta> consulta = new HashSet<>();

    //Contrutor Padrao vazio
    public Dentista() {
    }

    //Construtor com ID

    public Dentista(Integer id, String nome, String sobrenome, Integer matricula, Set<Consulta> consulta) {
        this.id = id;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.matricula = matricula;
        this.consulta = consulta;
    }

    //Construtor sem ID


    public Dentista(String nome, String sobrenome, Integer matricula, Set<Consulta> consulta) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.matricula = matricula;
        this.consulta = consulta;
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

    public Integer getMatricula() {
        return matricula;
    }

    public void setMatricula(Integer matricula) {
        this.matricula = matricula;
    }

    public Set<Consulta> getConsulta() {
        return consulta;
    }

    public void setConsulta(Set<Consulta> consulta) {
        this.consulta = consulta;
    }
}
