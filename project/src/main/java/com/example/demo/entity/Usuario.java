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
    private Set<Consulta> consultas = new HashSet<>();

    //VAZIO
    public Usuario() {
    }

    //Contrutor sem ID
    public Usuario(String nome, String email, String senha, Integer acesso) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.acesso = acesso;

    }

    //Construtor com ID
    public Usuario(Integer id, String nome, String email, String senha, Integer acesso) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.acesso = acesso;

    }


    //GETTERS AND SETTERS
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

    public Set<Consulta> getConsultas() {
        return consultas;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                ", acesso=" + acesso +
                '}';
    }
}
