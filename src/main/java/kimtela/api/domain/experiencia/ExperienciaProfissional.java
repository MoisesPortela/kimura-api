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

    public ExperienciaProfissional(DadosExpProf dados) {
        this.dataInicio = dados.dataInicio();
        this.cargo = dados.cargo();
        this.nomeEmpresa = dados.nomeEmpresa();
        this.dataFim = dados.dataFim();
        this.atividades = dados.atividades();
    }
    public void atualizarExperiencia(DadosExpProf dados){
        if(this.nomeEmpresa!=null){
            this.nomeEmpresa= dados.nomeEmpresa();
        }
        if(this.cargo!=null){
            this.cargo= dados.cargo();
        }
        if(this.dataInicio!=null){
            this.dataInicio= dados.dataInicio();
        }
        if(this.dataFim!=null){
            this.dataFim= dados.dataFim();
        }
        if(this.atividades!=null){
            this.atividades= dados.atividades();
        }
    }

}
