package com.example.demo.service;

import com.example.demo.entity.Endereco;
import com.example.demo.repository.IDao;
import com.example.demo.repository.IEnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EnderecoService implements IDao<Endereco>{

    @Autowired
    private IEnderecoRepository iEnderecoRepository;


    @Override
    public Endereco salvar(Endereco endereco){
        iEnderecoRepository.save(endereco);
        return endereco;
    }
    @Override
    public Optional<Endereco> buscar(Integer id){
        return iEnderecoRepository.findById(id);
    }
    @Override
    public List<Endereco> buscarTodos(){
        return iEnderecoRepository.findAll();
    }
    @Override
    public void excluir(Integer id){
        iEnderecoRepository.deleteById(id);
    }
    @Override
    public Endereco atualizar(Endereco e) {
        return iEnderecoRepository.save(e);
    }



}
