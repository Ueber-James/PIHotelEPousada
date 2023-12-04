package br.com.pihoteisepousadas.Projeto.app.api.controller;

import br.com.pihoteisepousadas.Projeto.app.api.UsuarioApi;
import br.com.pihoteisepousadas.Projeto.app.api.dto.request.CreateUsuarioRequest;
import br.com.pihoteisepousadas.Projeto.app.api.dto.response.UsuarioListResponse;
import br.com.pihoteisepousadas.Projeto.domain.entity.Usuario;
import br.com.pihoteisepousadas.Projeto.domain.service.UsuarioService;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.UUID;
@RestController
public class UsuarioController implements UsuarioApi {
    private final UsuarioService usuarioService;
    private final ObjectMapper mapper;
    @Autowired
    public UsuarioController(UsuarioService usuarioService, ObjectMapper mapper) {
        this.usuarioService = usuarioService;
        this.mapper = mapper;
    }

    @Override
    public ResponseEntity<Page<UsuarioListResponse>> buscarUsuario(Pageable pageable) {
        Page<Usuario> usuarioPage = usuarioService.buscarUsuario(pageable);

        Page<UsuarioListResponse> response = usuarioPage
                .map(usuario -> new UsuarioListResponse(
                        usuario.getId(),
                        usuario.getNome(),
                        usuario.getSobrenome(),
                        usuario.getEmail(),
                        usuario.getSenha(),
                        usuario.getConfirmarSenha()
                ));
        return ResponseEntity.ok(response);
    }

    @Override

    public ResponseEntity<UsuarioListResponse> criarUsuario(CreateUsuarioRequest request) {
        Usuario usuario = mapper.convertValue(request, Usuario.class);
        Usuario usuarioCriado = usuarioService.criarUsuario(usuario);
        UsuarioListResponse usuarioListResponse = usuarioParaUsuarioListResponse(usuarioCriado);
        return ResponseEntity.status(HttpStatus.CREATED).body(usuarioListResponse);
    }

    @Override
    public ResponseEntity<UsuarioListResponse> buscarUsuarioPorId(UUID id) {
        Usuario usuario = usuarioService.buscarUsuarioPorId(id);
        UsuarioListResponse usuarioListResponse = usuarioParaUsuarioListResponse(usuario);
        return ResponseEntity.ok(usuarioListResponse);
    }

    @Override
    public ResponseEntity<UsuarioListResponse> atualizarUsuarioPorId(UUID id, Map<String, Object> campos) {
        Usuario usuario = usuarioService.atualizarUsuario(id);
        UsuarioListResponse usuarioListResponse = usuarioParaUsuarioListResponse(usuario);
        return ResponseEntity.accepted().body(usuarioListResponse);
    }

    @Override
    public ResponseEntity<Void> excluirUsuario(UUID id) {
        usuarioService.excluirUsuario(id);
        return ResponseEntity.noContent().build();
    }

    private UsuarioListResponse usuarioParaUsuarioListResponse (Usuario cliente){
        return mapper.convertValue(cliente, UsuarioListResponse.class);
    }
}
