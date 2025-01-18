package kimtela.api.domain.pessoa;

import jakarta.persistence.*;
import lombok.*;



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
    private String email;
    private Integer idade;
    private String telefone;

    public Pessoa(DadosCadastrarPessoa dadosPessoa) {
        this.nome= dadosPessoa.nome();
        this.cpf = dadosPessoa.cpf();
        this.rg = dadosPessoa.rg();
        this.email = dadosPessoa.email();
        this.idade = dadosPessoa.idade();
        this.telefone = dadosPessoa.telefone();
    }
}
