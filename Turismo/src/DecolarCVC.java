public class DecolarCVC {
    public static void main(String[] args) {

        //Criando o primeiro cliente (Instância do primeiro cliente)
        ICheckFacade cliente1 = new CheckFacade();
        //Solicitar a busca de voos e hoteis do primeiro cliente
        cliente1.buscar("19/10/2021","10/12/2021","São Paulo","Salvador");
    }
}
