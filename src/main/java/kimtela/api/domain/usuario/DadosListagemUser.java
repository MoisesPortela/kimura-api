package kimtela.api.domain.usuario;

public record DadosListagemUser(Long id,String email, TipoPerfil tipoPerfil) {
    public DadosListagemUser (Usuario user) {
        this(user.getId(),user.getEmail(), user.getTipoPerfil());
    }



    public DadosListagemUser censurarDados(){
        String[] censoredEmailParts = this.email.split("@",2);
        String firstPartEmail = censoredEmailParts[0].replaceAll(".(?=.{3})","*");
        String secondPartEmail = censoredEmailParts[1].replaceAll(".(?<=.{5})","*");
        String censoredEmailComplete = firstPartEmail+"@"+secondPartEmail;
        return new DadosListagemUser(this.id,censoredEmailComplete,this.tipoPerfil);
    };
}


