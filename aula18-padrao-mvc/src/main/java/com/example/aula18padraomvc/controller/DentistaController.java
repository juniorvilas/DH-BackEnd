package com.example.aula18padraomvc.controller;


import com.example.aula18padraomvc.model.Dentista;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.example.aula18padraomvc.service.DentistaService;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Controller
@RequestMapping("/dentistas")
public class DentistaController {

    private final DentistaService dentistaService;

    @Autowired
    public DentistaController(DentistaService dentistaService){
        this.dentistaService = dentistaService;
    }

    @GetMapping
    public List<Dentista> getDentistas(){
        return dentistaService.listaDentistas();
    }

}
