package kimtela.api.domain.pessoa;

import jakarta.persistence.*;
import kimtela.api.domain.documentos.DadosDocumento;
import kimtela.api.domain.documentos.Documentos;
import kimtela.api.domain.endereco.DadosEndereco;
import kimtela.api.domain.endereco.Endereco;
import kimtela.api.domain.experiencia.DadosExpProf;
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

    @OneToMany(mappedBy = "pessoa", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Endereco> endereco = new ArrayList<>();

    @OneToMany(mappedBy = "pessoa",cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ExperienciaProfissional> experiencias = new ArrayList<>();

    @OneToMany(mappedBy = "pessoa", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Documentos> documentos = new ArrayList<>();

    public Pessoa(DadosCadastrarPessoa dadosPessoa) {
        this.nome = dadosPessoa.nome();
        this.cpf = dadosPessoa.cpf();
        this.rg = dadosPessoa.rg();
        this.idade = dadosPessoa.idade();
        this.telefone = dadosPessoa.telefone();
        this.ativo = true;
        this.orgExped = dadosPessoa.orgExped();
        this.dataNascimento = dadosPessoa.dataNascimento();
        this.formacaoAcademica = dadosPessoa.formacaoAcademica();
        this.idiomas = dadosPessoa.idiomas();
        this.cargoAtual = dadosPessoa.cargoAtual();
        this.incluirDisclaimerLgpd = false;
        this.indicacao = dadosPessoa.indicacao();
        this.nvlCargo = dadosPessoa.nvlCargo();
        this.especialidades = dadosPessoa.especialidades();
        this.anotacoes = dadosPessoa.anotacoes();

        if (dadosPessoa.endereco() != null) {
            for (DadosEndereco dadosEndereco : dadosPessoa.endereco()) {
                Endereco endereco = new Endereco(dadosEndereco);
                endereco.setPessoa(this);
                this.endereco.add(endereco);
            }
        }

        if (dadosPessoa.experiencias() != null) {
            for (DadosExpProf dadosExpProf : dadosPessoa.experiencias()) {
                ExperienciaProfissional experiencia = new ExperienciaProfissional(dadosExpProf);
                experiencia.setPessoa(this);
                this.experiencias.add(experiencia);
            }
        }

        if (dadosPessoa.docs() != null) {
            System.out.println("teste");
            for (DadosDocumento dadosDocumento : dadosPessoa.docs()) {
                Documentos doc = new Documentos(dadosDocumento);
                doc.setPessoa(this);
                this.documentos.add(doc);
            }
        }

        if (dadosPessoa.foto() != null) {
            Foto foto = new Foto(dadosPessoa.foto());
            foto.setPessoa(this);
            this.foto = foto;
        }
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
            for (int i = 0; i<dadosAtualizarPessoa.endereco().size();i++) {
                Endereco endereco = this.endereco.get(i);
                DadosEndereco dadosEndereco = dadosAtualizarPessoa.endereco().get(i);
                endereco.atualizarEndereco(dadosEndereco);
            }
        }
        if(dadosAtualizarPessoa.experiencias()!=null){
            for (int i =0;i<this.experiencias.size();i++){
                ExperienciaProfissional experiencia = this.experiencias.get(i);
                DadosExpProf dadosExpProf = dadosAtualizarPessoa.experiencias().get(i);
                experiencia.atualizarExperiencia(dadosExpProf);
            }
        }
        if(dadosAtualizarPessoa.docs()!=null){
            for (int i =0;i<this.documentos.size();i++){
                Documentos doc = this.documentos.get(i);
                DadosDocumento dadosDoc = dadosAtualizarPessoa.docs().get(i);
                doc.atualizarDocumento(dadosDoc);
            }
        }
        if(dadosAtualizarPessoa.foto()!=null){
            this.foto.atualizarFoto(dadosAtualizarPessoa.foto());
        }

    }

    public void excluir() {
        this.ativo=false;
    }
}
