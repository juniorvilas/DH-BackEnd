package com.hql.aula30.service;

import com.hql.aula30.model.Equipe;
import com.hql.aula30.repository.IEquipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EquipeService {

    @Autowired
    private IEquipeRepository iEquipeRepository;

    public void insert(Equipe equipe){
        iEquipeRepository.save(equipe);
    }


}
