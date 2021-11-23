package com.example.demo.service;

import com.example.demo.entity.Consulta;
import com.example.demo.repository.IDao;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ConsultaService {

    private IDao<Consulta> consultaIDao;

    public ConsultaService(IDao<Consulta> consultaIDao) {
        this.consultaIDao = consultaIDao;
    }

    public Consulta registrarConsulta(Consulta consulta){
        return  consultaIDao.salvar(consulta);
    }
    public List<Consulta> listar(){
        return consultaIDao.buscarTodos();
    }
    public void excluir(Integer id){
        consultaIDao.excluir(id);
    }
    public Consulta atualizar(Consulta consulta){
        return consultaIDao.atualizar(consulta);
    }
    public Optional<Consulta> buscar(Integer id){
        return consultaIDao.buscar(id);
    }


}
