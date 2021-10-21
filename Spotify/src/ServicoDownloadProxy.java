public class ServicoDownloadProxy implements IServicoDownload{


    //Proxy que controla se o usuraio é premium para realizar download
    @Override
    public void baixar(Usurario usurario) {
        if(verificarUsuario(usurario.getTipo())) {
            ServicoDownload servico = new ServicoDownload();
            servico.baixar(usurario);
        } else {
            System.out.println("Sua conta é Free não pode baixar, assine Premium!");
        }
    }

    // ("Free", "Premium").
    public boolean verificarUsuario(String tipo){
        return tipo.equalsIgnoreCase("Premium") ? true : false;

    }
}
