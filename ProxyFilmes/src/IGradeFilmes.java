public interface IGradeFilmes {

    Filme getFilme(String nomeFilme) throws FilmeNaoHabilitadoException;
}
