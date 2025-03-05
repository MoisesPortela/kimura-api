package kimtela.api.domain.pessoa;


import kimtela.api.domain.documentos.Documentos;
import kimtela.api.domain.endereco.Endereco;
import kimtela.api.domain.experiencia.ExperienciaProfissional;

import java.time.LocalDate;
import java.util.List;

public record DadosDetalhadosPessoa(Long id, String nome, String cpf, String rg, Integer idade, String telefone,
                                    String orgExped, LocalDate dataNascimento, String formacaoAcademica, String idiomas,
                                    String cargoAtual, String indicacao, String nvlCargo, String especialidades, String anotacoes,
                                    Endereco endereco, List<ExperienciaProfissional> experiencias, List<Documentos> docs) {
    public DadosDetalhadosPessoa(Pessoa pessoa){
        this(pessoa.getId(), pessoa.getNome(),
                pessoa.getCpf(), pessoa.getRg(), pessoa.getIdade(), pessoa.getTelefone(), pessoa.getOrgExped(), pessoa.getDataNascimento(),
                pessoa.getFormacaoAcademica(),pessoa.getIdiomas(),pessoa.getCargoAtual(),pessoa.getIndicacao(),
                pessoa.getNvlCargo(),pessoa.getEspecialidades(),pessoa.getAnotacoes(), pessoa.getEndereco(),
                pessoa.getExperiencias(), pessoa.getDocumentos());
    }


}
