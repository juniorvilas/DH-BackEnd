public class Serie {

    //Atributos
    private String nome;
    private String link;

    //Construtor
    public Serie(String nome, String link) {
        this.nome = nome;
        this.link = link;
    }

    //Getter and Setter

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
}
