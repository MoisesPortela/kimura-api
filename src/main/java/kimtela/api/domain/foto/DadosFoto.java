package kimtela.api.domain.foto;

import java.time.LocalDate;

public record DadosFoto(
        String nome,
        String legenda,
        LocalDate data,
        String caminho,
        String tamanho,
        String tipo
) {
}