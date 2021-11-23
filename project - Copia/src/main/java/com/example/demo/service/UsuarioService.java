package com.example.demo.service;


import com.example.demo.entity.Usuario;
import com.example.demo.repository.IDao;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    private IDao<Usuario> usuarioIDao;

    public UsuarioService(IDao<Usuario> usuarioIDao) {
        this.usuarioIDao = usuarioIDao;
    }

    public Usuario registrarUsuario(Usuario usuario) {
        return usuarioIDao.salvar(usuario);
    }

    public void excluir(Integer id){
        usuarioIDao.excluir(id);
    }

    public Optional<Usuario> buscar(Integer id){
        return usuarioIDao.buscar(id);
    }

    public List<Usuario> buscarTodos(){
        return usuarioIDao.buscarTodos();
    }

    public Usuario atualizar(Usuario usuario){
        return usuarioIDao.atualizar(usuario);
    }
}
