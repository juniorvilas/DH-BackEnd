package com.lanchonete.produtos.service;

import com.lanchonete.produtos.model.Produto;

import java.util.List;
import java.util.Optional;

public interface ProdutoService {

    //obter todos
    List<Produto> obterTodos();

    //salvar
    void guardar(Produto produto);

    //apagar
    void apagar(Long id);

    //buscar por id
    Optional<Produto> buscar(Long id);


    //subtrair a quantidade de um produto

    //atualizar
    Produto atualizar(Produto produto);
}

//


