package kimtela.api.domain.experiencia;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import kimtela.api.domain.pessoa.Pessoa;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Table(name = "experiencia")
@Entity(name = "Experiencia")
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ExperienciaProfissional {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String cargo;
    private LocalDate dataInicio;
    private LocalDate dataFim;
    private String atividades;

    @Setter
    @ManyToOne
    @JoinColumn(name = "pessoa_id")
    @JsonIgnore
    private Pessoa pessoa;

    public ExperienciaProfissional(DadosExpProf dados) {
        this.dataInicio = dados.dataInicio();
        this.cargo = dados.cargo();
        this.nome = dados.nome();
        this.dataFim = dados.dataFim();
        this.atividades = dados.atividades();
    }
    public void atualizarExperiencia(DadosExpProf dados){
        if(dados.nome()!=null){
            this.nome= dados.nome();
        }
        if(dados.cargo()!=null){
            this.cargo= dados.cargo();
        }
        if(dados.dataInicio()!=null){
            this.dataInicio= dados.dataInicio();
        }
        if(dados.dataFim()!=null){
            this.dataFim= dados.dataFim();
        }
        if(dados.atividades()!=null){
            this.atividades= dados.atividades();
        }
    }

}
