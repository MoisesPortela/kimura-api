package kimtela.api.controller;

import kimtela.api.domain.usuario.TipoPerfil;
import kimtela.api.domain.usuario.Usuario;

public record DadosListagemUser(String email, String telefone, TipoPerfil tipoPerfil) {
    public DadosListagemUser (Usuario user) {
        this(user.getEmail(), user.getTelefone(), user.getTipoPerfil());
    }
}
