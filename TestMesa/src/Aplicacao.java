import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;



public class Aplicacao {

    private static final Logger logger = Logger.getLogger(Aplicacao.class);

    private List<Integer> listaInteiros = new ArrayList<>();



    public Aplicacao(Integer ...inteiros) {
        for(int i =0; i < inteiros.length; i++){
            listaInteiros.add(inteiros[i]);
        }

    }

    public double media() {

        double media = 0;
        for(int i =0; i < listaInteiros.size(); i++){
            media = media + listaInteiros.get(i);
        }

        return media / listaInteiros.size();

    }

    public void verifica() throws  Exception{
        if(listaInteiros.size() > 5 && listaInteiros.size() < 10) {
            logger.info("[ListaMedia: "+media()+"]"+" O comprimento da lista é maior que 5");
        }
        if(listaInteiros.size() > 10) {
            logger.info("[ListaMedia: "+media()+"]"+" O comprimento da lista é maior que 10");
        }
        if (listaInteiros.size() == 0) {
            throw new Exception("A lista é igual a zero!");
        }
    }



}


//Quando a lista tiver mais de 5 itens;
//+ Quando a lista tiver mais de 10 itens;
//+ A média;
//+ Gerar um erro se a lista não tiver elementos e gere o log.
//[2021-07-18 18:15:11] [ INFO ] [ListaMedia:16] O comprimento da lista é maior que 5
//[2021-07-18 18:15:11] [ INFO ] [ListaMedia:16] O comprimento da lista é maior que 5
//1
//[2021-07-18 18:15:11] [ INFO ] [ListaMedia:19] O comprimento da lista é maior que 10
//[2021-07-18 18:15:11] [ ERROR] [Test:24] A lista é igual a zero