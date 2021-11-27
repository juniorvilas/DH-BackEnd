package com.hql.aula30.service;

import com.hql.aula30.dao.JogadorDao;
import com.hql.aula30.model.Equipe;
import com.hql.aula30.model.Jogador;
import com.hql.aula30.model.Treinador;
import com.hql.aula30.repository.IEquipeRepository;
import com.hql.aula30.repository.IJodadorRepository;
import com.hql.aula30.repository.ITreinadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JogadorService {

    @Autowired
    private IJodadorRepository iJodadorRepository;

    @Autowired
    private ITreinadorRepository iTreinadorRepository;

    @Autowired
    private IEquipeRepository iEquipeRepository;

    public void insert(JogadorDao jogadorDao){
        Treinador treinador = iTreinadorRepository.getById(jogadorDao.getIdTreinador());
        Equipe equipe = iEquipeRepository.getById(jogadorDao.getIdEquipe());
        Jogador jogador = new Jogador(
                jogadorDao.getNome(),
                jogadorDao.getNumero(),
                jogadorDao.getPosicao(),
                treinador,
                equipe);

        iJodadorRepository.save(jogador);
    }
}
