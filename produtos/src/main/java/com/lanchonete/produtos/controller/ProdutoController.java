package com.lanchonete.produtos.controller;


import com.lanchonete.produtos.model.Produto;
import com.lanchonete.produtos.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {


    private final ProdutoService produtoService;

    @Autowired
    public ProdutoController(ProdutoService produtoService){
        this.produtoService = produtoService;
    }

    //CREATE
    @PostMapping
    public ResponseEntity<?> criarProduto(@RequestBody Produto produto){
        produtoService.guardar(produto);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    //BUSCAR POR ID
    @GetMapping("/{id}")
    public ResponseEntity<Produto> buscar(@PathVariable Long id){
        Produto produto = produtoService.buscar(id).orElse(null);
        return ResponseEntity.ok(produto);
    }


    //BUSCAR TODOS
    @GetMapping
    public ResponseEntity<List<Produto>> obterTodos(){
        return ResponseEntity.ok(produtoService.obterTodos());
    }

    //DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<?> apagar(@PathVariable Long id){

        produtoService.apagar(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    //ATUALIZAR
    @PutMapping
    public ResponseEntity<?> atualizar(@RequestBody Produto produto){
        produtoService.atualizar(produto);
        return new ResponseEntity<>(HttpStatus.OK);
    }




}
