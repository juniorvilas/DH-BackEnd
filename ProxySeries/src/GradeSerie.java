public class GradeSerie implements ISerie{

    @Override
    public String getSerie(String nomeSerie) throws SerieNaoHabilitadaException {
        String link = null;
        switch (nomeSerie) {
            case "The Big Bang":
                link = "www.bigbang.com";
                break;
            case "Breaking Bad":
                link = "www.breaking.com.br";
                break;
            case "What if":
                link = "www.whatif.com.br";
                break;
            case "Falcao":
                link = "www.falcao.com.br";
                break;
            case "Wanda Vision":
                link = "www.vison.com.br";
                break;
            case "Mandalorian":
                link = "www.mandalorian.com.br";
                break;
        }
        return link;
    }
}
