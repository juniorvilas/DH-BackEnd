package com.digitalhouse.clinicaodonto.impl;

import com.digitalhouse.clinicaodonto.configuration.ConfigurationJDBC;
import com.digitalhouse.clinicaodonto.model.Dentista;
import com.digitalhouse.clinicaodonto.model.Endereco;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class DentistaDaoH2 implements IDao<Dentista>{

    private ConfigurationJDBC configurationJDBC;
    private EnderecoDaoH2 enderecoDaoH2;
    final static Logger log = Logger.getLogger(DentistaDaoH2.class);

    public DentistaDaoH2(EnderecoDaoH2 enderecoDaoH2) {
        this.configurationJDBC = new ConfigurationJDBC();
        this.enderecoDaoH2 = enderecoDaoH2;
    }

    @Override
    public Dentista cadastrar(Dentista dentista) {
        log.debug("Registrando dentista: " + dentista.toString());
        Connection connection = configurationJDBC.conectarComBancoDeDados();
        Statement stmt = null;
        dentista.setEndereco(enderecoDaoH2.cadastrar(dentista.getEndereco()));
        String query = String.format("INSERT INTO PACIENTE (" +
                "NOME, SOBRENOME, MATRICULA, ENDERECO_ID) "+
                "VALUES ('%S','%S','%S','%S')",
                dentista.getNome(),
                dentista.getSobrenome(),
                dentista.getMatricula(),
                dentista.getEndereco().getId());
        try {
            stmt = connection.createStatement();
            stmt.executeUpdate(query, Statement.RETURN_GENERATED_KEYS);
            ResultSet keys = stmt.getGeneratedKeys();
            if(keys.next())
                dentista.setId(keys.getInt(1));
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return dentista;

    }

    @Override
    public Optional<Dentista> buscar (Integer id) {
        log.debug("Buscando Dentista com id: " + id);
        Connection connection = configurationJDBC.conectarComBancoDeDados();
        Statement stmt = null;
        String query = String.format("SELECT ID, NOME, SOBRENOME,MATRICULA, ENDERECO_ID FROM DENTISTA WHERE ID = '%s'", id);
        Dentista dentista = null;
        try {
            stmt = connection.createStatement();
            ResultSet result = stmt.executeQuery(query);
            while (result.next()) {
                dentista = criarDentista(result);
            }
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return dentista != null ? Optional.of(dentista) : Optional.empty();
    }

    @Override
    public void excluir(Integer id) {
        log.debug("Eliminando Dentista com id: " + id);
        Connection connection = configurationJDBC.conectarComBancoDeDados();
        Statement stmt = null;
        String query = String.format("DELETE FROM DENTISTA WHERE ID = %s", id);
        try{
            stmt = connection.createStatement();
            stmt.executeUpdate(query);
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Dentista> buscarTodos () {
        log.debug("Buscando todos os Dentistas:");
        Connection connection = configurationJDBC.conectarComBancoDeDados();
        Statement stmt = null;
        String query = "SELECT * FROM DENTISTA";
        List<Dentista> dentistas = new ArrayList<>();
        try {
            stmt = connection.createStatement();
            ResultSet result = stmt.executeQuery(query);
            while(result.next()) {
                dentistas.add(criarDentista(result));
            }
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return dentistas;
    }

    @Override
    public Dentista atualizar (Dentista dentista) {
        log.debug("Atualizando o Dentista: " + dentista.toString());
        Connection connection = configurationJDBC.conectarComBancoDeDados();
        if(dentista.getEndereco() != null && dentista.getId() != null)
            enderecoDaoH2.atualizar(dentista.getEndereco());

        String query = String.format("UPDATE PACIENTE SET NOME = '%s', SOBRENOME = '%s' WHERE ID = '%s'",
                dentista.getNome(), dentista.getSobrenome(), dentista.getMatricula(), dentista.getId());
        execute(connection, query);
        return dentista;
    }

    private void execute (Connection connection, String query) {
        try{
            Statement stmt = connection.createStatement();
            stmt.executeUpdate(query);
            stmt.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private Dentista criarDentista(ResultSet result) throws SQLException {

        Integer idDentista = result.getInt("ID");
        String nome = result.getString("NOME");
        String sobrenome = result.getString("SOBRENOME");
        String matricula = result.getString("MATRICULA");
        Endereco endereco = enderecoDaoH2.buscar(result.getInt("ENDERECO_ID")).orElse(null);
        return new Dentista(idDentista, nome, sobrenome, matricula, endereco);
    }
























}
