package com.mongodb.Aula34.repository;

import com.mongodb.Aula34.entity.Estado;
import com.mongodb.Aula34.entity.Pacote;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface PacoteRepository extends MongoRepository<Pacote, String> {

    @Query
    public List<Pacote> findByEstado(Estado estado);

}
