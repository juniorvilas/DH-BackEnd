package com.example.demo.service;

import com.example.demo.entity.Endereco;
import com.example.demo.repository.IEnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import org.apache.log4j.Logger;

@Service
public class EnderecoService {

    @Autowired
    private IEnderecoRepository iEnderecoRepository;

    final static Logger log = Logger.getLogger(EnderecoService.class);

    public Endereco salvar(Endereco endereco){
        log.debug("Registrando novo Endereço!");
        iEnderecoRepository.save(endereco);
        return endereco;
    }

    public Optional<Endereco> buscar(Integer id){
        log.debug("Buscando Endereço com ID: "+ id);
        return iEnderecoRepository.findById(id);
    }

    public List<Endereco> buscarTodos(){
        log.debug("Buscando todos Endereços");
        return iEnderecoRepository.findAll();
    }

    public void excluir(Integer id){
        log.debug("Excluindo Endereço com ID: "+ id);
        iEnderecoRepository.deleteById(id);
    }

    public Endereco atualizar(Endereco endereco) {
        log.debug("Atualizando Endereço!");
        return iEnderecoRepository.save(endereco);
    }



}
