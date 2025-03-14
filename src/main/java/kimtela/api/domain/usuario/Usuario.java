package kimtela.api.domain.usuario;

import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import kimtela.api.domain.adm.Adm;
import kimtela.api.domain.empresa.Empresa;
import kimtela.api.domain.pessoa.Pessoa;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Table(name= "usuario")
@Entity(name = "Usuario")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Usuario implements UserDetails {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String email;
    @Setter
    private String senha;
    @Enumerated(EnumType.STRING)
    private TipoPerfil tipoPerfil;
    private Boolean ativo = true;
    @OneToOne
    @JoinColumn(name = "pessoa_id", unique = true, nullable = true)
    @Setter
    private Pessoa pessoa;

    @OneToOne
    @JoinColumn(name = "empresa_id", unique = true, nullable = true)
    private Empresa empresa;

    @OneToOne
    @JoinColumn(name = "adm_id", unique = true, nullable = true)
    private Adm adm;

    public Usuario(@Valid DadosCriarUser dadosCriarUser) {
        this.email = dadosCriarUser.email();
        this.senha = dadosCriarUser.senha();
        this.tipoPerfil = dadosCriarUser.tipoPerfil();
        this.ativo=true;
        this.pessoa= dadosCriarUser.pessoa();
        this.adm= dadosCriarUser.adm();
        this.empresa= dadosCriarUser.empresa();
    }

    public Usuario(@NotBlank @Email String email, String senhaCodificada, @NotBlank String telefone, @NotNull TipoPerfil tipoPerfil ) {
        this.email = email;
        this.senha = senhaCodificada;
        this.tipoPerfil = tipoPerfil;
        this.ativo=true;
    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(this.tipoPerfil.toString()));
    }

    @Override
    public String getPassword() {
        return senha;
    }

    @Override
    public String getUsername() {
        return email;
    }

    public void atualizarUser(DadosAtualizarUser dadosAtualizarUser, String senha){
        if(dadosAtualizarUser.email()!=null){
            this.email = dadosAtualizarUser.email();
        }
        if (dadosAtualizarUser.senha()!=null){
            this.senha= senha;
        }
        if (dadosAtualizarUser.tipoPerfil()!=null){
            this.tipoPerfil= dadosAtualizarUser.tipoPerfil();
        }

    }

    public void excluir() {
        this.ativo=false;
    }


}
