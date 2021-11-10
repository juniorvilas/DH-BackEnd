package com.example.odonto.service;

import com.example.odonto.domain.Paciente;

import java.util.List;


public interface PacienteService {

    List<Paciente> listPaciente();
    Paciente buscaPorEmail(String email);

}
