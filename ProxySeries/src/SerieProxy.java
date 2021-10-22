import com.sun.source.tree.BreakTree;

public class SerieProxy implements ISerie{

    private GradeSerie gradeSerie;
    private int qtdViews = 0;


    //Construtor
    public SerieProxy(GradeSerie gradeSerie){
        this.setGradeSerie(gradeSerie);
    }

    public void setGradeSerie(GradeSerie gradeSerie){
        this.gradeSerie = gradeSerie;
    }

    @Override
    public String getSerie(String nomeSerie) throws SerieNaoHabilitadaException {
        String link = gradeSerie.getSerie(nomeSerie);
        if(qtdViews < 5){
            qtdViews++;
            System.out.println(qtdViews);
            return link;

        } else {
            throw new SerieNaoHabilitadaException("Limite de vizualização excedido no total de "+ qtdViews + ", você não pode ver " + nomeSerie);
        }
    }


}
