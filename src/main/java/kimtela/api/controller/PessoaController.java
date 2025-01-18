package kimtela.api.controller;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import kimtela.api.domain.pessoa.DadosCadastrarPessoa;
import kimtela.api.domain.pessoa.Pessoa;
import kimtela.api.domain.pessoa.PessoaRepository;
import kimtela.api.domain.pessoa.dadosDetalhadosPessoa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/pessoas")
public class PessoaController {

    @Autowired
    private PessoaRepository pessoaRepository;

    @GetMapping
    public String getPessoas(){

        return "teste controller";
    }

    @PostMapping
    @Transactional
    public ResponseEntity cadastrar(@RequestBody @Valid DadosCadastrarPessoa dadosPessoa, UriComponentsBuilder uriComponentsBuilder){
        var pessoa = new Pessoa(dadosPessoa);
        pessoaRepository.save(pessoa);
        //var uri= uriComponentsBuilder.path("/pessoa/{id}").buildAndExpand(pessoa.getId()).toUri();

        return ResponseEntity.ok().body(pessoa);//created(uri).body(new dadosDetalhadosPessoa(pessoa));
    }
}
