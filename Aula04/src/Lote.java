public class Lote extends Handler{


    @Override
    public void verificar(Artigo artigo) {
        if(artigo.getLote() >= 1000 && artigo.getLote() <= 2000){
           this.getSeguinteManipulador().verificar(artigo);
        } else {
            System.out.println("Produto rejeitado no Lote!");
        }
    }
}
