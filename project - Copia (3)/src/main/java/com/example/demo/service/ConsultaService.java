package com.example.demo.service;

import com.example.demo.dto.ConsultaDto;
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

@Service
public class ConsultaService {


    private IConsultaRepository iConsultaRepository;
    private IDentistaRepository iDentistaRepository;
    private IPacienteRepository iPacienteRepository;
    private IUsuarioRepository iUsuarioRepository;

    @Autowired
    public ConsultaService(IConsultaRepository iConsultaRepository, IDentistaRepository iDentistaRepository, IPacienteRepository iPacienteRepository, IUsuarioRepository iUsuarioRepository) {
        this.iConsultaRepository = iConsultaRepository;
        this.iDentistaRepository = iDentistaRepository;
        this.iPacienteRepository = iPacienteRepository;
        this.iUsuarioRepository = iUsuarioRepository;
    }






    public void salvar(ConsultaDto consultaDto){
        Dentista dentista_id = iDentistaRepository.getById(consultaDto.getIdDentista());
        Paciente paciente_id = iPacienteRepository.getById(consultaDto.getIdPaciente());
        Usuario usuario_id = iUsuarioRepository.getById(consultaDto.getIdUsuario());
        Consulta consulta = new Consulta(
                dentista_id,
                paciente_id,
                usuario_id,
                (new Date()));
        iConsultaRepository.save(consulta);
    }


//    public Consulta salvar(Consulta consulta) {
//        consulta.setDataCadastro(new Date());
//        iConsultaRepository.save(consulta);
//    }


    public List<Consulta> buscarTodos(){
        return iConsultaRepository.findAll();
    }


    public void excluir(Integer id){
        iConsultaRepository.deleteById(id);
    }


    public void atualizar(ConsultaDto consultaDto){
        Dentista dentista_id = iDentistaRepository.getById(consultaDto.getIdDentista());
        Paciente paciente_id = iPacienteRepository.getById(consultaDto.getIdPaciente());
        Usuario usuario_id = iUsuarioRepository.getById(consultaDto.getIdUsuario());
        Consulta consulta = new Consulta(
                dentista_id,
                paciente_id,
                usuario_id,
                (new Date()));
        iConsultaRepository.save(consulta);
    }


    public Optional<Consulta> buscar(Integer id){
        return iConsultaRepository.findById(id);
    }


}
