package kimtela.api.domain.usuario;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import kimtela.api.domain.adm.Adm;
import kimtela.api.domain.empresa.Empresa;
import kimtela.api.domain.pessoa.Pessoa;

public record DadosCriarUser(
        @NotBlank
        @Email
        String email,
        @NotBlank
        String senha,
        @NotBlank
        String telefone,
        @NotNull
        TipoPerfil tipoPerfil,
        Pessoa pessoa,
        Adm adm,
        Empresa empresa
) {

}
