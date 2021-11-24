package com.example.demo.service;

import com.example.demo.entity.Paciente;
import com.example.demo.repository.IDao;
import com.example.demo.repository.IPacienteRepository;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class PacienteService implements IDao<Paciente>{

    private final IPacienteRepository iPacienteRepository;

    public PacienteService(IPacienteRepository iPacienteRepository) {
        this.iPacienteRepository = iPacienteRepository;
    }

    @Override
    public Paciente salvar(Paciente p) {
        p.setDataCadastro(new Date());
        return iPacienteRepository.save(p);
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
