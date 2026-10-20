package cleanArch_app;

import cleanArch_app.domain.entities.usuario.Usuario;
import cleanArch_app.infra.gateways.RepositorioUsuarioEmArquivo;

import java.time.LocalDate;

import static java.lang.System.*;

public class TestMemoriaUsuariosArquivos {

    public static void main(String[] args) {
        RepositorioUsuarioEmArquivo repositorioArquivo = new RepositorioUsuarioEmArquivo();

        repositorioArquivo.cadastrarUsuario(new Usuario("999.888.777-66", "Miguel lopes",
                LocalDate.parse("1930-06-12"), "miguel@email.com"));

        repositorioArquivo.cadastrarUsuario(new Usuario("777.666.555-66", "Eron cesar",
                LocalDate.parse("1984-11-10"), "eron@email.com"));

        repositorioArquivo.cadastrarUsuario(new Usuario("666.555.444-66", "Jessica cristiane",
                LocalDate.parse("1991-01-15"), "jessica@email.com"));

       // out.println(repositorioArquivo.listarTodos());
        repositorioArquivo.gravarArquivo("usuarios.txt");
    }
}
