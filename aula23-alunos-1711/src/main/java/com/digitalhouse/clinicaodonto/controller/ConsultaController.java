package com.digitalhouse.clinicaodonto.controller;


import com.digitalhouse.clinicaodonto.dao.impl.ConsultaDaoH2;
import com.digitalhouse.clinicaodonto.dao.impl.DentistaDaoH2;
import com.digitalhouse.clinicaodonto.dao.impl.EnderecoDaoH2;
import com.digitalhouse.clinicaodonto.dao.impl.PacienteDaoH2;
import com.digitalhouse.clinicaodonto.model.Consulta;
import com.digitalhouse.clinicaodonto.service.ConsultaService;
import com.digitalhouse.clinicaodonto.service.DentistaService;
import com.digitalhouse.clinicaodonto.service.PacienteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/consulta")
public class ConsultaController {

    private ConsultaService consultaService = new ConsultaService(
                new ConsultaDaoH2());

    private PacienteService pacienteService = new PacienteService(
                new PacienteDaoH2(
                    new EnderecoDaoH2()));

    private DentistaService dentistaService = new DentistaService(
            new DentistaDaoH2());


    @PostMapping
    public ResponseEntity<Consulta> cadastrar(@RequestBody Consulta consulta){
        ResponseEntity<Consulta> response;

        if(pacienteService.buscar(consulta.getPaciente().getId()).isPresent()
            && dentistaService.buscar(consulta.getDentista().getId()).isPresent()){
            response = ResponseEntity.ok(
                    consultaService.cadastrar(consulta));
        }else {
            response = ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }

        return response;

    }

    //buscar Todos
    @GetMapping
    public ResponseEntity <List<Consulta>> buscarTodos () {
        return ResponseEntity.ok(consultaService.buscarTodos());
    }


    //excluir
    @DeleteMapping("/{id}")
    public ResponseEntity<String> excluir(@PathVariable Integer id) {
        ResponseEntity<String> response = null;

         if (consultaService.buscar(id).isPresent()) {
                    consultaService.excluir(id);
                   response = ResponseEntity.status(HttpStatus.NO_CONTENT).body("Consulta excluída");
                } else {
                   response = ResponseEntity.status(HttpStatus.NOT_FOUND).build();
                }
                return response;

    }



    //atualizar
    @PutMapping
    public ResponseEntity<Consulta> atualizar(@RequestBody Consulta consulta) {
        ResponseEntity<Consulta> response = null;
        if (consulta.getId() != null && consultaService.buscar(consulta.getId()).isPresent())
            response = ResponseEntity.ok(consultaService.atualizar(consulta));
        else
            response = ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        return response;

    }




}
