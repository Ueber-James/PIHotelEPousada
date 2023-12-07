package br.com.pihoteisepousadas.Projeto.app.runner;

import br.com.pihoteisepousadas.Projeto.domain.entity.Usuario;
import br.com.pihoteisepousadas.Projeto.domain.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BancoDeUsuarioRunner implements CommandLineRunner {
    private final UsuarioRepository usuarioRepository;
    @Autowired
    public BancoDeUsuarioRunner(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public void run(String... args) {
        Usuario usuario1 = new Usuario();
        usuario1.setNome("Elton");
        usuario1.setSobrenome("Tome");
        usuario1.setEmail("");
        usuario1.setSenha("1234");

        Usuario usuario2 = new Usuario();
        usuario2.setNome("Luiz");
        usuario2.setSobrenome("Souza");
        usuario2.setEmail("");
        usuario2.setSenha("1234");

        Usuario usuario3 = new Usuario();
        usuario3.setNome("Deyse");
        usuario3.setSobrenome("Fernandes");
        usuario3.setEmail("");
        usuario3.setSenha("1234");

        Usuario usuario4 = new Usuario();
        usuario4.setNome("Ueber");
        usuario4.setSobrenome("James");
        usuario4.setEmail("");
        usuario4.setSenha("1234");

        Usuario usuario5 = new Usuario();
        usuario5.setNome("Artur");
        usuario5.setSobrenome("Miguel");
        usuario5.setEmail("");
        usuario5.setSenha("1234");

        usuarioRepository.saveAll(List.of(usuario1, usuario2, usuario3, usuario4, usuario5));
    }
}
