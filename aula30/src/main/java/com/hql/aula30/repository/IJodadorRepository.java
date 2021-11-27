package com.hql.aula30.repository;

import com.hql.aula30.model.Jogador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IJodadorRepository extends JpaRepository<Jogador, Integer> {
}
