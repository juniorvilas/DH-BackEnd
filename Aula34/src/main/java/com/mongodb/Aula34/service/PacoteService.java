package com.mongodb.Aula34.service;

import com.mongodb.Aula34.entity.Estado;
import com.mongodb.Aula34.entity.Pacote;
import com.mongodb.Aula34.repository.PacoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PacoteService {

    @Autowired
    private PacoteRepository pacoteRepository;


    public Pacote adicionar(Pacote pacote){
        return pacoteRepository.save(pacote);
    }

    public List<Pacote> listarTodos(){
        return pacoteRepository.findAll();
    }

    public List<Pacote> pacotesAcaminho(Estado estado){
        return pacoteRepository.findByEstado(estado);
    }

}
