package kimtela.api.domain.documentos;

import jakarta.validation.constraints.NotBlank;

public record DadosDocumento(
        @NotBlank
        String nome,
        @NotBlank
        String tipo,
        @NotBlank
        String caminho
) {
}
