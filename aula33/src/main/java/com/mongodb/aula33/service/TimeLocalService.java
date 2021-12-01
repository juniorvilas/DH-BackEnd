package com.mongodb.aula33.service;

import com.mongodb.aula33.model.TimeLocal;
import com.mongodb.aula33.repository.TimeLocalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TimeLocalService {

    @Autowired
    private TimeLocalRepository timeLocalRepository;

    public TimeLocal salvar(TimeLocal timeLocal){
        return timeLocalRepository.save(timeLocal);
    }

    public List<TimeLocal> buscarTodos(){
        return timeLocalRepository.findAll();
    }
}
