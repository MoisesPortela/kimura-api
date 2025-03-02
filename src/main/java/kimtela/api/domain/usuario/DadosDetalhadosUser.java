package kimtela.api.domain.usuario;

import jakarta.validation.constraints.Email;

public record DadosDetalhadosUser(
        @Email
        String email,
        TipoPerfil tipoPerfil) {

    public DadosDetalhadosUser(Usuario usuario){
        this(usuario.getEmail(), usuario.getTipoPerfil());
    }
}
