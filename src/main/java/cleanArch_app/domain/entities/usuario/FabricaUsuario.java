package cleanArch_app.domain.entities.usuario;

import cleanArch_app.domain.Endereco;

import java.time.LocalDate;

public class FabricaUsuario {

    private Usuario usuario;

    public Usuario comNomeCpfNascimento(String nome, String cpf, LocalDate nascimento) {
        this.usuario = new Usuario(cpf, nome, nascimento, "");
        return this.usuario;
    }

    public Usuario incluirEndereco(String cep, Integer numero, String complemento) {
        this.usuario.setEndereco(new Endereco(cep, numero, complemento));

        return this.usuario;
    }
}
