package com.example.odonto.controller;

import com.example.odonto.service.IDentistaService;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DentistaControllerLista {

    private final IDentistaService dentistaService;


    public DentistaControllerLista(IDentistaService dentistaService) {
        this.dentistaService = dentistaService;
    }
}
