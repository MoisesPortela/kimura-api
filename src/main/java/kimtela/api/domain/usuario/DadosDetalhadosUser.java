package kimtela.api.domain.usuario;

import jakarta.validation.constraints.Email;

public record DadosDetalhadosUser(
        @Email
        String email,
        String telefone,
        TipoPerfil tipoPerfil) {

    public DadosDetalhadosUser(Usuario usuario){
        this(usuario.getEmail(), usuario.getTelefone(), usuario.getTipoPerfil());
    }
}
