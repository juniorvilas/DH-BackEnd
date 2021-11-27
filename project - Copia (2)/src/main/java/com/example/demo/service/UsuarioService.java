package com.example.demo.service;


import com.example.demo.entity.Usuario;
import com.example.demo.repository.IDao;
import com.example.demo.repository.IUsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService implements IDao<Usuario>{

    @Autowired
    private IUsuarioRepository iUsuarioRepository;


    @Override
    public Usuario salvar(Usuario usuario) {
        return iUsuarioRepository.save(usuario);
    }

    @Override
    public void excluir(Integer id){
        iUsuarioRepository.deleteById(id);
    }

    @Override
    public Optional<Usuario> buscar(Integer id){
        return iUsuarioRepository.findById(id);
    }

    @Override
    public List<Usuario> buscarTodos(){
        return iUsuarioRepository.findAll();
    }

    @Override
    public Usuario atualizar(Usuario usuario){
        return iUsuarioRepository.save(usuario);
    }
}
