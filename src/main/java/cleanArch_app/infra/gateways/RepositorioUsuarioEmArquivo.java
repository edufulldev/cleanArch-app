package cleanArch_app.infra.gateways;

import cleanArch_app.application.gateways.RepositorioUsuario;
import cleanArch_app.domain.entities.usuario.Usuario;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class RepositorioUsuarioEmArquivo implements RepositorioUsuario {

    List<Usuario> usuarios = new ArrayList<>();

    @Override
    public Usuario cadastrarUsuario(Usuario usuario) {
        this.usuarios.add(usuario);
        return usuario;
    }

    @Override
    public List<Usuario> listarTodos() {
        return this.usuarios;
    }

    public void gravarArquivo(String nomeArquivo) {
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(nomeArquivo);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try {
            fileWriter.write(this.usuarios.toString());
            fileWriter.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
