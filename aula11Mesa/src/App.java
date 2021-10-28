import java.sql.*;

public class App {

    private static final String sqlCreateTable = "DROP TABLE IF EXISTS figura; " +
            "CREATE TABLE figura (id INT AUTO_INCREMENT PRIMARY KEY, figura VARCHAR(32), cor VARCHAR(32))";

    private static final String sqlInsert = "INSERT INTO figura (figura, cor) "+
            "VALUES ('Circulo', 'Azul'), ('Circulo', 'Vermelho'), ('Quadrado', 'Amarelo'), "+
            "('Quadrado', 'Preto'), ('Quadrado', 'Laranja')";

    private static final String sqlConsulta = "SELECT * FROM FIGURA WHERE cor = 'Vermelho'";


    public static void main(String[] args) throws Exception {


        Class.forName("org.h2.Driver");
        Connection connection = null;
        try {
            connection = DriverManager.getConnection("jdbc:h2:tcp://localhost/~/test", "sa", "");
            Statement statement = connection.createStatement();
            statement.execute(sqlCreateTable);
            statement.execute(sqlInsert);

            ResultSet rs = statement.executeQuery(sqlConsulta);
            while (rs.next()) {
                System.out.println("----Consulta cor Vermelho: ");
                System.out.println(rs.getInt(1)
                        +" "+ rs.getString(2)
                        +" "+ rs.getString(3));
                System.out.println("-------------------------- ");

            }

            String sqlTodos = "SELECT * FROM figura";
            ResultSet rsTodos = statement.executeQuery(sqlTodos);
            while (rsTodos.next()) {
                System.out.println(rsTodos.getInt(1)
                        +" "+ rsTodos.getString(2)
                        +" "+ rsTodos.getString(3));

            }


        }catch (Exception e){
            e.printStackTrace();
        }

        finally {
            if (connection == null)
                return;

            try {
                connection.close();
            }
            catch (SQLException e) {
                e.printStackTrace();
            }

        }


    }



}
