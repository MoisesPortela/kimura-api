package kimtela.api.domain.usuario;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import kimtela.api.domain.adm.Adm;
import kimtela.api.domain.empresa.Empresa;
import kimtela.api.domain.pessoa.Pessoa;

public record DadosAtualizarUser(
        @NotNull
        Long id,
        @Email
        String email,
        String senha,
        TipoPerfil tipoPerfil,
        Pessoa pessoa,
        Empresa empresa,
        Adm adm
        ) {
}
