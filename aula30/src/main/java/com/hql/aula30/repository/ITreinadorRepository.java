package com.hql.aula30.repository;

import com.hql.aula30.model.Treinador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITreinadorRepository extends JpaRepository<Treinador, Integer> {
}
