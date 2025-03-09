package kimtela.api.controller;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import kimtela.api.domain.pessoa.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.ReadOnlyProperty;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/pessoas")
public class PessoaController {

    @Autowired
    private PessoaRepository pessoaRepository;

    @GetMapping
    @ReadOnlyProperty
    public ResponseEntity<Page<DadosListagemPessoa>> listar(@PageableDefault(size = 10, sort = "nome") Pageable pageable){
        var page = pessoaRepository.findAllByAtivoTrue(pageable).map(DadosListagemPessoa::new);
        return ResponseEntity.ok(page);
    }

    @GetMapping("/{id}")
    @ReadOnlyProperty
    public ResponseEntity detalhar(@PathVariable Long id){
        var pessoa = pessoaRepository.getReferenceById(id);
                return ResponseEntity.ok(new DadosDetalhadosPessoa(pessoa));
    }

    @PostMapping
    @Transactional
    public ResponseEntity cadastrar(@RequestBody @Valid DadosCadastrarPessoa dadosPessoa, UriComponentsBuilder uriComponentsBuilder){
        var pessoa = new Pessoa(dadosPessoa);
        pessoaRepository.save(pessoa);
        var uri= uriComponentsBuilder.path("/pessoas/{id}").buildAndExpand(pessoa.getId()).toUri();
        return ResponseEntity.created(uri).body(new DadosDetalhadosPessoa(pessoa));
    }

    @PutMapping
    @Transactional
    public ResponseEntity atualizar(@RequestBody @Valid DadosAtualizarPessoa dadosAtualizarPessoa){
        var pessoa = pessoaRepository.getReferenceById(dadosAtualizarPessoa.id());
        pessoa.atualizarPessoa(dadosAtualizarPessoa);
        return ResponseEntity.ok(new DadosDetalhadosPessoa(pessoa));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity deletar(@PathVariable @Valid Long id){
        var pessoa = pessoaRepository.getReferenceById(id);
        if (!pessoa.getAtivo()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        pessoa.excluir();
        var excluido = new DadosDetalhadosPessoa(pessoa);
        return ResponseEntity.ok(excluido);
    }

}
