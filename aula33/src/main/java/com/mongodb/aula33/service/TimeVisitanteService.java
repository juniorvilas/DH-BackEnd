package com.mongodb.aula33.service;

import com.mongodb.aula33.model.TimeVisitante;
import com.mongodb.aula33.repository.TimeVisitanteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TimeVisitanteService {



    @Autowired
    private TimeVisitanteRepository timeVisitanteRepository;


    public TimeVisitante salvar(TimeVisitante timeVisitante){
        return timeVisitanteRepository.save(timeVisitante);
    }

    public List<TimeVisitante> buscarTodos(){
        return timeVisitanteRepository.findAll();
    }

}
