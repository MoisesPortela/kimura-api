package kimtela.api.service;

import kimtela.api.domain.foto.DadosFoto;
import org.springframework.stereotype.Service;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class FileStorageService {

    private final String storageLocation = "G:\\API";

    public String storeFoto(DadosFoto dadosFoto) throws IOException {
        Path storagePath = Paths.get(storageLocation);
        if (!Files.exists(storagePath)) {
            Files.createDirectories(storagePath);
        }

        String fileName = dadosFoto.nome();
        Path filePath = storagePath.resolve(fileName);
        Files.write(filePath, dadosFoto.conteudo());

        return filePath.toString();
    }
}