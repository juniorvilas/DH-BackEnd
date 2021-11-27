package com.example.demo.service;

import com.example.demo.entity.Dentista;
import com.example.demo.repository.IDentistaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import org.apache.log4j.Logger;

@Service
public class DentistaService {

    @Autowired
    private IDentistaRepository iDentistaRepository;

    final static Logger log = Logger.getLogger(DentistaService.class);


    public Dentista salvar(Dentista dentista) {
        log.debug("Registrando Dentista: " + dentista.toString());
        return iDentistaRepository.save(dentista);
    }


    public void excluir(Integer id) {
        log.debug("Excluindo Dentista com ID: "+ id);
        iDentistaRepository.deleteById(id);
    }

    public Optional<Dentista> buscar(Integer id) {
        log.debug("Buscando Dentista com ID: "+ id);
        return iDentistaRepository.findById(id);
    }

    public List<Dentista> buscarTodos() {
        log.debug("Buscando todos Dentistas");
        return iDentistaRepository.findAll();
    }

    public Dentista atualizar(Dentista dentista) {
        log.debug("Atualizando Dentista: " + dentista.toString());
        return iDentistaRepository.save(dentista);
    }

}
