package kimtela.api.domain.pessoa;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

public record DadosAtualizarPessoa(
        @NotNull
        Long id,
        String nome,
        @Email
        String email,
        Integer idade,
        String telefone

) {
}
