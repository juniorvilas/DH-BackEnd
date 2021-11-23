package com.example.demo.repository.impl;


import com.example.demo.entity.Usuario;
import com.example.demo.repository.IDao;
import com.example.demo.repository.configuracao.ConfiguracaoJDBC;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.apache.log4j.Logger;

@Repository // Classe guarda os dados
public class UsuarioDaoH2 implements IDao<Usuario> {


    private final ConfiguracaoJDBC configuracaoJDBC;
    public UsuarioDaoH2(ConfiguracaoJDBC configuracaoJDBC) {
        this.configuracaoJDBC = configuracaoJDBC;
    }

    final static Logger log = Logger.getLogger(UsuarioDaoH2.class);


    @Override
    public Usuario salvar(Usuario usuario) {
        log.debug("Registrando Usuario: " + usuario.toString());
        Connection connection = configuracaoJDBC.conectarDB();
        Statement statement = null;
        String query = String.format(""+
                "INSERT INTO usuario "+
                "(nome, email, senha, acesso) "+
                "VALUES "+
                "('%s','%s', '%s','%s')",
                usuario.getNome(),
                usuario.getEmail(),
                usuario.getSenha(),
                usuario.getAcesso());

        try {
            statement = connection.createStatement();
            statement.executeUpdate(query, Statement.RETURN_GENERATED_KEYS);
            ResultSet keys = statement.getGeneratedKeys();
            if (keys.next())
                usuario.setId(keys.getInt(1));
            statement.close();
            connection.close();
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return usuario;
    }


    @Override
    public Optional<Usuario> buscar(Integer id) {
        log.debug("Buscando usuario com id : "+id);
        Connection connection = configuracaoJDBC.conectarDB();
        Statement stmt = null;
        String query = String.format("SELECT id,nome,email,senha,acesso FROM usuario where id = '%s'", id);
        Usuario usuario = null;
        try {
            stmt = connection.createStatement();
            ResultSet result = stmt.executeQuery(query);
            while (result.next()) {
                usuario = criarObjetoUsuario(result);
            }

            stmt.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return usuario != null ? Optional.of(usuario) : Optional.empty();
    }

    @Override
    public void excluir(Integer id) {
        log.debug("Apagando usuario com id : "+id);
        Connection connection = configuracaoJDBC.conectarDB();
        Statement stmt = null;
        String query = String.format("DELETE FROM usuario where id = %s", id);
        execute(connection, query);

    }

    @Override
    public List<Usuario> buscarTodos() {
        log.debug("Buscando todos os usuarios");
        Connection connection = configuracaoJDBC.conectarDB();
        Statement stmt = null;
        String query = "SELECT * FROM usuario";
        List<Usuario> usuario = new ArrayList<>();
        try {
            stmt = connection.createStatement();
            ResultSet result = stmt.executeQuery(query);
            while (result.next()) {

                usuario.add(criarObjetoUsuario(result));

            }

            stmt.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return usuario;
    }

    @Override
    public Usuario atualizar(Usuario usuario) {
        log.debug("Atualizando o usuário: " +usuario.toString());
        Connection connection = configuracaoJDBC.conectarDB();

        String query = String.format("UPDATE usuario SET nome = '%s', email = '%s',senha = '%s', acesso = '%s'  WHERE id = '%s'",
                usuario.getNome(),
                usuario.getEmail(),
                usuario.getSenha(),
                usuario.getAcesso(),
                usuario.getId());
        execute(connection, query);
        return usuario;
    }

    private Usuario criarObjetoUsuario(ResultSet resultSet) throws SQLException {

        return new Usuario(resultSet.getInt("id"), resultSet.getString("nome"), resultSet.getString("email"),resultSet.getString("senha"), resultSet.getInt("acesso"));
    }
    private void execute(Connection connection, String query) {
        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate(query);
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
