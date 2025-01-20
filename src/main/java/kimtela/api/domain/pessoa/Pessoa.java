package kimtela.api.domain.pessoa;

import jakarta.persistence.*;
import kimtela.api.controller.DadosAtualizarPessoa;
import lombok.*;



@Table(name= "pessoas")
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
    private String email;
    private Integer idade;
    private String telefone;
    private Boolean ativo;

    public Pessoa(DadosCadastrarPessoa dadosPessoa) {
        this.nome= dadosPessoa.nome();
        this.cpf = dadosPessoa.cpf();
        this.rg = dadosPessoa.rg();
        this.email = dadosPessoa.email();
        this.idade = dadosPessoa.idade();
        this.telefone = dadosPessoa.telefone();
        this.ativo = true;
    }

    public void atualizarPessoa(DadosAtualizarPessoa dadosAtualizarPessoa){
        if (dadosAtualizarPessoa.nome()!=null){
            this.nome= dadosAtualizarPessoa.nome();
        }
        if (dadosAtualizarPessoa.email()!=null){
            this.email= dadosAtualizarPessoa.email();
        }
        if (dadosAtualizarPessoa.idade()!=null){
            this.idade=dadosAtualizarPessoa.idade();
        }
        if (dadosAtualizarPessoa.telefone()!=null){
            this.telefone= dadosAtualizarPessoa.telefone();
        }

    }

    public void excluir() {
        this.ativo=false;
    }
}
