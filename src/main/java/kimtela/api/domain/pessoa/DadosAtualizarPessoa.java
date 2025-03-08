package kimtela.api.domain.pessoa;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import kimtela.api.domain.documentos.Documentos;
import kimtela.api.domain.endereco.DadosEndereco;
import kimtela.api.domain.experiencia.DadosExpProf;
import kimtela.api.domain.foto.DadosFoto;

import java.time.LocalDate;
import java.util.List;

public record DadosAtualizarPessoa(
        @NotNull
        Long id,
        String nome,
        @Email
        String email,
        Integer idade,
        String telefone,
        String orgExped,
        LocalDate dataNascimento,
        String formacaoAcademica,
        String idiomas,
        String cargoAtual,
        Boolean incluirDisclaimerLgpd,
        String indicacao,
        String nvlCargo,
        String especialidades,
        String anotacoes,
        DadosEndereco endereco,
        List<DadosExpProf> experiencias,
        List<Documentos> docs,
        DadosFoto foto
) {
}