package cleanArch_app.domain.entities.usuario;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

public class UsuarioTeste {

    @Test
    public void NaoDeveCadastrarUsuarioComCpfInadequado() {
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> new Usuario("111222333-44", "edu", LocalDate.parse("1980-09-10"), "email@email.com"));
    }

    @Test
    public void deveCriarusuarioUsandoFabricaUsuario() {
        FabricaUsuario fabricaUsuario = new FabricaUsuario();
        Usuario usuario = fabricaUsuario.comNomeCpfNascimento("Marcos", "222.333.444-55", LocalDate.parse("1953-12-18"));

        Assertions.assertEquals("Marcos",usuario.getNome());

        // add um endereço
        usuario = fabricaUsuario.incluirEndereco("35700-150", 581, "casa 05");
        Assertions.assertEquals("casa 05", usuario.getEndereco().getComplemento());
    }
}
