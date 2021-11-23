package com.lanchonete.produtos.service;


import com.lanchonete.produtos.dao.ProdutoRepository;
import com.lanchonete.produtos.model.Produto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Service
public class ProdutoServiceImpl  implements ProdutoService {

    private final ProdutoRepository produtoRepository;

    @Autowired
    public ProdutoServiceImpl(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    @Override
    public List<Produto> obterTodos(){
        return produtoRepository.findAll();
    }
    @Override
    public void guardar(Produto produto){
         produtoRepository.save(produto);
    }
    @Override
    public void apagar(Long id){
        produtoRepository.deleteById(id);
    }

    @Override
    public Optional<Produto> buscar(Long id){
        return produtoRepository.findById(id);
    }

    @Override
    public Produto atualizar(Produto produto){
        return produtoRepository.save(produto);
    }


}
