package com.example.demo.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table
public class Endereco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String rua;
    private String numero;
    private String cidade;
    private String estado;
    @OneToMany(mappedBy = "endereco", fetch = FetchType.LAZY)
    private Set<Paciente> paciente = new HashSet<>();


    public Endereco() {
    }

    public Endereco(String rua, String numero, String cidade, String estado, Set<Paciente> paciente) {
        this.rua = rua;
        this.numero = numero;
        this.cidade = cidade;
        this.estado = estado;
        this.paciente = paciente;
    }

    public Endereco(Integer id, String rua, String numero, String cidade, String estado, Set<Paciente> paciente) {
        this.id = id;
        this.rua = rua;
        this.numero = numero;
        this.cidade = cidade;
        this.estado = estado;
        this.paciente = paciente;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Set<Paciente> getPaciente() {
        return paciente;
    }

    public void setPaciente(Set<Paciente> paciente) {
        this.paciente = paciente;
    }
}
