package kimtela.api.domain.pessoa;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import kimtela.api.domain.documentos.Documentos;
import kimtela.api.domain.endereco.DadosEndereco;
import kimtela.api.domain.endereco.Endereco;
import kimtela.api.domain.experiencia.DadosExpProf;
import kimtela.api.domain.experiencia.ExperienciaProfissional;

import java.time.LocalDate;
import java.util.List;

public record DadosCadastrarPessoa(
        @NotBlank
        String nome,
        @NotBlank
        String cpf,
        @NotBlank
        String rg,
        Integer idade,
        @NotBlank
        String telefone,
        String orgExped,
        LocalDate dataNascimento,
        String formacaoAcademica,
        String idiomas,
        String cargoAtual,
        String indicacao,
        String nvlCargo,
        String especialidades,
        String anotacoes,
        @NotBlank
        @Valid
        DadosEndereco endereco,
        List<DadosExpProf> experiencias,
        List<Documentos> docs
        ) {

}
