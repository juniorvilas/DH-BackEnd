package com.mongodb.aula33.service;

import com.mongodb.aula33.model.Partida;
import com.mongodb.aula33.repository.PartidaRepository;
import com.mongodb.aula33.repository.TimeLocalRepository;
import com.mongodb.aula33.repository.TimeVisitanteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PartidaService {

    @Autowired
    private PartidaRepository partidaRepository;

    @Autowired
    private TimeLocalRepository timeLocalRepository;

    @Autowired
    private TimeVisitanteRepository timeVisitanteRepository;


    public Partida salvar(Partida partida) {
        timeLocalRepository.save(partida.getTimeLocal());
        timeVisitanteRepository.save(partida.getTimeVisitante());
        return partidaRepository.save(partida);
    }

    public List<Partida> buscarTodas(){
        return partidaRepository.findAll();
    }


}
