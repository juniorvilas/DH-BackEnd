public class Estagiario extends Vendedor{

    public Estagiario(String nome){
        super.nome = nome;
        super.PONTOS_POR_VENDA = 5;
    }

    @Override
    public int calcularPontos() {
        return this.vendas * PONTOS_POR_VENDA;
    }
}
