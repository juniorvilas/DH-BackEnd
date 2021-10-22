public class UsuraioMain {
    public static void main(String[] args) {
        SerieProxy proxy = new SerieProxy(new GradeSerie());

        try{
            System.out.println(proxy.getSerie("The Big Bang"));
        }
        catch (SerieNaoHabilitadaException e){
            System.out.println(e);
        }

        try{
            System.out.println(proxy.getSerie("Breaking Bad"));
        }
        catch (SerieNaoHabilitadaException e){
            System.out.println(e);
        }
        try{
            System.out.println(proxy.getSerie("What if"));
        }
        catch (SerieNaoHabilitadaException e){
            System.out.println(e);
        }
        try{
            System.out.println(proxy.getSerie("Falcao"));
        }
        catch (SerieNaoHabilitadaException e){
            System.out.println(e);
        }
        try{
            System.out.println(proxy.getSerie("Wanda Vision"));
        }
        catch (SerieNaoHabilitadaException e){
            System.out.println(e);
        }
        try{
            System.out.println(proxy.getSerie("Mandalorian"));
        }
        catch (SerieNaoHabilitadaException e){
            System.out.println(e);
        }



    }
}
