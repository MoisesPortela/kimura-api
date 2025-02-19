package kimtela.api.domain.usuario;

import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import kimtela.api.domain.pessoa.DadosAtualizarPessoa;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Table(name= "usuarios")
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
    private String telefone;
    @Enumerated(EnumType.STRING)
    private TipoPerfil tipoPerfil;
    private Boolean ativo = true;

    public Usuario(@Valid DadosCriarUser dadosCriarUser) {
        this.email = dadosCriarUser.email();
        this.senha = dadosCriarUser.senha();
        this.telefone = dadosCriarUser.telefone();
        this.tipoPerfil = dadosCriarUser.tipoPerfil();
        this.ativo=true;
    }

    public Usuario(@NotBlank @Email String email, String senhaCodificada, @NotBlank String telefone, @NotNull TipoPerfil tipoPerfil) {
        this.email = email;
        this.senha = senhaCodificada;
        this.telefone = telefone;
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
        if (dadosAtualizarUser.telefone()!=null){
            this.telefone= dadosAtualizarUser.telefone();
        }

    }

    public void excluir() {
        this.ativo=false;
    }

}
