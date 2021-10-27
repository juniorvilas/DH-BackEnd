import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;


public class Main {

    private static final Logger logger = Logger.getLogger(Main.class);

    public static void main(String[] args) {

        BasicConfigurator.configure();
        //-----------------------------------------------------------------
        Aplicacao lista = new Aplicacao(1,5,6,7,8,6);
        Aplicacao lista2 = new Aplicacao(5,5,5,5,5,5,5,5,5,5,5);
        Aplicacao lista3 = new Aplicacao();

        try {
            lista.verifica();
        } catch (Exception e) {
            logger.error(e.getMessage());
        }

        try {
            lista2.verifica();
        } catch (Exception e) {
            logger.error(e.getMessage());
        }

        try {
            lista3.verifica();
        } catch (Exception e) {
            logger.error(e.getMessage());
        }



    }

}
