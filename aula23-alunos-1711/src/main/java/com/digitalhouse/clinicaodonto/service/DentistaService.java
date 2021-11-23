package com.digitalhouse.clinicaodonto.service;

import com.digitalhouse.clinicaodonto.dao.IDao;
import com.digitalhouse.clinicaodonto.model.Dentista;

import java.util.List;
import java.util.Optional;

public class DentistaService {

    private IDao<Dentista> dentistaIDao;


    public DentistaService(IDao<Dentista> odontologoDao) {
        this.dentistaIDao = odontologoDao;
    }

    public Dentista cadastrar(Dentista dentista) {
        return dentistaIDao.cadastrar(dentista);

    }

    public void excluir(Integer id) {
        dentistaIDao.excluir(id);
    }

    public Optional<Dentista> buscar(Integer id) {
        return dentistaIDao.buscar(id);
    }

    public List<Dentista> buscarTodos() {
        return dentistaIDao.buscarTodos();
    }

    public Dentista atualizar (Dentista dentista){
        return dentistaIDao.atualizar(dentista);
    }
}

