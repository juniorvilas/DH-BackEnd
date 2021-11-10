package com.example.odonto.service;

import com.example.odonto.domain.Dentista;

import java.util.List;

public interface IDentistaService {

    List<Dentista> listaDentista();
    Dentista buscar(Integer id);
}
