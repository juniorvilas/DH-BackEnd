package br.com.dh.odontologia.dao.impl;

import br.com.dh.odontologia.dao.IDao;
import br.com.dh.odontologia.dao.configuracao.ConfiguracaoJDBC;

import br.com.dh.odontologia.model.Endereco;
import br.com.dh.odontologia.model.Paciente;
import org.apache.log4j.Logger;
import br.com.dh.odontologia.util.Util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;



public class PacienteDaoH2 implements IDao<Paciente> {

    private ConfiguracaoJDBC configuracaoJDBC;
    private EnderecoDaoH2 enderecoDaoH2;
    //final static Logger log = Logger.getLogger(PacienteDaoH2.class);

    public PacienteDaoH2 (EnderecoDaoH2 enderecoDaoH2){
        this.configuracaoJDBC = new ConfiguracaoJDBC();
        this.enderecoDaoH2 = enderecoDaoH2;
    }

    //Salvar
    @Override
    public Paciente salvar(Paciente paciente) {
        //log.debug("Registrando paciente : " + paciente.toString());
        System.out.println("Registrando paciente : " + paciente.toString());
        Connection conexao = configuracaoJDBC.conectarComBancoDeDados();
        Statement stmt = null;
        paciente.setEndereco(enderecoDaoH2.salvar(paciente.getEndereco()));
        String query = String.format("INSERT INTO PACIENTE " +
                        "(NOME, SOBRENOME, RG, DATA_CADASTRO, ENDERECO_ID) " +
                        "VALUES ('%s','%s','%s','%s','%s')", paciente.getNome(),
                paciente.getSobrenome(), paciente.getRg(),
                Util.dateToTimestamp(paciente.getDataCadastro()),
                paciente.getEndereco().getId());
        try {
            stmt = conexao.createStatement();
            stmt.executeUpdate(query, Statement.RETURN_GENERATED_KEYS);
            ResultSet keys = stmt.getGeneratedKeys();
            if (keys.next())
                paciente.setId(keys.getInt(1));
            stmt.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return paciente;
    }
    //Método Buscar
    @Override
    public Optional<Paciente> buscar(Integer id) {
        //log.debug("Buscando paciente com id  : " + id);
        System.out.println("Buscando paciente com id: " + id);
        Connection conexao = configuracaoJDBC.conectarComBancoDeDados();
        Statement stmt = null;
        String query = String.format("SELECT ID, NOME, SOBRENOME, RG, DATA_CADASTRO, ENDERECO_ID FROM PACIENTE WHERE ID = '%s'", id);
        Paciente paciente = null;
        try {
            stmt = conexao.createStatement();
            ResultSet resultado = stmt.executeQuery(query);
            while (resultado.next()) {

                paciente = criarObjetoPaciente(resultado);
            }

            stmt.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }


        return paciente != null ? Optional.of(paciente) : Optional.empty();
    }
    //Método excluir
    @Override
    public void excluir(Integer id) {
        //log.debug("Excluindo paciente com id: " + id);
        System.out.println("Excluindo paciente com id: " + id);
        Connection conexao = configuracaoJDBC.conectarComBancoDeDados();
        Statement stmt = null;
        String query = String.format("DELETE FROM PACIENTE WHERE ID = %s", id);
        try {
            stmt = conexao.createStatement();
            stmt.executeUpdate(query);
            stmt.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    //Método buscartodos
    @Override
    public List<Paciente> buscarTodos() {
        //log.debug("Buscando todos os pacientes");
        System.out.println("Buscando todos os pacientes: ");
        Connection conexao = configuracaoJDBC.conectarComBancoDeDados();
        Statement stmt = null;
        String query = "SELECT *  FROM PACIENTE";
        List<Paciente> pacientes = new ArrayList<>();
        try {
            stmt = conexao.createStatement();
            ResultSet resultado = stmt.executeQuery(query);
            while (resultado.next()) {

                pacientes.add(criarObjetoPaciente(resultado));
            }

            stmt.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return pacientes;
    }
    //Método Criar objeto
    private Paciente criarObjetoPaciente(ResultSet result) throws SQLException {

        Integer idPaciente = result.getInt("ID");
        String nome = result.getString("NOME");
        String sobrenome = result.getString("SOBRENOME");
        String rg = result.getString("RG");
        Date dataCadastro = result.getDate("DATA_CADASTRO");
        Endereco endereco = enderecoDaoH2.buscar(result.getInt("ENDERECO_ID")).orElse(null);
        return new Paciente(idPaciente, nome, sobrenome, rg, dataCadastro, endereco);

    }









}
