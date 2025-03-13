package kimtela.api.domain.pessoa;


import kimtela.api.domain.documentos.Documentos;
import kimtela.api.domain.endereco.Endereco;
import kimtela.api.domain.experiencia.ExperienciaProfissional;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

public record DadosDetalhadosPessoa(
        Long id, String nome, String cpf, String rg, Integer idade, String telefone,
        String orgExped, String dataNascimento, String formacaoAcademica, String idiomas,
        String cargoAtual, String indicacao, String nvlCargo, String especialidades, String anotacoes,
        List<Endereco> endereco, List<ExperienciaProfissional> experiencias, List<Documentos> docs
) {
    public DadosDetalhadosPessoa(Pessoa pessoa){
        this(pessoa.getId(), pessoa.getNome(),
                pessoa.getCpf(), pessoa.getRg(), pessoa.getIdade(), pessoa.getTelefone(), pessoa.getOrgExped(),
                pessoa.getDataNascimento().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")),
                pessoa.getFormacaoAcademica(),pessoa.getIdiomas(),pessoa.getCargoAtual(),pessoa.getIndicacao(),
                pessoa.getNvlCargo(),pessoa.getEspecialidades(),pessoa.getAnotacoes(), pessoa.getEndereco(),
                pessoa.getExperiencias(), pessoa.getDocumentos());
    }
    public DadosDetalhadosPessoa censurarDados() {
        String censoredCpf = this.cpf.replaceAll("\\d{3}\\.\\d{3}\\.\\d{3}-(\\d{2})", "***.***.***-$1");
        String censoredRg = this.rg.replaceAll(".", "*");
        String censoredTelefone = this.telefone.replaceAll("\\d(?=\\d{2})", "*");
        String censoredDataNascimento = this.dataNascimento
                .replaceAll("\\d{2}/\\d{2}/(\\d{4})","**/**/$1");
        List<Endereco> censoredEnderecos = this.endereco.stream()
                .map(endereco -> new Endereco(
                        endereco.getId(),
                        endereco.getTipoEndereco(),
                        "*****-***",
                        "**********",
                        "**********",
                        "******",
                        endereco.getLocalidade(),
                        endereco.getUf(),
                        endereco.getPessoa()))
                .collect(Collectors.toList());

        return new DadosDetalhadosPessoa(
                this.id,
                this.nome,
                censoredCpf,
                censoredRg,
                this.idade,
                censoredTelefone,
                this.orgExped,
                censoredDataNascimento, // Keep the original date
                this.formacaoAcademica,
                this.idiomas,
                this.cargoAtual,
                this.indicacao,
                this.nvlCargo,
                this.especialidades,
                this.anotacoes,
                censoredEnderecos,
                this.experiencias,
                this.docs
        );
    }
}