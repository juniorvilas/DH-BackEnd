import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class App {

    public static void main(String[] args) {

        List<Contatos> contatosList = new ArrayList<>();

        Contatos contato1 = new Contatos();
        contato1.setNome("Joao");
        contato1.setEmail("joao@gmail.com");
        contato1.setTelefone("74991455455");

        Contatos contato2 = new Contatos();
        contato2.setNome("Pedro");
        contato2.setEmail("pedro@gmail.com");
        contato2.setTelefone("74991454587");

        Contatos contato3 = new Contatos();
        contato3.setNome("Maria");
        contato3.setEmail("maria@gmail.com");
        contato3.setTelefone("74991548798");

        contatosList.add(contato1);
        contatosList.add(contato2);
        contatosList.add(contato3);

        /*Salvar o objeto em um arquivo*/
        FileOutputStream fo = null;

        try {
            fo = new FileOutputStream("OutputFile.txt");
            ObjectOutputStream dos = new ObjectOutputStream(fo);
            dos.writeObject(contatosList);
        }
        catch (FileNotFoundException f){
            System.out.println("ERROS: " + f.getMessage());
        }
        catch (Exception e) {
            System.out.println("ERROS: " + e.getMessage());
        }

        //Recuperação do arquivo

        List<Contatos> contatosList2 = null;
        FileInputStream fi = null;

        try {
            fi = new FileInputStream("OutputFile.txt");
            ObjectInputStream ois = new ObjectInputStream(fi);
            contatosList2 = (ArrayList) ois.readObject();

        }
        catch (FileNotFoundException f){
            System.out.println("ERROS: " + f.getMessage());
        }
        catch (Exception e) {
            System.out.println("ERROS: " + e.getMessage());
        }

    }
}
