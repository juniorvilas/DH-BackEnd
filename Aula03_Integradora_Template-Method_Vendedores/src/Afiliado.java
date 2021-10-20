public class Afiliado extends Vendedor{

    public Afiliado(String nome) {
        super(nome, "afiliado");
    }

    @Override
    public void vender() {
        int pontos = this.getPontos();
        pontos += 15;
        setPontos(pontos);
    }
}
