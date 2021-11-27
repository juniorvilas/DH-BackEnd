package com.example.demo.controller;

import com.example.demo.dto.ConsultaDto;
import com.example.demo.entity.Consulta;
import com.example.demo.service.ConsultaService;
import com.example.demo.service.DentistaService;
import com.example.demo.service.PacienteService;
import com.example.demo.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/consultas")
public class ConsultaController {


    private ConsultaService consultaService;
    private PacienteService pacienteService;
    private DentistaService dentistaService;
    private UsuarioService usuarioService;

    @Autowired
    public ConsultaController(ConsultaService consultaService, PacienteService pacienteService, DentistaService dentistaService, UsuarioService usuarioService) {
        this.consultaService = consultaService;
        this.pacienteService = pacienteService;
        this.dentistaService = dentistaService;
        this.usuarioService = usuarioService;
    }

    //CREATE
    @PostMapping
    public ResponseEntity<?> salvar(@RequestBody ConsultaDto consultaDto) {
        consultaService.salvar(consultaDto);
        return new ResponseEntity<>(HttpStatus.OK);
//        Consulta consulta = consultaService.salvar(consultaDao.tranformaParaObjeto());
//        return new ResponseEntity<>(consulta, HttpStatus.CREATED);

    }

    //READ
    @GetMapping("/{id}")
    public ResponseEntity<Consulta> buscar(@PathVariable Integer id) {
        Consulta consulta = consultaService.buscar(id).orElse(null);

        return ResponseEntity.ok(consulta);
    }
    @GetMapping
    public ResponseEntity<List<Consulta>> listar() {
        return ResponseEntity.ok(consultaService.buscarTodos());
    }
    //DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<String> excluir(@PathVariable Integer id) {
        ResponseEntity<String> response;
        if (consultaService.buscar(id).isPresent()) {
            consultaService.excluir(id);
            response = ResponseEntity.status(HttpStatus.NO_CONTENT).body("Eliminado");
        } else {
            response = ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return response;
    }
    //UPDATE
    @PutMapping
    public ResponseEntity<?> atualizar(@RequestBody ConsultaDto consultaDto) {
        consultaService.salvar(consultaDto);
        return new ResponseEntity<>(HttpStatus.OK);

    }



}
