public class Artigo {

    //Atributos
    private String nome;
    private int lote;
    private int peso;
    private String embalagem;

    //Construtor
    public Artigo(String nome, int lote, int peso, String embalagem) {
        this.nome = nome;
        this.lote = lote;
        this.peso = peso;
        this.embalagem = embalagem;
    }

    //GETTER AND SETTER
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getLote() {
        return lote;
    }

    public void setLote(int lote) {
        this.lote = lote;
    }

    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }

    public String getEmbalagem() {
        return embalagem;
    }

    public void setEmbalagem(String embalagem) {
        this.embalagem = embalagem;
    }
}
