package br.com.dh.aula21.idade.controller;

import br.com.dh.aula21.idade.service.impl.IPessoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PessoaController {

    @Autowired
    private IPessoService pessoService;

    @GetMapping("/{dia}/{mes}/{ano}")
    public Integer calcularIdade(
        @PathVariable("dia") Integer dia,
        @PathVariable("mes") Integer mes,
        @PathVariable("ano") Integer ano) {

        return pessoService.calcularIdade(dia,mes,ano);

    }

}
