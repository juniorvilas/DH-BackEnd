package com.example.demo.controller;

import com.example.demo.entity.Dentista;
import com.example.demo.service.DentistaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/dentistas")
public class DentistaController {

    @Autowired //
    private DentistaService dentistaService;

    //CREATE
    @PostMapping()
    public ResponseEntity<Dentista> registrarOdontologo(@RequestBody Dentista dentista){
        return ResponseEntity.ok(dentistaService.registrarDentista(dentista));
    }
    //READ
    @GetMapping("/{id}")
    public ResponseEntity<Dentista> buscar(@PathVariable Integer id) {
        Dentista dentista = dentistaService.buscar(id).orElse(null);

        return ResponseEntity.ok(dentista);
    }
    //UPDATE
    @PutMapping()
    public ResponseEntity<Dentista> atualizar(@RequestBody Dentista dentista) {
        ResponseEntity<Dentista> response = null;

        if (dentista.getId() != null && dentistaService.buscar(dentista.getId()).isPresent())
            response = ResponseEntity.ok(dentistaService.atualizar(dentista));
        else
            response = ResponseEntity.status(HttpStatus.NOT_FOUND).build();

        return response;
    }
    //DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminar(@PathVariable Integer id) {
        ResponseEntity<String> response = null;

        if (dentistaService.buscar(id).isPresent()) {
            dentistaService.excluir(id);
            response = ResponseEntity.status(HttpStatus.NO_CONTENT).body("Eliminado");
        } else {
            response = ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        return response;
    }
    @GetMapping
    public ResponseEntity<List<Dentista>> buscarTodos(){
        return ResponseEntity.ok(dentistaService.buscarTodos());
    }

}
