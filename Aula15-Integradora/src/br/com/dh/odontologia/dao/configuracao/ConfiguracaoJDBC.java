package br.com.dh.odontologia.dao.configuracao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConfiguracaoJDBC {

        private String jdbcDriver;
        private String dbUrl;
        private String nomeUsuario;
        private String senhaUsuario;


        //Construtor recebendo paramentros
        public ConfiguracaoJDBC(String jdbcDriver, String dbUrl, String nomeUsuario, String senhaUsuario) {
                this.jdbcDriver = jdbcDriver;
                this.dbUrl = dbUrl;
                this.nomeUsuario = nomeUsuario;
                this.senhaUsuario = senhaUsuario;
        }

        //Construtor Configurado
        public ConfiguracaoJDBC(){
                this.jdbcDriver = "org.h2.Driver";
                this.dbUrl = "jdbc:h2:~/clinica;DB_CLOSE_DELAY=-1;INIT=RUNSCRIPT FROM 'create.sql'";
                this.nomeUsuario = "sa";
                this.senhaUsuario = "";
        }

        //Método para conectar no Banco de Dados
        public Connection conectarComBancoDeDados(){
                Connection connection = null;
                try {
                        connection = DriverManager.getConnection(
                                dbUrl,
                                nomeUsuario,
                                senhaUsuario
                        );
                }
                catch (SQLException e){
                        e.printStackTrace();
                }
                return connection;
        }

}
