package kimtela.api.domain.pessoa;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record DadosCadastrarPessoa(
        @NotBlank
        String nome,
        @NotBlank
        String cpf,
        @NotBlank
        String rg,
        @Email
        String email,
        Integer idade,
        @NotBlank
        String telefone) {

}
