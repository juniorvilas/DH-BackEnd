public class Funcionario extends Vendedor {

    private int anos;

    public Funcionario(String nome) {
        super(nome, "funcionário");
        this.anos = 0;
    }

    public int getAnos() {
        return anos;
    }

    public void setAnos(int anos) {
        this.anos = anos;
    }

    public void addAnos() {
        anos++;
    }

    @Override
    public void vender() {
        int pontos = this.getPontos();
        pontos += 5 + (anos * 5);
        setPontos(pontos);
    }

    public void obterAfiliado() {
        int pontos = this.getPontos();
        pontos += 10;
        setPontos(pontos);
    }
}
