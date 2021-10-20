public abstract class Vendedor {

    private String nome;
    private int pontos;
    private String tipo;
    private String categoria;

    public Vendedor(String nome, String tipo) {
        this.nome = nome;
        this.pontos = 0;
        this.tipo = tipo;
        this.categoria = "novato";
    }

    public abstract void vender();

    public void mostrarCategoria() {
        recategorizar();

        System.out.printf("%s tem um total de %d pontos e categoriza como %s %s\n\n", this.getNome(), this.getPontos(), this.getTipo(), this.getCategoria());
    }

    public void recategorizar() {
        if(this.getPontos() < 20) {
            categoria = "novato";
        } else if (this.getPontos() <= 30) {
            categoria = "aprendiz";
        } else if (this.getPontos() <= 40) {
            categoria = "bom";
        } else {
            categoria = "mestre";
        }

        setCategoria(categoria);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getPontos() {
        return pontos;
    }

    public void setPontos(int pontos) {
        this.pontos = pontos;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
