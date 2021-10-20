public class Embalagem extends Handler{

    @Override
    public void verificar(Artigo artigo) {
        if((artigo.getEmbalagem().equalsIgnoreCase("saudável")) ||
                (artigo.getEmbalagem().equalsIgnoreCase("quase saudável")) ){
            System.out.println("Produto Aceito!");
        } else {
            System.out.println("Produto rejeitado na Embalagem!");
        }
    }
}
