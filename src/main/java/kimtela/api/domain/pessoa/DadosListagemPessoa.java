package kimtela.api.domain.pessoa;



public record DadosListagemPessoa(
        Long id, String nome, String cpf, String rg, Integer idade, String telefone
) {

    public DadosListagemPessoa (Pessoa pessoa){
        this(pessoa.getId(), pessoa.getNome(), pessoa.getCpf(), pessoa.getRg(), pessoa.
                getIdade(), pessoa.getTelefone());
    }
    public DadosListagemPessoa censurarDados() {
        String censoredCpf = this.cpf.replaceAll("\\d{3}\\.\\d{3}\\.\\d{3}-(\\d{2})", "***.***.***-$1");
        String censoredRg = this.rg.replaceAll(".", "*");
        String censoredTelefone = this.telefone.replaceAll("\\d(?=\\d{2})", "*");
        return new DadosListagemPessoa(
                this.id,
                this.nome,
                censoredCpf,
                censoredRg,
                this.idade,
                censoredTelefone
        );
    }
}
