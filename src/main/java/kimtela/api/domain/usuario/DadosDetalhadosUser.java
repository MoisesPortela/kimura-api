package kimtela.api.domain.usuario;

import jakarta.validation.constraints.Email;

public record DadosDetalhadosUser(
        @Email
        String email,
        TipoPerfil tipoPerfil) {

    public DadosDetalhadosUser(Usuario usuario){
        this(usuario.getEmail(), usuario.getTipoPerfil());
    }

    public DadosDetalhadosUser censurarDados(){
        String[] censoredEmailParts = this.email.split("@",2);
        String firstPartEmail = censoredEmailParts[0].replaceAll(".(?=.{3})","*");
        String secondPartEmail = censoredEmailParts[1].replaceAll(".(?<=.{5})","*");
        String censoredEmailComplete = firstPartEmail+"@"+secondPartEmail;
        return new DadosDetalhadosUser(censoredEmailComplete,this.tipoPerfil);
    };
}
