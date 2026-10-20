package cleanArch_app.application.useCases;

import cleanArch_app.application.gateways.RepositorioUsuario;
import cleanArch_app.domain.entities.usuario.Usuario;

public class CriarUsuario {

    private final RepositorioUsuario repository;

    public CriarUsuario(RepositorioUsuario repository) {
        this.repository = repository;
    }

    public Usuario cadastrarUsuario(Usuario usuario) {
        return repository.cadastrarUsuario(usuario);
    }
}
