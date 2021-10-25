public class Computer {

    private int ram;
    private int disco;
    private static int contador;


    //Construtor
    public Computer(int ram, int disco) {
        super();
        this.ram = ram;
        this.disco = disco;
        contador++;
        System.out.println("Contador: "+ contador);
    }

    //Getter and Setter


    public int getRam() {
        return ram;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }

    public int getDisco() {
        return disco;
    }

    public void setDisco(int disco) {
        this.disco = disco;
    }

    public static int getContador() {
        return contador;
    }

    public static void setContador(int contador) {
        Computer.contador = contador;
    }

    //metodo toString


    @Override
    public String toString() {
        return "Computer{" + "ram= " + ram + ", disco= " + disco + '}';
    }
}
