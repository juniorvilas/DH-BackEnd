public class GradeFilmesProxy implements IGradeFilmes{

    private GradeFilmes grade;
    private IP ip;

    //Metodo para setar o ip
    public void setIP(IP ip){
        this.ip = ip;
    }

    public IP getIP(){
        return ip;
    }

    //Contrutor
    public GradeFilmesProxy(GradeFilmes grade){
        this.setGrade(grade);
    }

    public void setGrade(GradeFilmes grade){
        this.grade = grade;
    }


    @Override
    public Filme getFilme(String nomeFilme) throws FilmeNaoHabilitadoException {
        Filme filme = grade.getFilme(nomeFilme);
        if(! (getIP().getPais().equalsIgnoreCase(filme.getPais()))){
            throw new FilmeNaoHabilitadoException(nomeFilme+ " não disponivel em "+getIP().getPais());
        }
        return filme;
    }

}
