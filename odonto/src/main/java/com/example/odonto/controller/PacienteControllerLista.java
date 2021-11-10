package com.example.odonto.controller;

import com.example.odonto.domain.Paciente;
import com.example.odonto.service.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PacienteControllerLista {

    private final PacienteService pacienteService;

    @Autowired
    public PacienteControllerLista(PacienteService pacienteService) {
        this.pacienteService = pacienteService;
    }

    @GetMapping("/pacientes")
    public List<Paciente> getPaciente(){
        return pacienteService.listPaciente();
    }
}
