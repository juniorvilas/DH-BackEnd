package com.mongodb.aula33.controller;

import com.mongodb.aula33.model.TimeLocal;
import com.mongodb.aula33.service.TimeLocalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/timelocal")
public class TimeLocalController {

    @Autowired
    private TimeLocalService timeLocalService;


    @PostMapping
    public TimeLocal salvar(@RequestBody TimeLocal timeLocal){
        return timeLocalService.salvar(timeLocal);
    }

    @GetMapping
    public List<TimeLocal> buscarTodos(){
        return timeLocalService.buscarTodos();
    }
}
