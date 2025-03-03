package kimtela.api.domain.pessoa;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import kimtela.api.domain.endereco.DadosEndereco;
import kimtela.api.domain.endereco.Endereco;

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
        String telefone,
        @NotBlank
        @Valid
        DadosEndereco endereco) {

}
