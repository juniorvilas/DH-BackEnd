package com.mongodb.aula33.repository;

import com.mongodb.aula33.model.Torneio;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TorneioRepository extends MongoRepository<Torneio, String> {

}
