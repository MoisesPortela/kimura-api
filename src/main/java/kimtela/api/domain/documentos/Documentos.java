package kimtela.api.domain.documentos;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.*;
import kimtela.api.domain.pessoa.Pessoa;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "Documentos")
@Table(name = "doc")
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Documentos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String tipo;
    private String caminho; // Caminho no servidor

    @Setter
    @ManyToOne
    @JoinColumn(name = "pessoa_id")
    @JsonIgnore
    private Pessoa pessoa;

    public Documentos(DadosDocumento dadosDocumento) {
        this.nome = dadosDocumento.nome();
        this.tipo = dadosDocumento.tipo();
        this.caminho = dadosDocumento.caminho();
    }

    public void atualizarDocumento(DadosDocumento dadosDocumento) {
        if (dadosDocumento.nome() != null) {
            this.nome = dadosDocumento.nome();
        }
        if (dadosDocumento.tipo() != null) {
            this.tipo = dadosDocumento.tipo();
        }
        if (dadosDocumento.caminho() != null) {
            this.caminho = dadosDocumento.caminho();
        }
    }
}

