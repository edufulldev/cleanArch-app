package cleanArch_app.config;

import cleanArch_app.application.gateways.RepositorioUsuario;
import cleanArch_app.application.useCases.CriarUsuario;
import cleanArch_app.application.useCases.ListarUsuarios;
import cleanArch_app.infra.gateways.UsuarioMapper;
import cleanArch_app.infra.gateways.RepositorioUsuarioJpa;
import cleanArch_app.infra.persistence.UsuarioRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UsuarioConfig {

    @Bean
    CriarUsuario criarUsuario(RepositorioUsuario repositorioUsuario) {
        return new CriarUsuario(repositorioUsuario);
    }

    @Bean
    RepositorioUsuarioJpa criarRepositorioJpa(UsuarioRepository repositorio, UsuarioMapper mapper) {
        return new RepositorioUsuarioJpa(repositorio, mapper);
    }

    @Bean
    public ListarUsuarios listarUsuarios(RepositorioUsuario repositorioUsuario) {
        return new ListarUsuarios(repositorioUsuario);
    }

    @Bean
    UsuarioMapper retornarMapper() {
        return new UsuarioMapper();
    }
}
