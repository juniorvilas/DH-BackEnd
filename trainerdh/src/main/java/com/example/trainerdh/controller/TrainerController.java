package com.example.trainerdh.controller;


import com.example.trainerdh.domain.Trainer;
import com.example.trainerdh.service.TrainerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/trainer")
public class TrainerController {

    private final TrainerService trainerService;

    //A anotação @ Autowired fornece controle sobre onde e como
    // a ligação entre os beans deve ser realizada.
    // Pode ser usado para em métodos setter, no construtor,
    // em uma propriedade ou métodos com nomes arbitrários e
    // / ou vários argumentos.

    @Autowired
    public TrainerController(TrainerService trainerService) {
        this.trainerService = trainerService;
    }

    //@GetMapping é uma anotação composta que atua como
    // um atalho para @RequestMapping(method = RequestMethod. GET)

    @GetMapping
    public List<Trainer> getTrainer() {
        return trainerService.listTrainer();
    }


}
