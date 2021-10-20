public class Estagiario extends Vendedor {

    public Estagiario(String nome) {
        super(nome,"estagiário");
    }

    @Override
    public void vender() {
        int pontos = this.getPontos();
        pontos += 5;
        setPontos(pontos);
    }

    @Override
    public void mostrarCategoria() {
        String categoria = this.getPontos() < 50 ? "novato" : "experiente";
        System.out.printf("%s tem um total de %d pontos e categoriza como %s %s \n", this.getNome(), this.getPontos(), this.getTipo(), categoria);
    }
}
