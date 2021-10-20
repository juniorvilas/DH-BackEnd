public class DepartamentoTecnico extends Handler{

    @Override
    public void verificar(Mail eMail) {
        if((eMail.getDestino().equalsIgnoreCase("tecnico@colmeia.com")) ||
                (eMail.getAssunto().equalsIgnoreCase("tecnico")) ){
            System.out.println("Enviado ao Departamento Técnico");
        }
        else{
            if(this.getSeguinte() != null){
                this.getSeguinte().verificar(eMail);
            }
        }

    }
}
