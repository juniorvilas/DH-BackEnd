package com.example.demo.service;

import com.example.demo.entity.Paciente;
import com.example.demo.repository.IDao;
import com.example.demo.repository.IPacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class PacienteService implements IDao<Paciente>{

    @Autowired
    private IPacienteRepository iPacienteRepository;


    @Override
    public Paciente salvar(Paciente paciente) {
        paciente.setDataCadastro(new Date());
        return iPacienteRepository.save(paciente);
    }

    @Override
    public Optional<Paciente> buscar(Integer id) {
        return iPacienteRepository.findById(id);
    }
    @Override
    public List<Paciente> buscarTodos() {
        return iPacienteRepository.findAll();
    }

    @Override
    public void excluir(Integer id) {
        iPacienteRepository.deleteById(id);
    }
    @Override
    public Paciente atualizar(Paciente p) {
        return iPacienteRepository.save(p);
    }


}
