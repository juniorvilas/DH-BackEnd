public class CheckMail {
    //Classe para unir os elos

    Handler initial;

    public CheckMail(){
        this.initial = new DepartamentoGerencial();
        Handler tecnico = new DepartamentoTecnico();
        Handler comercial = new DepartamentoComercial();
        Handler spam = new HandlerSpam();

        initial.setSeguinte(tecnico);
        tecnico.setSeguinte(comercial);
        comercial.setSeguinte(spam);
    }

    public void verificar(Mail eMail){
        initial.verificar(eMail);
    }

}
