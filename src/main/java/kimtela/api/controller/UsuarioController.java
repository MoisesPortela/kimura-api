package kimtela.api.controller;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import kimtela.api.domain.adm.Adm;
import kimtela.api.domain.empresa.Empresa;
import kimtela.api.domain.pessoa.Pessoa;
import kimtela.api.domain.usuario.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.ReadOnlyProperty;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping
    @Transactional
    public ResponseEntity criarUsuario(@RequestBody @Valid DadosCriarUser dadosCriarUser){
        String senhaCodificada = passwordEncoder.encode(dadosCriarUser.senha());
        var usuario = new Usuario(dadosCriarUser.email(), senhaCodificada, dadosCriarUser.telefone(), dadosCriarUser.tipoPerfil());
        usuarioRepository.save(usuario);
        return ResponseEntity.ok(new DadosDetalhadosUser(usuario).censurarDados() );
    }

    @PutMapping("/{id}/empresa")
    @Transactional
    public ResponseEntity atualizarUsuarioComEmpresa(@PathVariable Long id, @RequestBody @Valid Empresa empresa){
        var usuario = usuarioRepository.getReferenceById(id);
        usuario.setEmpresa(empresa);
        usuarioRepository.save(usuario);
        return ResponseEntity.ok(new DadosDetalhadosUser(usuario).censurarDados());
    }

    @PutMapping("/{id}/administrador")
    @Transactional
    public ResponseEntity atualizarUsuarioComAdministrador(@PathVariable Long id, @RequestBody @Valid Adm adm){
        var usuario = usuarioRepository.getReferenceById(id);
        usuario.setAdm(adm);
        usuarioRepository.save(usuario);
        return ResponseEntity.ok(new DadosDetalhadosUser(usuario).censurarDados());
    }

    @PutMapping("/{id}/pessoa")
    @Transactional
    public ResponseEntity atualizarUsuarioComPessoa(@PathVariable Long id, @RequestBody @Valid Pessoa pessoa){
        var usuario = usuarioRepository.getReferenceById(id);
        usuario.setPessoa(pessoa);
        usuarioRepository.save(usuario);
        return ResponseEntity.ok(new DadosDetalhadosUser(usuario).censurarDados());
    }

    @GetMapping
    @ReadOnlyProperty
    public ResponseEntity<Page<DadosListagemUser>> listar(@PageableDefault(size = 10, sort = "email") Pageable pageable){
        var page = usuarioRepository.findAllByAtivoTrue(pageable)
                .map(DadosListagemUser::new)
                .map(DadosListagemUser::censurarDados);
        return ResponseEntity.ok(page);
    }
    @GetMapping("/{id}")
    @ReadOnlyProperty
    public ResponseEntity<DadosDetalhadosUser> detalhar(@PathVariable Long id){
        var user = usuarioRepository.getReferenceById(id);
        return ResponseEntity.ok(new DadosDetalhadosUser(user).censurarDados());
    }

    @PutMapping
    @Transactional
    public ResponseEntity atualizar(@RequestBody @Valid DadosAtualizarUser dadosAtualizarUser){
        var user = usuarioRepository.getReferenceById(dadosAtualizarUser.id());
        if(dadosAtualizarUser.senha() != null) {
            String senhaCodificada = passwordEncoder.encode(dadosAtualizarUser.senha());
            user.setSenha(senhaCodificada);
        }
        user.atualizarUser(dadosAtualizarUser,user.getSenha());
        return ResponseEntity.ok(new DadosDetalhadosUser(user));
    }
    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity deletar(@PathVariable @Valid Long id){
        var user = usuarioRepository.getReferenceById(id);
        if (!user.getAtivo()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        user.excluir();
        var excluido = new DadosDetalhadosUser(user);
        return ResponseEntity.ok(excluido);
    }
}