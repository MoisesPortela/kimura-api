package kimtela.api.controller;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
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
        return ResponseEntity.ok(usuario);
    }


    @GetMapping
    @ReadOnlyProperty
    public ResponseEntity<Page<DadosListagemUser>> listar(@PageableDefault(size = 10, sort = "email") Pageable pageable){
        var page = usuarioRepository.findAllByAtivoTrue(pageable).map(DadosListagemUser::new);
        return ResponseEntity.ok(page);
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