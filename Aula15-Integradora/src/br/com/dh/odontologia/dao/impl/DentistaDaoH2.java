package br.com.dh.odontologia.dao.impl;

import br.com.dh.odontologia.dao.IDao;
import br.com.dh.odontologia.dao.configuracao.ConfiguracaoJDBC;
import br.com.dh.odontologia.model.Dentista;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class DentistaDaoH2 implements IDao<Dentista> {

    private ConfiguracaoJDBC configuracaoJDBC;


    public DentistaDaoH2(ConfiguracaoJDBC configuracaoJDBC) {
        this.configuracaoJDBC = configuracaoJDBC;
    }

    //Salvar
    @Override
    public Dentista salvar(Dentista dentista) {
        System.out.println("Registrando dentista : " + dentista.toString());
        Connection conexao = configuracaoJDBC.conectarComBancoDeDados();
        Statement stmt = null;
        String query = String.format("INSERT INTO DENTISTA " +
                        "(NUMEROMATRICULA, NOME, SOBRENOME) " +
                        "VALUES ('%s','%s','%s')",
                dentista.getNumeroMatricula(),
                dentista.getNome(),
                dentista.getSobrenome());


        try {
            stmt = conexao.createStatement();
            stmt.executeUpdate(query, Statement.RETURN_GENERATED_KEYS);
            ResultSet keys = stmt.getGeneratedKeys();
            if (keys.next())
                dentista.setId(keys.getInt(1));
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return dentista;
    }
    //Método Buscar
    @Override
    public Optional<Dentista> buscar(Integer id) {
        System.out.println("Buscando dentista com id: " + id);
        Connection conexao = configuracaoJDBC.conectarComBancoDeDados();
        Statement stmt = null;
        String query = String.format(
                "SELECT ID, NUMEROMATRICULA, NOME, SOBRENOME " +
                "FROM DENTISTA "+
                "WHERE ID = '%s'", id);
        Dentista dentista = null;
        try {
            stmt = conexao.createStatement();
            ResultSet resultado = stmt.executeQuery(query);
            while (resultado.next()) {

                dentista = criarObjetoDentista(resultado);
            }

            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }


        return dentista != null ? Optional.of(dentista) : Optional.empty();
    }
    //Método excluir
    @Override
    public void excluir(Integer id) {
        System.out.println("Excluindo dentista com id: " + id);
        Connection conexao = configuracaoJDBC.conectarComBancoDeDados();
        Statement stmt = null;
        String query = String.format("DELETE FROM DENTISTA WHERE ID = %s", id);
        try {
            stmt = conexao.createStatement();
            stmt.executeUpdate(query);
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    //Método buscartodos
    @Override
    public List<Dentista> buscarTodos() {
        System.out.println("Buscando todos os dentistas: ");
        Connection conexao = configuracaoJDBC.conectarComBancoDeDados();
        Statement stmt = null;
        String query = "SELECT *  FROM DENTISTA";
        List<Dentista> dentistas = new ArrayList<>();
        try {
            stmt = conexao.createStatement();
            ResultSet resultado = stmt.executeQuery(query);
            while (resultado.next()) {

                dentistas.add(criarObjetoDentista(resultado));
            }

            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return dentistas;
    }
    //Método Criar objeto
    private Dentista criarObjetoDentista(ResultSet result) throws SQLException {

        Integer idDentista = result.getInt("ID");
        String numeroMatricula = result.getString("NUMEROMATRICULA");
        String nome = result.getString("NOME");
        String sobrenome = result.getString("SOBRENOME");
        return new Dentista(idDentista,numeroMatricula,nome,sobrenome);


    }
}
