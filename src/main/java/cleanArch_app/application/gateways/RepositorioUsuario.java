package cleanArch_app.application.gateways;


import cleanArch_app.domain.entities.usuario.Usuario;

import java.util.List;

public interface RepositorioUsuario {

    Usuario cadastrarUsuario(Usuario usuario);

    List<Usuario> listarTodos();


}
