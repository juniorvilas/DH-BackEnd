public class ProcessaArtigo {
    public static void main(String[] args) {
        CheckQuality check = new CheckQuality();
        check.verificar(new Artigo("Feijão",900,1200,"saudável"));
        check.verificar(new Artigo("Feijão",1000,1200,"saudável"));
    }
}
