package com.example.odonto.controller;

import com.example.odonto.domain.Paciente;
import com.example.odonto.service.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PacienteController {

    private final PacienteService pacienteService;

    @Autowired
    public PacienteController(PacienteService pacienteService) {
        this.pacienteService = pacienteService;
    }

    @GetMapping("/buscaremail")
    public String busca(Model model){
        Paciente paciente = pacienteService.buscaPorEmail(
                "fernando@gmail.com"
        );
        model.addAttribute("nome", paciente.getNome());
        model.addAttribute("sobrenome", paciente.getSobrenome());
        return "index";
    }

}
