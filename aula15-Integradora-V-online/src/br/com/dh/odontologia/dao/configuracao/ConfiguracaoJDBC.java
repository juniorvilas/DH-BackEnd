package br.com.dh.odontologia.dao.configuracao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConfiguracaoJDBC {

    private String jdbcDriver;
    private String dbUrl;
    private String nomeusuario;
    private String senhausuario;

    // Construtor recebendo parâmetros
    public ConfiguracaoJDBC(String jdbcDriver, String dbUrl, String nomeusuario, String senhausuario) {
        this.jdbcDriver = jdbcDriver;
        this.dbUrl = dbUrl;
        this.nomeusuario = nomeusuario;
        this.senhausuario = senhausuario;
    }

    // Construtor configurado
    public ConfiguracaoJDBC() {
        this.jdbcDriver = "org.h2.Driver";
        this.dbUrl = "jdbc:h2:~/clinica2;DB_CLOSE_DELAY=-1;INIT=RUNSCRIPT FROM 'CREATE.SQL'";
        this.nomeusuario = "sa";
        this.senhausuario = "";
    }

    // Método para conectar no BD
    public Connection conectarComBancoDeDados() {
        Connection connection = null;

        try {
            connection = DriverManager.getConnection(
                    dbUrl,
                    nomeusuario,
                    senhausuario
            );
        }
        catch (SQLException e) {
            e.printStackTrace();
        }

        return connection;
    }

}
