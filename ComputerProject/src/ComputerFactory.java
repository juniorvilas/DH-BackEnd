import java.util.HashMap;
import java.util.Map;

public class ComputerFactory {

    private static Map<String, Computer> macFlyweight = new HashMap<>();


    //Escopo local
    public Computer getComputer(int ram, int disco){
        String id = "id: " + ram + ":" + disco;
        System.out.println(id);

        //Se macFlyweight não tiver id então faça
        if(!macFlyweight.containsKey(id)) {
            macFlyweight.put(id, new Computer(ram, disco));
            System.out.println("PC criado");
            return macFlyweight.get(id);
        }
        //Se macFlyweight tiver id então faça
        System.out.println("PC Obtido");

        return macFlyweight.get(id);
    }
}
