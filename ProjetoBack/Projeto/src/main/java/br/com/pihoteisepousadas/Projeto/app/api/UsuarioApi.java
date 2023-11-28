package br.com.pihoteisepousadas.Projeto.app.api;

import br.com.pihoteisepousadas.Projeto.app.api.dto.request.CreateUsuarioRequest;
import br.com.pihoteisepousadas.Projeto.app.api.dto.response.UsuarioListResponse;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.UUID;
@RequestMapping("v1/usuarios")
public interface UsuarioApi {
    @GetMapping
    ResponseEntity<Page<UsuarioListResponse>> buscarUsuario(@PageableDefault Pageable pageable);
    @PostMapping
    ResponseEntity<UsuarioListResponse> criarUsuario(@RequestBody @Valid CreateUsuarioRequest request);
    @GetMapping("{id}")
    ResponseEntity<UsuarioListResponse> buscarUsuarioPorId(@PathVariable UUID id);
    @PatchMapping("{id}")
    ResponseEntity<UsuarioListResponse> atualizarUsuarioPorId(@PathVariable UUID Id, Map<String, Object> campos);
    @DeleteMapping("{id}")
    ResponseEntity<Void> excluirUsuario(@PathVariable UUID id);
}