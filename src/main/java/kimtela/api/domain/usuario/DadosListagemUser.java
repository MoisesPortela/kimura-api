package kimtela.api.domain.usuario;

public record DadosListagemUser(
        Long id,String email, TipoPerfil tipoPerfil,
        Long pessoaId, String pessoaNome,
        Long empresaId, String empresaNome,
        Long admId, String admNome) {
    public DadosListagemUser (Usuario user) {

        this(user.getId(),user.getEmail(), user.getTipoPerfil(),
        user.getPessoa() != null ? user.getPessoa().getId() : null,
        user.getPessoa() != null ? user.getPessoa().getNome() : null,
        user.getEmpresa() != null ? user.getEmpresa().getId() : null,
        user.getEmpresa() != null ? user.getEmpresa().getNome() : null,
        user.getAdm() != null ? user.getAdm().getId() : null,
        user.getAdm() != null ? user.getAdm().getNome() : null);
    }



    public DadosListagemUser censurarDados(){
        String[] censoredEmailParts = this.email.split("@",2);
        String firstPartEmail = censoredEmailParts[0].replaceAll(".(?=.{3})","*");
        String secondPartEmail = censoredEmailParts[1].replaceAll(".(?<=.{5})","*");
        String censoredEmailComplete = firstPartEmail+"@"+secondPartEmail;
        return new DadosListagemUser(this.id,censoredEmailComplete,this.tipoPerfil,
                this.pessoaId,this.pessoaNome,
                this.empresaId, this.empresaNome,
                this.admId, this.admNome);
    };
}


