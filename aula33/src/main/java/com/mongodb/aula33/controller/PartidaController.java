package com.mongodb.aula33.controller;

import com.mongodb.aula33.model.Partida;
import com.mongodb.aula33.service.PartidaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/partidas")
public class PartidaController {

    @Autowired
    private PartidaService partidaService;


    @PostMapping
    public Partida adicionarPartida(@RequestBody Partida partida){
        return partidaService.salvar(partida);
    }

    @GetMapping
    public List<Partida> buscarTodas(){
        return partidaService.buscarTodas();
    }
}
