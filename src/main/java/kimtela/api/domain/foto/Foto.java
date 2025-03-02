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
}

