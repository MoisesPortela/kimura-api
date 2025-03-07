package kimtela.api.domain.endereco;

import jakarta.persistence.Embeddable;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name= "endereco")
@Entity(name = "Endereco")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class Endereco {
    private TipoEndereco tipoEndereco;
    private String cep;
    private String logradouro;
    private String complemento;
    private String bairro;
    private String localidade;
    private String uf;

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
