package kimtela.api.controller;

import kimtela.api.domain.pessoa.DadosCadastrarPessoa;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pessoas")
public class PessoaController {

    @GetMapping
    public String getPessoas(){
        return "teste controller";
    }

    @PostMapping
    public void postPessoa(@RequestBody DadosCadastrarPessoa dadosPessoa){
        System.out.println(dadosPessoa.nome());
    }
}
