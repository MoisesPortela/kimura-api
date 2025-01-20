package kimtela.api.domain.pessoa;


public record DadosListagemPessoa(Long id, String nome, String cpf, String rg, String email, Integer idade, String telefone) {

    public DadosListagemPessoa (Pessoa pessoa){
        this(pessoa.getId(), pessoa.getNome(), pessoa.getCpf(), pessoa.getRg(), pessoa.getEmail(), pessoa.
                getIdade(), pessoa.getTelefone());
    }
}
