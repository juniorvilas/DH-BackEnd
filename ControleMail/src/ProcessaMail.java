public class ProcessaMail {
    public static void main(String[] args) {
        CheckMail check = new CheckMail();
        check.verificar(new Mail("log_junior@hotmail.com","tecnico@colmeia.com","teste"));
        check.verificar(new Mail("log_junior@hotmail.com","gerencia@colmeia.com","teste"));
        check.verificar(new Mail("log_junior@hotmail.com","comercial@colmeia.com","teste"));
        check.verificar(new Mail("log_junior@hotmail.com","teste@colmeia.com","teste"));
        check.verificar(new Mail("log_junior@hotmail.com","teste2@colmeia.com","gerencial"));
    }
}
