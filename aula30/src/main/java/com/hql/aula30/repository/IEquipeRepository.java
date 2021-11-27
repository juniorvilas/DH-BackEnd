package com.hql.aula30.repository;

import com.hql.aula30.model.Equipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IEquipeRepository extends JpaRepository<Equipe, Integer> {
}
