package com.dh.medicamentos.dao.impl;

import com.dh.medicamentos.dao.ConfiguracaoJDBC;
import com.dh.medicamentos.dao.IDao;
import com.dh.medicamentos.model.Medicamento;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MedicamentosDaoH2 implements IDao<Medicamento> {

    private ConfiguracaoJDBC configuracaoJDBC;

    public MedicamentosDaoH2(ConfiguracaoJDBC configuracaoJDBC) {
        this.configuracaoJDBC = configuracaoJDBC;
    }

    //Aqui ficam as interfaces

    //Salvar
    public Medicamento salvar(Medicamento medicamento){
        Connection connection = configuracaoJDBC.conectarComBancoDeDados();
        Statement statement = null;
        String query = String.format(
            "INSERT INTO medicamentos" +
            "(nome, laboratorio, quantidade, preco) " +
            "VALUES ('%s', '%s', '%s', '%s')",
            medicamento.getNome(),
            medicamento.getLaboratorio(),
            medicamento.getQuantidade(),
            medicamento.getPreco()
        );

        try {
            statement = connection.createStatement();
            statement.executeUpdate(query,Statement.RETURN_GENERATED_KEYS);
            ResultSet keys = statement.getGeneratedKeys();
            if(keys.next())
                medicamento.setId(keys.getInt(1));

            statement.close();
            connection.close();

        }
        catch (SQLException e){
            e.printStackTrace();
        }

        return medicamento;
    }

    //Buscar p/ID
    public Medicamento buscar(Integer id) {

        Connection connection = configuracaoJDBC.conectarComBancoDeDados();
        Statement statement = null;
        String query = String.format(
            "SELECT id, nome, laboratorio, quantidade, preco " +
            "FROM medicamentos " +
            "WHERE id = '%s'", id);
        Medicamento medicamento = null;

        try{
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()){
                medicamento = new Medicamento(
                    resultSet.getInt("id"),
                    resultSet.getString("nome"),
                    resultSet.getString("laboratorio"),
                    resultSet.getInt("quantidade"),
                    resultSet.getDouble("preco")
                );
            }
            statement.close();
            connection.close();
        }
        catch (SQLException e){
            e.printStackTrace();
        }

        return medicamento;
    }
}
