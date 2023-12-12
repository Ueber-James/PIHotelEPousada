package br.com.pihoteisepousadas.Projeto.domain.service.impl;

import br.com.pihoteisepousadas.Projeto.domain.entity.Usuario;
import br.com.pihoteisepousadas.Projeto.domain.exception.UsuarioNotFoundException;
import br.com.pihoteisepousadas.Projeto.domain.repository.UsuarioRepository;
import br.com.pihoteisepousadas.Projeto.domain.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.UUID;
@Service
public class UsuarioServiceImpl implements UsuarioService {
    private final UsuarioRepository usuarioRepository;
    @Autowired
    public UsuarioServiceImpl(UsuarioRepository usuarioRepository) {

        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public Page<Usuario> buscarUsuario(Pageable pageable) {
        return usuarioRepository.findAll(pageable);
    }

    @Override
    public Usuario buscarUsuarioPorId(UUID id) {
        return usuarioRepository.findById(id).orElseThrow(() ->
        new UsuarioNotFoundException(id));
    }

    @Override
    public Usuario atualizarUsuario(UUID id) {
        return null;
    }

    @Override
    public void excluirUsuario(UUID id) {
        Usuario usuario = usuarioRepository.findById(id).orElseThrow(() ->
                new UsuarioNotFoundException(id));
        usuarioRepository.delete(usuario);

    }
}
