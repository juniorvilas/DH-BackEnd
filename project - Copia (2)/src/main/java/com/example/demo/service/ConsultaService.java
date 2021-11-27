package com.example.demo.service;

import com.example.demo.dao.ConsultaDao;
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
public class ConsultaService implements IDao<Consulta> {

    @Autowired
    private IConsultaRepository iConsultaRepository;

    @Autowired
    private IDentistaRepository iDentistaRepository;

    @Autowired
    private IPacienteRepository iPacienteRepository;

    @Autowired
    private IUsuarioRepository iUsuarioRepository;



//    public void insert(ConsultaDao consultaDao){
//        Dentista dentista_id = iDentistaRepository.getById(consultaDao.getIdDentista());
//        Paciente paciente_id = iPacienteRepository.getById(consultaDao.getIdPaciente());
//        Usuario usuario_id = iUsuarioRepository.getById(consultaDao.getIdUsuario());
//        Consulta consulta = new Consulta(
//                 dentista_id,
//                paciente_id,
//                usuario_id);
//        iConsultaRepository.save(consulta);
//    }

    @Override
    public Consulta salvar(Consulta consulta) {
        consulta.setDataCadastro(new Date());
        return iConsultaRepository.save(consulta);
    }

    @Override
    public List<Consulta> buscarTodos(){
        return iConsultaRepository.findAll();
    }

    @Override
    public void excluir(Integer id){
        iConsultaRepository.deleteById(id);
    }

    @Override
    public Consulta atualizar(Consulta consulta){
        return iConsultaRepository.save(consulta);
    }

    @Override
    public Optional<Consulta> buscar(Integer id){
        return iConsultaRepository.findById(id);
    }


}
