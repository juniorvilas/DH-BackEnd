public class Usuario {
    public static void main(String[] args) {
        GradeFilmesProxy proxy = new GradeFilmesProxy(new GradeFilmes());
        proxy.setIP(new IP(99,23,15,18));

        try{
            System.out.println(proxy.getFilme("Homem Aranha").getLink());
        }
        catch (FilmeNaoHabilitadoException e){
            System.out.println(e);
        }

        try{
            System.out.println(proxy.getFilme("Matrix").getLink());
        }
        catch (FilmeNaoHabilitadoException e){
            System.out.println(e);
        }
    }
}
