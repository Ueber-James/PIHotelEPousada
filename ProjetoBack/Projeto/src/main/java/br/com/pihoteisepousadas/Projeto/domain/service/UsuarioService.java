package br.com.pihoteisepousadas.Projeto.domain.service;

import br.com.pihoteisepousadas.Projeto.domain.entity.Usuario;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.UUID;

public interface UsuarioService {

    Page<Usuario> buscarUsuario(Pageable pageable);

    Usuario buscarUsuarioPorId(UUID id);

    Usuario atualizarUsuario(UUID id);

    void excluirUsuario(UUID id);
}
