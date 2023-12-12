package br.com.pihoteisepousadas.Projeto.app.api;

import br.com.pihoteisepousadas.Projeto.app.api.dto.request.CreateImagemRequest;
import br.com.pihoteisepousadas.Projeto.app.api.dto.response.ImagemListResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.UUID;

@RequestMapping("/imagens")
@Tag(name = "Imagens", description = "Gerenciamento de Imagens")
@SecurityRequirement(name = "jwt_auth")
public interface ImagemApi {

    @GetMapping
    @PreAuthorize("hasAuthority('USER')")
    @Operation(summary = "Buscar todas as imagens", description = "Obtém uma lista paginada de todas as imagens.")
    ResponseEntity<Page<ImagemListResponse>> buscarImagem(@PageableDefault Pageable pageable);

    @PostMapping
    @Operation(summary = "Criar uma nova imagem", description = "Cria uma nova imagem com base nos dados fornecidos.")
    ResponseEntity<ImagemListResponse> criarImagem(@RequestBody @Valid CreateImagemRequest request);

    @GetMapping("{id}")
    @Operation(summary = "Buscar imagem por ID", description = "Obtém as informações de uma imagem específica com base no ID fornecido.")
    ResponseEntity<ImagemListResponse> buscarImagemPorId(@PathVariable UUID id);

    @PatchMapping("{id}")
    @Operation(summary = "Atualizar imagem por ID", description = "Atualiza as informações de uma imagem específica com base no ID fornecido.")
    ResponseEntity<ImagemListResponse> atualizarImagemPorId(@PathVariable UUID id, @RequestBody Map<String, Object> campos);

    @DeleteMapping("{id}")
    @Operation(summary = "Excluir imagem por ID", description = "Exclui uma imagem específica com base no ID fornecido.")
    ResponseEntity<Void> excluirImagem(@PathVariable UUID id);
}
