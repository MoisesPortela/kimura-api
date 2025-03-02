package kimtela.api.domain.experiencia;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class ExperienciaProfissional {
    private String nomeEmpresa;
    private String cargo;
    private LocalDate dataInicio;
    private LocalDate dataFim;
    private String atividades;
}
