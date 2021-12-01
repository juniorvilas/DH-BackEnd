package com.mongodb.aula33.repository;

import com.mongodb.aula33.model.TimeVisitante;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TimeVisitanteRepository extends MongoRepository<TimeVisitante, String> {
}
