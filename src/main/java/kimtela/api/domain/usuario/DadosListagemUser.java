package kimtela.api.domain.usuario;

public record DadosListagemUser(String email, TipoPerfil tipoPerfil) {
    public DadosListagemUser (Usuario user) {
        this(user.getEmail(), user.getTipoPerfil());
    }
}
