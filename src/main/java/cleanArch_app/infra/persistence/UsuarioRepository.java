package cleanArch_app.infra.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

    public interface UsuarioRepository extends JpaRepository<UsuarioEntity, Long> {
    }

