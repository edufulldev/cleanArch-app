package cleanArch_app.infra.gateways;


import cleanArch_app.application.gateways.RepositorioUsuario;
import cleanArch_app.domain.entities.usuario.Usuario;
import cleanArch_app.infra.persistence.UsuarioEntity;
import cleanArch_app.infra.persistence.UsuarioRepository;

import java.util.List;
import java.util.stream.Collectors;

public class RepositorioUsuarioJpa implements RepositorioUsuario {

    private final UsuarioRepository repository;
    private final UsuarioMapper mapper;

    public RepositorioUsuarioJpa(UsuarioRepository repository, UsuarioMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public Usuario cadastrarUsuario(Usuario usuario) {
       UsuarioEntity entity = mapper.toEntity(usuario);
        repository.save(entity);
        return mapper.toDomain(entity);
    }

    @Override
    public List<Usuario> listarTodos() {
      return repository.findAll()
              .stream()
              .map(mapper::toDomain)
              .collect(Collectors.toList());
    }
}
