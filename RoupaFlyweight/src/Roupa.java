public class Roupa {

    //● Tamanho: é uma string.
    //● Tipo: é uma string que descreve o tipo de vestuário. Exemplo: calça.
    //● eNovo: flag (bandeira) para saber se é uma vestimenta nova ou não.
    //● importada: flag (bandeira) para saber se é uma vestimenta nacional ou internacional.
    private String tamanho;
    private String tipo;
    private boolean eNova;
    private boolean importada;

    public Roupa(String tipo) {
        this.tipo = tipo;
    }

    public String getTamanho() {
        return tamanho;
    }

    public void setTamanho(String tamanho) {
        this.tamanho = tamanho;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public boolean iseNova() {
        return eNova;
    }

    public void setNova(boolean eNovo) {
        this.eNova = eNovo;
    }

    public boolean isImportada() {
        return importada;
    }

    public void setImportada(boolean importada) {
        this.importada = importada;
    }

    @Override
    public String toString() {
        return "Roupa{" +"tamanho='" + tamanho + '\'' +", tipo='" + tipo + '\'' +", eNovo=" + eNova +", importada=" + importada +'}';
    }
}





