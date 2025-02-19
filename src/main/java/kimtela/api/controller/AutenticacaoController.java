package kimtela.api.controller;

import jakarta.validation.Valid;
import kimtela.api.domain.usuario.DadosAutenticacao;
import kimtela.api.domain.usuario.DadosCriarUser;
import kimtela.api.domain.usuario.Usuario;
import kimtela.api.domain.usuario.UsuarioRepository;
import kimtela.api.infra.security.DadosTokenJwt;
import kimtela.api.infra.security.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class AutenticacaoController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenService tokenService;

    @PostMapping
    public ResponseEntity efetuarLogin (@RequestBody @Valid DadosAutenticacao dadosAutenticacao){
        var token = new UsernamePasswordAuthenticationToken(dadosAutenticacao.email(),dadosAutenticacao.senha());
        var authenticate =authenticationManager.authenticate(token);
        var tokenJWT = tokenService.gerarToken((Usuario) authenticate.getPrincipal());
        return ResponseEntity.ok(new DadosTokenJwt(tokenJWT));
    }



}
