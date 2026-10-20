package cleanArch_app.application.useCases;

import cleanArch_app.application.gateways.RepositorioUsuario;
import cleanArch_app.domain.entities.usuario.Usuario;

import java.util.List;

public class ListarUsuarios {

    private final RepositorioUsuario repository;

    public ListarUsuarios(RepositorioUsuario repository) {
        this.repository = repository;
    }

    public List<Usuario> obterTodosUsuarios() {
        return this.repository.listarTodos();
    }
}
