public abstract class Handler {

    protected Handler seguinteManipulador;

    public Handler getSeguinteManipulador() {
        return seguinteManipulador;
    }

    public void setSeguinteManipulador(Handler seguinteManipulador) {
        this.seguinteManipulador = seguinteManipulador;
    }

    public abstract void verificar(Artigo artigo);
}
