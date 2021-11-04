import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class App {

    public static void main(String[] args) {

       List<Cachorro> cachorroList = new ArrayList<>();

       Cachorro cachorro1 = new Cachorro();
       cachorro1.setNome("Pluto");
       cachorro1.setIdade(3);

       Cachorro cachorro2 = new Cachorro();
       cachorro2.setNome("Scooby");
       cachorro2.setIdade(1);

        Cachorro cachorro3 = new Cachorro();
        cachorro3.setNome("Lessi");
        cachorro3.setIdade(2);

        cachorroList.add(cachorro1);
        cachorroList.add(cachorro2);
        cachorroList.add(cachorro3);

        /*Salvar o objeto em um arquivo*/
        FileOutputStream fo = null;

        try {
            fo = new FileOutputStream("OutputFile.txt");
            ObjectOutputStream dos = new ObjectOutputStream(fo);
            dos.writeObject(cachorroList);
        }
        catch (FileNotFoundException f){
            System.out.println("ERROS: " + f.getMessage());
        }
        catch (Exception e) {
            System.out.println("ERROS: " + e.getMessage());
        }

        //Recuperação do arquivo

        List<Cachorro> cachorroList2 = null;
        FileInputStream fi = null;

        try {
            fi = new FileInputStream("OutputFile.txt");
            ObjectInputStream ois = new ObjectInputStream(fi);
            cachorroList2 = (ArrayList) ois.readObject();

        }
        catch (FileNotFoundException f){
            System.out.println("ERROS: " + f.getMessage());
        }
        catch (Exception e) {
            System.out.println("ERROS: " + e.getMessage());
        }




    }
}
