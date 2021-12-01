package com.mongodb.aula33.controller;


import com.mongodb.aula33.model.Torneio;
import com.mongodb.aula33.service.TorneioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/torneios")
public class TorneioController {

    @Autowired
    private TorneioService torneioService;

    @PostMapping
    public Torneio adicionarTorneio(@RequestBody Torneio torneio){
        return torneioService.guardarTorneio(torneio);
    }

    @GetMapping
    public List<Torneio> listarTorneios(){
        return torneioService.listarTorneios();
    }




}
