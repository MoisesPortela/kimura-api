package kimtela.api.domain.pessoa;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import kimtela.api.domain.documentos.DadosDocumento;
import kimtela.api.domain.documentos.Documentos;
import kimtela.api.domain.endereco.DadosEndereco;
import kimtela.api.domain.endereco.Endereco;
import kimtela.api.domain.experiencia.DadosExpProf;
import kimtela.api.domain.experiencia.ExperienciaProfissional;
import kimtela.api.domain.foto.DadosFoto;

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
        @NotEmpty
        @Valid
        List<DadosEndereco> endereco,
        @NotEmpty
        @Valid
        List<DadosExpProf> experiencias,
        @NotEmpty
        @Valid
        List<DadosDocumento> docs,
        DadosFoto foto
        ) {

}
