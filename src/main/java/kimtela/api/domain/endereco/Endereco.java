package kimtela.api.domain.endereco;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import kimtela.api.domain.pessoa.Pessoa;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name= "endereco")
@Entity(name = "Endereco")
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Endereco {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Enumerated(EnumType.STRING)
    private TipoEndereco tipoEndereco;
    private String cep;
    private String logradouro;
    private String complemento;
    private String bairro;
    private String localidade;
    private String uf;

    @Setter
    @ManyToOne
    @JoinColumn(name = "pessoa_id")
    @JsonIgnore
    private Pessoa pessoa;

    public Endereco(DadosEndereco dadosEndereco){
        this.tipoEndereco = dadosEndereco.tipoEndereco();
        this.cep = dadosEndereco.cep();
        this.logradouro = dadosEndereco.logradouro();
        this.complemento = dadosEndereco.complemento();
        this.bairro = dadosEndereco.bairro();
        this.localidade = dadosEndereco.localidade();
        this.uf=dadosEndereco.uf();
    }
    public void atualizarEndereco(DadosEndereco dados) {
        if(dados.tipoEndereco()!=null){
            this.tipoEndereco=dados.tipoEndereco();
        }
        if (dados.logradouro() != null) {
            this.logradouro = dados.logradouro();
        }
        if (dados.bairro() != null) {
            this.bairro = dados.bairro();
        }
        if (dados.localidade()!=null){
            this.localidade=dados.localidade();
        }
        if (dados.cep() != null) {
            this.cep = dados.cep();
        }
        if (dados.uf() != null) {
            this.uf = dados.uf();
        }
        if (dados.complemento() != null) {
            this.complemento = dados.complemento();
        }
    }

}
