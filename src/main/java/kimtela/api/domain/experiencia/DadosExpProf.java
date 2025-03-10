package kimtela.api.domain.experiencia;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record DadosExpProf(
        @NotBlank
         String nome,
        @NotBlank
         String cargo,
        @NotNull
         LocalDate dataInicio,
         LocalDate dataFim,
        @NotBlank
         String atividades
) {
}
