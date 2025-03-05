package kimtela.api.domain.pessoa;

import jakarta.persistence.*;
import kimtela.api.domain.documentos.Documentos;
import kimtela.api.domain.endereco.Endereco;
import kimtela.api.domain.experiencia.ExperienciaProfissional;
import kimtela.api.domain.foto.Foto;
import lombok.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


@Table(name= "pessoa")
@Entity(name = "Pessoa")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Pessoa {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String cpf;
    private String rg;
    private Integer idade;
    private String telefone;
    private Boolean ativo;
    private String orgExped;
    private LocalDate dataNascimento;
    private String formacaoAcademica;
    private String idiomas;
    private String cargoAtual;
    private Boolean incluirDisclaimerLgpd;
    private String indicacao;
    private String nvlCargo;
    private String especialidades;
    private String anotacoes;

    @OneToOne(mappedBy = "pessoa", cascade = CascadeType.ALL, orphanRemoval = true)
    private Foto foto;

    @Embedded
    private Endereco endereco;

    @ElementCollection
    @CollectionTable(name = "exp_prof", joinColumns = @JoinColumn(name = "pessoa_id"))
    private List<ExperienciaProfissional> experiencias = new ArrayList<>();

    @OneToMany(mappedBy = "pessoa", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Documentos> documentos = new ArrayList<Documentos>();

    public Pessoa(DadosCadastrarPessoa dadosPessoa) {
        this.nome= dadosPessoa.nome();
        this.cpf = dadosPessoa.cpf();
        this.rg = dadosPessoa.rg();
        this.idade = dadosPessoa.idade();
        this.telefone = dadosPessoa.telefone();
        this.ativo = true;
        this.endereco= new Endereco(dadosPessoa.endereco());
    }

    public void atualizarPessoa(DadosAtualizarPessoa dadosAtualizarPessoa){
        if (dadosAtualizarPessoa.nome()!=null){
            this.nome= dadosAtualizarPessoa.nome();
        }
        if (dadosAtualizarPessoa.idade()!=null){
            this.idade=dadosAtualizarPessoa.idade();
        }
        if (dadosAtualizarPessoa.telefone()!=null){
            this.telefone= dadosAtualizarPessoa.telefone();
        }
        if(dadosAtualizarPessoa.endereco()!=null){
            this.endereco.atualizarEndereco(dadosAtualizarPessoa.endereco());
        }

    }

    public void excluir() {
        this.ativo=false;
    }
}
