package com.example.aula18padraomvc.service;

import com.example.aula18padraomvc.model.Dentista;

import org.springframework.stereotype.Service;


import java.util.Arrays;
import java.util.List;

//A anotação @Service sinaliza ao Spring que é um serviço.
// Também vemos como a lista de dentistas está codificada.
// Isso acontece adicionando manualmente os dados.

@Service
public class DentistaSeriveImpl implements DentistaService {

    @Override
    public List<Dentista> listaDentistas() {
        return Arrays.asList(new Dentista("Maria"),
                new Dentista("João"));
    }



}
