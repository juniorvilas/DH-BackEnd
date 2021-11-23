package com.example.demo.repository.impl;

import com.example.demo.entity.Endereco;
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

@Repository
public class EnderecoDaoH2 implements IDao<Endereco> {

    private ConfiguracaoJDBC configuracaoJDBC;

    public EnderecoDaoH2() {
        this.configuracaoJDBC = new ConfiguracaoJDBC();
    }

    @Override
    public Endereco salvar(Endereco endereco) {
        Connection connection = configuracaoJDBC.conectarDB();
        Statement stmt = null;
        String query = String.format("INSERT INTO endereco (rua,numero,cidade,estado) VALUES('%s','%s','%s','%s')",
                endereco.getRua(),
                endereco.getNumero(),
                endereco.getCidade(),
                endereco.getEstado());
        try {
            stmt = connection.createStatement();
            stmt.executeUpdate(query, Statement.RETURN_GENERATED_KEYS);
            ResultSet keys = stmt.getGeneratedKeys();
            if (keys.next())
                endereco.setId(keys.getInt(1));
            stmt.close();
            connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }


        return endereco;
    }

    @Override
    public Optional<Endereco> buscar(Integer id) {
        Connection connection = configuracaoJDBC.conectarDB();
        Statement stmt = null;
        String query = String.format("SELECT id,rua,numero,cidade,estado FROM endereco where id = '%s'", id);
        Endereco endereco = null;
        try {
            stmt = connection.createStatement();
            ResultSet result = stmt.executeQuery(query);
            while (result.next()) {
                endereco = crearObjetoEndereco(result);
            }

            stmt.close();
            connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return endereco != null ? Optional.of(endereco) : Optional.empty();
    }

    @Override
    public void excluir(Integer id) {
        Connection connection = configuracaoJDBC.conectarDB();
        Statement stmt = null;
        String query = String.format("DELETE FROM endereco where id = %s", id);
        execute(connection, query);


    }

    @Override
    public List<Endereco> buscarTodos() {
        Connection connection = configuracaoJDBC.conectarDB();
        Statement stmt = null;
        String query = "SELECT *  FROM endereco";
        List<Endereco> enderecos = new ArrayList<>();
        try {
            stmt = connection.createStatement();
            ResultSet result = stmt.executeQuery(query);
            while (result.next()) {

                enderecos.add(crearObjetoEndereco(result));

            }

            stmt.close();
            connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return enderecos;
    }

    @Override
    public Endereco atualizar(Endereco endereco) {
        Connection connection = configuracaoJDBC.conectarDB();
        String query = String.format("UPDATE endereco SET rua = '%s', numero = '%s',cidade = '%s',estado = '%s'  WHERE id = '%s'",
                endereco.getRua(),
                endereco.getNumero(),
                endereco.getCidade(),
                endereco.getEstado(),
                endereco.getId());
        execute(connection, query);
        return endereco;
    }

    private Endereco crearObjetoEndereco(ResultSet result) throws SQLException {
        Integer id = result.getInt("id");
        String rua = result.getString("rua");
        String numero = result.getString("numero");
        String cidade = result.getString("cidade");
        String estado = result.getString("estado");
        return new Endereco(id, rua, numero, cidade, estado);

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
