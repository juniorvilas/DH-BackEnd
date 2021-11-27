package com.example.demo.service;

import com.example.demo.entity.Paciente;
import com.example.demo.repository.IEnderecoRepository;
import com.example.demo.repository.IPacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.apache.log4j.Logger;

@Service
public class PacienteService {

    @Autowired
    private IPacienteRepository iPacienteRepository;

    @Autowired
    private IEnderecoRepository iEnderecoRepository;

    final static Logger log = Logger.getLogger(PacienteService.class);

    public Paciente salvar(Paciente paciente) {
        log.debug("Registrando Paciente: " + paciente.toString());
        paciente.setDataCadastro(new Date());
        return iPacienteRepository.save(paciente);
    }

    public Optional<Paciente> buscar(Integer id) {
        log.debug("Buscando paciente com ID: "+ id);
        return iPacienteRepository.findById(id);
    }

    public List<Paciente> buscarTodos() {
        log.debug("Buscando todos Pacientes");
        return iPacienteRepository.findAll();
    }


    public void excluir(Integer id) {
        log.debug("Excluindo paciente com ID: "+ id);
        iPacienteRepository.deleteById(id);
    }

    public Paciente atualizar(Paciente paciente) {
        log.debug("Atualizando Paciente: " + paciente.toString());
        paciente.setDataCadastro(new Date());
        return iPacienteRepository.save(paciente);
    }


}
