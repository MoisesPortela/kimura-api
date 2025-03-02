package kimtela.api.domain.usuario;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

public record DadosAtualizarUser(
        @NotNull
        Long id,
        @Email
        String email,
        String senha,
        TipoPerfil tipoPerfil) {
}
