public class Supermercado {
    public static void main(String[] args) {
        //Instanciando o objeto facade da classe FacadeDesconto
        FacadeDesconto facade = new FacadeDesconto();
        Cartao cartao = new Cartao("123456789","Star Bank");
        Produto produto = new Produto("Feijao","Lata");
        System.out.println("O valor do desconto será: " + facade.desconto(cartao,produto,15));
    }
}
