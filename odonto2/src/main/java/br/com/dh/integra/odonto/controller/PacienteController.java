package br.com.dh.integra.odonto.controller;

import br.com.dh.integra.odonto.domain.Paciente;
import br.com.dh.integra.odonto.service.PacienteService;
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
    public String busca(Model model) {
        Paciente pac = pacienteService.buscaPorEmail(
                "taison10@internacional.com"
        );
        model.addAttribute("nome", pac.getNome());
        model.addAttribute("sobrenome", pac.getSobrenome());
        return "index";
    }

}
