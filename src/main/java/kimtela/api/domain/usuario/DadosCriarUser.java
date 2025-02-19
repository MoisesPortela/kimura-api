package kimtela.api.domain.usuario;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosCriarUser(
        @NotBlank
        @Email
        String email,
        @NotBlank
        String senha,
        @NotBlank
        String telefone,
        @NotNull
        TipoPerfil tipoPerfil) {

}
