package com.example.demo.service;

import com.example.demo.entity.Paciente;
import com.example.demo.repository.IDao;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class PacienteService {

    private IDao<Paciente> pacienteIDao;

    public PacienteService(IDao<Paciente> pacienteIDao) {
        this.pacienteIDao = pacienteIDao;
    }

    public Paciente salvar(Paciente p) {
        p.setDataCadastro(new Date());
        return pacienteIDao.salvar(p);
    }

    public Optional<Paciente> buscar(Integer id) {
        return pacienteIDao.buscar(id);
    }

    public List<Paciente> buscarTodos() {
        return pacienteIDao.buscarTodos();
    }

    public void excluir(Integer id) {
        pacienteIDao.excluir(id);
    }

    public Paciente atualizar(Paciente p) {
        return pacienteIDao.atualizar(p);
    }


}
