package com.digitalhouse.clinicaodonto.service;

import com.digitalhouse.clinicaodonto.impl.IDao;
import com.digitalhouse.clinicaodonto.model.Dentista;

import java.util.List;
import java.util.Optional;

public class DentistaService {

    private IDao<Dentista> dentistaIDao;

    public DentistaService(IDao<Dentista> dentistaIDao) {
        this.dentistaIDao = dentistaIDao;
    }

    public Dentista cadastrar(Dentista d) {
        dentistaIDao.cadastrar(d);
        return d;
    }

    public Optional<Dentista> buscar(Integer id) {
        return dentistaIDao.buscar(id);
    }

    public List<Dentista> buscarTodos(){
        return dentistaIDao.buscarTodos();
    }

    public void excluir(Integer id) {
        dentistaIDao.excluir(id);
    }

    public Dentista atualizar (Dentista dentista) {
        return dentistaIDao.atualizar(dentista);
    }

}
