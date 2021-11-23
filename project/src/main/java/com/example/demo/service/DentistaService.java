package com.example.demo.service;

import com.example.demo.entity.Dentista;
import com.example.demo.repository.IDao;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service// Comunica com respositorio DentistaDaoH2
public class DentistaService {

    private IDao<Dentista> dentistaIDao;

    public DentistaService(IDao<Dentista> dentistaIDao) {
        this.dentistaIDao = dentistaIDao;
    }

    public Dentista registrarDentista(Dentista dentista) {
        return dentistaIDao.salvar(dentista);
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

    public Dentista atualizar(Dentista dentista) {
        return dentistaIDao.atualizar(dentista);
    }

}
