import java.sql.*;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

public class App {

    private static final String sqlCreateTable = "DROP TABLE IF EXISTS funcionarios; "+
            "CREATE TABLE funcionarios " +
            "(id INT PRIMARY KEY, " +
            "nome VARCHAR(16) NOT NULL, " +
            "sobrenome VARCHAR(32) NOT NULL, " +
            "idade INT NOT NULL, " +
            "email VARCHAR(32) NOT NULL, " +
            "cargo VARCHAR(32) NOT NULL, " +
            "salario DOUBLE NOT NULL)";
    private static final String sqlInsert = "INSERT INTO funcionarios " +
            "(id, nome, sobrenome, idade, email, cargo, salario) VALUES " +
            "(1, 'Jardel', 'Silva', '24', 'jardel@hotmail.com', 'Pedreiro', 1500.00), " +
            "(5, 'Renner', 'Almeida', '31', 'renermestre@hotmail.com','Mestre de Obra' , 10000.00), " +
            "(2, 'Caio', 'Castro', '22', 'caio@hotmail.com', 'Cozinheiro', 3000.00), " +
            "(3, 'Pedro', 'Castro', '30', 'pedro@hotmail.com', 'Palhaço', 1000.00), "+
            "(4, 'Joao', 'Maria', '50', 'joao@hotmail.com', 'Porteiro', 1000.00)";

    private static final String sqlInsert2 = "INSERT INTO funcionarios " +
            "(id, nome, sobrenome, idade, email, cargo, salario) VALUES " +
            "(1, 'Jardel', 'Silva', '24', 'jardel@hotmail.com', 'Pedreiro', 1500.00), " +
            "(1, 'Renner', 'Almeida', '31', 'renermestre@hotmail.com','Mestre de Obra' , 10000.00), " +
            "(2, 'Caio', 'Castro', '22', 'caio@hotmail.com', 'Cozinheiro', 3000.00), " +
            "(3, 'Pedro', 'Castro', '30', 'pedro@hotmail.com', 'Palhaço', 1000.00), "+
            "(4, 'Joao', 'Maria', '50', 'joao@hotmail.com', 'Porteiro', 1000.00)";


    //Em seguida, você deve atualizar um dos funcionários com um novo valor em uma
    // de suas colunas e registrar com um objeto de depuração (debug) as informações
    // do funcionário;
    private static final String sqlUpdate = "UPDATE funcionarios SET salario = 4000.00 WHERE id = 2";

    private static final String sqlDelete = "DELETE FROM funcionarios WHERE id = 3";

    private static final String sqlDelete1 = "DELETE FROM FUNCIONARIOS WHERE nome = 'Joao'";

    private static final Logger logger = Logger.getLogger(App.class);

    public static void main(String[] args) throws Exception {

        //Aqui a configuração do Logging
        BasicConfigurator.configure();

        Connection connection = null;

        try {
            connection = getConnection();
            Statement statement = connection.createStatement();
            statement.execute(sqlCreateTable);
            statement.execute(sqlInsert);
            try {
                statement.execute(sqlInsert2);
            } catch (Exception e) {
                logger.error(e);
            }
            statement.execute(sqlUpdate);
            logger.debug("Funcionário id 2 modificado salário para 4000.00");
            statement.execute(sqlDelete);
            logger.info("Excluímos o usuário com o id 3");
            statement.execute(sqlDelete1);
            logger.info("Excluímos o usuário com o nome Joao");
        }

        //Verificar se está ocorrendo o erro: “Unique index or primary key violation”, ocasionado ao tentar inserir dois registros com o mesmo ID. Então devemos tratá-lo como exceção, registar o erro em log e continuar com a execução das demais instruções;
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            if (connection == null)
                return;
            connection.close();


        }


    }

    public static Connection getConnection() throws Exception {
        Class.forName("org.h2.Driver");
        return DriverManager.getConnection("jdbc:h2:tcp://localhost/~/test", "sa", "");
    }



}
