package com.mongodb.Aula34.controller;


import com.mongodb.Aula34.entity.Estado;
import com.mongodb.Aula34.entity.Pacote;
import com.mongodb.Aula34.service.PacoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pacotes")
public class PacoteController {

    @Autowired
    private PacoteService pacoteService;


    @PostMapping
    public Pacote adicionar(@RequestBody Pacote pacote){
        return pacoteService.adicionar(pacote);
    }

    @GetMapping
    public List<Pacote> listartodos(){
        return pacoteService.listarTodos();
    }

    @GetMapping("/acaminho")
    public List<Pacote> pacotesAcaminho(){
        return pacoteService.pacotesAcaminho(Estado.ACAMINHO);
    }

}
