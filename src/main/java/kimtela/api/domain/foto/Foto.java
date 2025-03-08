package kimtela.api.domain.foto;

import jakarta.persistence.Entity;
import jakarta.persistence.*;
import kimtela.api.domain.pessoa.Pessoa;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity(name = "Foto")
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Foto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String legenda;
    private LocalDate data;
    private String caminhoArquivo;

    @OneToOne
    @JoinColumn(name = "pessoa_id")
    private Pessoa pessoa;
    public Foto(DadosFoto dadosFoto) {
        this.nome = dadosFoto.nome();
        this.legenda = dadosFoto.legenda();
        this.data = dadosFoto.data();
        this.caminhoArquivo=dadosFoto.caminho();
    }

    public void atualizarFoto(DadosFoto dadosFoto) {
        if (dadosFoto.nome() != null) {
            this.nome = dadosFoto.nome();
        }
        if (dadosFoto.legenda() != null) {
            this.legenda = dadosFoto.legenda();
        }
        if (dadosFoto.data() != null) {
            this.data = dadosFoto.data();
        }
        if (dadosFoto.caminho() != null) {
            this.caminhoArquivo = dadosFoto.caminho();
        }
    }
}

