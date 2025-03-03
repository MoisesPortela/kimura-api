package kimtela.api.domain.experiencia;

import jakarta.validation.constraints.NotBlank;

import java.time.LocalDate;

public record DadosExpProf(
        @NotBlank
         String nomeEmpresa,
        @NotBlank
         String cargo,
        @NotBlank
         LocalDate dataInicio,
         LocalDate dataFim,
        @NotBlank
         String atividades
) {
}
