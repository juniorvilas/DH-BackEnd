package com.mongodb.aula33.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

@NoArgsConstructor
@Getter
@Setter
@ToString
@Document(collection = "partidas")
public class Partida implements Serializable {
    private static final long serialVersionUID = 1L;


    @Id
    private String id;
    private String status;
    private String resultado;
    private TimeLocal timeLocal;
    private TimeVisitante timeVisitante;



}
