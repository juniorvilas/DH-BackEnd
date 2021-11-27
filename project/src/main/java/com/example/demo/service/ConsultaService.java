package com.example.demo.service;

import com.example.demo.dto.ConsultaDTO;
import com.example.demo.entity.Consulta;
import com.example.demo.entity.Dentista;
import com.example.demo.entity.Paciente;
import com.example.demo.entity.Usuario;
import com.example.demo.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.apache.log4j.Logger;

@Service
public class ConsultaService {

    @Autowired
    private IConsultaRepository iConsultaRepository;
    @Autowired
    private IDentistaRepository iDentistaRepository;
    @Autowired
    private IPacienteRepository iPacienteRepository;
    @Autowired
    private IUsuarioRepository iUsuarioRepository;

    final static Logger log = Logger.getLogger(ConsultaService.class);

    public Consulta salvar(ConsultaDTO consultaDto) {
        log.debug("Registrando Consulta");
        Dentista dentista_id = iDentistaRepository.getById(consultaDto.getIdDentista());
        Paciente paciente_id = iPacienteRepository.getById(consultaDto.getIdPaciente());
        Usuario usuario_id = iUsuarioRepository.getById(consultaDto.getIdUsuario());
        if((dentista_id!= null) && (paciente_id!= null) && (usuario_id!= null)){
            Consulta consulta = new Consulta(
                    dentista_id,
                    paciente_id,
                    usuario_id,
                    (new Date()));
            iConsultaRepository.save(consulta);
            return consulta;
        } else {
            throw new RuntimeException("Não existe Dentistas, Pacientes e Usuarios com esse ID");
        }

    }

    public List<Consulta> buscarTodos(){
        log.debug("Buscando todas Consultas");
        return iConsultaRepository.findAll();
    }


    public void excluir(Integer id){
        log.debug("Excluindo Consulta com ID: " + id);
        iConsultaRepository.deleteById(id);
    }


    public Optional<Consulta> buscar(Integer id){
        log.debug("Buscando Consulta com ID: "+ id);
        return iConsultaRepository.findById(id);
    }


}
