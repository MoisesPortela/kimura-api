package kimtela.api.domain.usuario;

import jakarta.validation.constraints.Email;

public record DadosDetalhadosUser(
        @Email
        String email,
        TipoPerfil tipoPerfil,
        Long pessoaId, String pessoaNome,
        Long empresaId, String empresaNome,
        Long admId, String admNome
        ) {

    public DadosDetalhadosUser(Usuario usuario){
        this(usuario.getEmail(), usuario.getTipoPerfil(),
                usuario.getPessoa() != null ? usuario.getPessoa().getId() : null,
                usuario.getPessoa() != null ? usuario.getPessoa().getNome() : null,
                usuario.getEmpresa() != null ? usuario.getEmpresa().getId() : null,
                usuario.getEmpresa() != null ? usuario.getEmpresa().getNome() : null,
                usuario.getAdm() != null ? usuario.getAdm().getId() : null,
                usuario.getAdm() != null ? usuario.getAdm().getNome() : null);
    }

    public DadosDetalhadosUser censurarDados(){
        String[] censoredEmailParts = this.email.split("@",2);
        String firstPartEmail = censoredEmailParts[0].replaceAll(".(?=.{3})","*");
        String secondPartEmail = censoredEmailParts[1].replaceAll(".(?<=.{5})","*");
        String censoredEmailComplete = firstPartEmail+"@"+secondPartEmail;
        return new DadosDetalhadosUser(censoredEmailComplete,this.tipoPerfil,
                this.pessoaId, this.pessoaNome,
                this.empresaId, this.empresaNome,
                this.admId, this.admNome);
    };
}
