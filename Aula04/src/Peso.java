public class Peso extends Handler{

    @Override
    public void verificar(Artigo artigo) {
        if(artigo.getPeso() >= 1200 && artigo.getPeso() <= 1300){
            this.getSeguinteManipulador().verificar(artigo);
        } else {
            System.out.println("Produto rejeitado no Peso!");
        }
    }
}
