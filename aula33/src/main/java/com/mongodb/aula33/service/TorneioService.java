package com.mongodb.aula33.service;

import com.mongodb.aula33.model.Torneio;
import com.mongodb.aula33.repository.TorneioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TorneioService {

    @Autowired
    private TorneioRepository torneioRepository;

    public Torneio guardarTorneio(Torneio torneio){
        return torneioRepository.save(torneio);
    }

    public List<Torneio> listarTorneios(){
        return torneioRepository.findAll();
    }



}
