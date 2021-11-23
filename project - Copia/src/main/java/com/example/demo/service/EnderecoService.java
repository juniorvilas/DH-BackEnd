package com.example.demo.service;

import com.example.demo.entity.Endereco;
import com.example.demo.repository.IDao;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EnderecoService {

    private IDao<Endereco> enderecoDao;

    public EnderecoService(IDao<Endereco> enderecoDao) {
        this.enderecoDao = enderecoDao;
    }


    public Endereco salvar(Endereco e){
        enderecoDao.salvar(e);
        return e;
    }
    public Optional<Endereco> buscar(Integer id){
        return enderecoDao.buscar(id);
    }
    public List<Endereco> buscarTodos(){
        return enderecoDao.buscarTodos();
    }
    public void excluir(Integer id){
        enderecoDao.excluir(id);
    }

    public Endereco atualizar(Endereco e) {
        return enderecoDao.atualizar(e);
    }



}
