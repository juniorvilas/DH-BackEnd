
//validação que usa propriedades de subclasse apenas!!
//Classe abstrata Vendedor - aqui vai o Template Method
public abstract class Vendedor {
    protected String nome;
    protected int vendas = 0;
    protected int PONTOS_POR_VENDA;
    protected String tipo;

    public void vender(int qtdVendas){
        this.vendas += qtdVendas;
       // System.out.println(this.nome +" realizou "+qtdVendas + " vendas.");
    }

    public void definir(String tipo){
        this.tipo = tipo;
    }

    /*Método que calcula os pontos do Vendedor de acordo com seus aspectos a serem considerados*/
    public abstract int calcularPontos();

    /*TEMPLATE METHOD - recebe o total de pontos calculados a partir da subclasse e valida cada item para retornar a categoria*/
    public String mostrarCategoria(){
        int pontosDoVendedor = calcularPontos();

        return this.nome + " tem um total de " + pontosDoVendedor + " pontos e categoriza como " + getNomeCategoria(pontosDoVendedor) ;
    }

    /*Recebe os pontos, e devolve uma categorização*/
    private String getNomeCategoria(int pontosVendedor){
        if(this.tipo != null && this.tipo.compareTo("Estagiario") == 0){
            if(pontosVendedor < 50){
                return "estagiário novato";
            }else {
                return "estagiário experiente";
            }
        }else {
            if(pontosVendedor < 20){
                return "vendedor novato";
            }else if( pontosVendedor < 31){
                return "vendedor aprendiz";
            }else if( pontosVendedor < 41){
                return "vendedor bom";
            }else{
                return "vendedor mestre";
            }
        }
    }
}