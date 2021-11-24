package com.example.demo.entity;


import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table
public class Usuario {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;
    private String email;
    private String senha;
    private Integer acesso;
    @OneToMany(mappedBy = "usuario", fetch = FetchType.LAZY)
    private Set<Consulta> consulta = new HashSet<>();

    //VAZIO
    public Usuario() {
    }

    //Construtor com ID
    public Usuario(Integer id, String nome, String email, String senha, Integer acesso, Set<Consulta> consulta) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.acesso = acesso;
        this.consulta = consulta;
    }

    //Contrutor sem ID
    public Usuario(String nome, String email, String senha, Integer acesso, Set<Consulta> consulta) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.acesso = acesso;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Integer getAcesso() {
        return acesso;
    }

    public void setAcesso(Integer acesso) {
        this.acesso = acesso;
    }

    public Set<Consulta> getConsulta() {
        return consulta;
    }

    public void setConsulta(Set<Consulta> consulta) {
        this.consulta = consulta;
    }
}
