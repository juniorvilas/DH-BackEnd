package com.example.demo.controller;



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



    @Autowired
    private ConsultaService consultaService;
    private PacienteService pacienteService;
    private DentistaService dentistaService;
    private UsuarioService usuarioService;

    //CREATE
    @PostMapping
    public ResponseEntity<Consulta> registrarConsulta(@RequestBody Consulta consulta) {
        ResponseEntity<Consulta> response;
        if (pacienteService.buscar(consulta.getPaciente().getId()).isPresent() &&
                dentistaService.buscar(consulta.getDentista().getId()).isPresent() && usuarioService.buscar(consulta.getUsuario().getId()).isPresent())
            response = ResponseEntity.ok(consultaService.registrarConsulta(consulta));

        else
            response = ResponseEntity.status(HttpStatus.BAD_REQUEST).build();

        return response;


    }
    //READ
    @GetMapping
    public ResponseEntity<List<Consulta>> listar() {
        return ResponseEntity.ok(consultaService.listar());
    }
    //DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminar(@PathVariable Integer id) {
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
    public ResponseEntity<Consulta> atualizarConsulta(@RequestBody Consulta consulta) {
        return ResponseEntity.ok(consultaService.atualizar(consulta));

    }



}
