package dao;

import java.util.List;
import java.util.Optional;

public interface IDao<T> {

    T salvar(T t);

    Optional<T> buscar(Integer id);
    //O Optional é como se fosse um if, se caso não exista
    // o objeto ele retorna nulo

    void excluir(Integer id);

    List<T> buscarTodos();

}
