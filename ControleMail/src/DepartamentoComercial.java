public class DepartamentoComercial extends Handler{

    @Override
    public void verificar(Mail eMail) {
        if((eMail.getDestino().equalsIgnoreCase("comercial@colmeia.com")) ||
                (eMail.getAssunto().equalsIgnoreCase("comercial")) ){
            System.out.println("Enviado ao comercial");
        }
        else{
            if(this.getSeguinte() != null){
                this.getSeguinte().verificar(eMail);
            }
        }

    }
}
