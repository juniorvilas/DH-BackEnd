package com.example.demo.service;

import com.example.demo.entity.Dentista;
import com.example.demo.repository.IDao;
import com.example.demo.repository.IDentistaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DentistaService implements IDao<Dentista> {

    @Autowired
    private IDentistaRepository iDentistaRepository;



    @Override
    public Dentista salvar(Dentista dentista) {
        return iDentistaRepository.save(dentista);
    }

    @Override
    public void excluir(Integer id) {
        iDentistaRepository.deleteById(id);
    }
    @Override
    public Optional<Dentista> buscar(Integer id) {

        return iDentistaRepository.findById(id);
    }
    @Override
    public List<Dentista> buscarTodos() {

        return iDentistaRepository.findAll();
    }
    @Override
    public Dentista atualizar(Dentista dentista) {
        return iDentistaRepository.save(dentista);
    }

}
