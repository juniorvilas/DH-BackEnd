
public class Usurario {

    //Os usuários possuem um identificador
    // e uma string com o tipo de usuário ("Free", "Premium").
    private String id;
    private String tipo;

    //Contrutor
    public Usurario(String id, String tipo) {
        this.id = id;
        this.tipo = tipo;
    }

    //Getter and Setter
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
