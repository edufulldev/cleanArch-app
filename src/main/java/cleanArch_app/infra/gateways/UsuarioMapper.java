package cleanArch_app.infra.gateways;

import cleanArch_app.domain.entities.usuario.Usuario;
import cleanArch_app.infra.persistence.UsuarioEntity;

public class UsuarioMapper {

    public UsuarioEntity toEntity(Usuario usuario) {

        return new UsuarioEntity(
                usuario.getCpf(),
                usuario.getNome(),
                usuario.getNascimento(),
                usuario.getEmail());
    }

    public Usuario toDomain(UsuarioEntity entity) {
        return new Usuario(
                entity.getCpf(),
                entity.getNome(),
                entity.getNascimento(),
                entity.getEmail());
    }
}
