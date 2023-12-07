package br.com.pihoteisepousadas.Projeto.app.api;

import br.com.pihoteisepousadas.Projeto.app.api.dto.request.CreateUsuarioRequest;
import br.com.pihoteisepousadas.Projeto.app.api.dto.response.UsuarioListResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.UUID;

@RequestMapping("/usuarios")
@Tag(name = "Usuário", description = "Gerenciamento de Usuários")
@SecurityRequirement(name = "jwt_auth")


public interface UsuarioApi {

    @GetMapping
    @Operation(summary = "Buscar todos os usuários", description = "Obtém uma lista paginada de todos os usuários.")
    ResponseEntity<Page<UsuarioListResponse>> buscarUsuario(@PageableDefault Pageable pageable);

    @PostMapping
    @Operation(summary = "Criar um novo usuário", description = "Cria um novo usuário com base nos dados fornecidos.")
    ResponseEntity<UsuarioListResponse> criarUsuario(@RequestBody @Valid CreateUsuarioRequest request);

    @GetMapping("{id}")
    @Operation(summary = "Buscar usuário por ID", description = "Obtém as informações de um usuário específico com base no ID fornecido.")
    ResponseEntity<UsuarioListResponse> buscarUsuarioPorId(@PathVariable UUID id);

    @PatchMapping("{id}")
    @Operation(summary = "Atualizar usuário por ID", description = "Atualiza as informações de um usuário específico com base no ID fornecido.")
    ResponseEntity<UsuarioListResponse> atualizarUsuarioPorId(@PathVariable UUID id, @RequestBody Map<String, Object> campos);

    @DeleteMapping("{id}")
    @Operation(summary = "Excluir usuário por ID", description = "Exclui um usuário específico com base no ID fornecido.")
    ResponseEntity<Void> excluirUsuario(@PathVariable UUID id);
}
