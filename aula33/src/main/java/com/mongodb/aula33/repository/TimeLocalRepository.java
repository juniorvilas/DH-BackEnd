package com.mongodb.aula33.repository;

import com.mongodb.aula33.model.TimeLocal;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TimeLocalRepository extends MongoRepository<TimeLocal, String> {
}
