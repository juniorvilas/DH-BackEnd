package com.digitalhouse.clinicaodonto.model;

import java.util.Date;

public class Consulta {

    //Atributos da Classe Consulta
    private Integer id;
    private Paciente paciente;
    private Dentista dentista;
    private Date date;

    //Construtor padrão vazio
    public Consulta() {
    }

    //Construtor sem ID
    public Consulta(Paciente paciente, Dentista dentista, Date date) {
        this.paciente = paciente;
        this.dentista = dentista;
        this.date = date;
    }

    //Getters and Setters


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public Dentista getDentista() {
        return dentista;
    }

    public void setDentista(Dentista dentista) {
        this.dentista = dentista;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    //Método toString
    @Override
    public String toString() {
        return "Consulta{" +
                "id=" + id +
                ", paciente=" + paciente +
                ", dentista=" + dentista +
                ", date=" + date +
                '}';
    }
}
