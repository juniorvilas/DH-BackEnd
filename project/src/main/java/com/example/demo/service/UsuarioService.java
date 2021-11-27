package com.example.demo.service;


import com.example.demo.entity.Usuario;
import com.example.demo.repository.IUsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;
import org.apache.log4j.Logger;

@Service
public class UsuarioService {

    @Autowired
    private IUsuarioRepository iUsuarioRepository;

    final static Logger log = Logger.getLogger(UsuarioService.class);

    public Usuario salvar(Usuario usuario) {
        log.debug("Registrando Usuario: " + usuario.toString());
        return iUsuarioRepository.save(usuario);
    }


    public void excluir(Integer id){
        log.debug("Excluindo Usuario com ID: "+ id);
        iUsuarioRepository.deleteById(id);
    }


    public Optional<Usuario> buscar(Integer id){
        log.debug("Buscando Usuario com ID: "+ id);
        return iUsuarioRepository.findById(id);
    }


    public List<Usuario> buscarTodos(){
        log.debug("Buscando todos Usuarios");
        return iUsuarioRepository.findAll();
    }


    public Usuario atualizar(Usuario usuario){
        log.debug("Atualizando Usuario: " + usuario.toString());
        return iUsuarioRepository.save(usuario);
    }
}
