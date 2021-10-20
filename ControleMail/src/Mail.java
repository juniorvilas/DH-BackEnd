public class Mail {

    //Atributos
    private String origem;
    private String destino;
    private String assunto;

    //Construtor
    public Mail(String origem, String destino, String assunto) {
        this.origem = origem;
        this.destino = destino;
        this.assunto = assunto;
    }
    //GETTER AND SETTER
    public String getOrigem() {
        return origem;
    }

    public void setOrigem(String origem) {
        this.origem = origem;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public String getAssunto() {
        return assunto;
    }

    public void setAssunto(String assunto) {
        this.assunto = assunto;
    }
}
