public class ServicoDownload implements IServicoDownload{

    //Método download oficial, que exibe o download usuario Prémium
    @Override
    public void baixar(Usurario usurario) {
        System.out.println("Download Permitido você é Premium!");
    }
}
