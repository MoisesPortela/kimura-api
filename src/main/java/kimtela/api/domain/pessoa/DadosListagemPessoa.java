package kimtela.api.domain.pessoa;



public record DadosListagemPessoa(
        Long id, String nome, String cpf, String rg, Integer idade, String telefone
) {

    public DadosListagemPessoa (Pessoa pessoa){
        this(pessoa.getId(), pessoa.getNome(), pessoa.getCpf(), pessoa.getRg(), pessoa.
                getIdade(), pessoa.getTelefone());
    }


}
