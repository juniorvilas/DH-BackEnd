package com.hql.aula30.service;

import com.hql.aula30.model.Treinador;
import com.hql.aula30.repository.ITreinadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TreinadorService {

    @Autowired
    private ITreinadorRepository iTreinadorRepository;

    public void insert(Treinador treinador){
        iTreinadorRepository.save(treinador);
    }
}
