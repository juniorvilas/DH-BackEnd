package com.mongodb.aula33.controller;


import com.mongodb.aula33.model.TimeVisitante;
import com.mongodb.aula33.service.TimeVisitanteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/timevisitante")
public class TimeVisitanteController {

    @Autowired
    private TimeVisitanteService timeVisitanteService;

    @PostMapping
    public TimeVisitante salvar(@RequestBody TimeVisitante timeVisitante){
        return timeVisitanteService.salvar(timeVisitante);
    }

    @GetMapping
    public List<TimeVisitante> buscarTodos(){
        return timeVisitanteService.buscarTodos();
    }
}
