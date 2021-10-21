public class Main {
    public static void main(String[] args) {
        // ("Free", "Premium").
        Usurario usurario = new Usurario("123456","Premium");
        IServicoDownload servico = new ServicoDownloadProxy();
        servico.baixar(usurario);
    }
}
