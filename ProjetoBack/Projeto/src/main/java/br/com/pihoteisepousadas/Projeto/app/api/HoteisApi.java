package br.com.pihoteisepousadas.Projeto.app.api;

import br.com.pihoteisepousadas.Projeto.app.api.dto.request.CreateHoteisRequest;
import br.com.pihoteisepousadas.Projeto.app.api.dto.response.HoteisListResponse;
import io.swagger.v3.oas.annotations.Operation;
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

@RequestMapping("v1/hoteis")
@Tag(name = "Hotéis", description = "Gerenciamento de Hotéis")
@SecurityRequirement(name = "jwt_auth")
public interface HoteisApi {

    @GetMapping
    @Operation(summary = "Buscar todos os hotéis", description = "Obtém uma lista paginada de todos os hotéis.")
    ResponseEntity<Page<HoteisListResponse>> buscarHoteis(@PageableDefault Pageable pageable);

    @PostMapping
    @Operation(summary = "Criar um novo hotel", description = "Cria um novo hotel com base nos dados fornecidos.")
    ResponseEntity<HoteisListResponse> criarHoteis(@RequestBody @Valid CreateHoteisRequest request);

    @GetMapping("{id}")
    @Operation(summary = "Buscar hotel por ID", description = "Obtém as informações de um hotel específico com base no ID fornecido.")
    ResponseEntity<HoteisListResponse> buscarHoteisPorId(@PathVariable UUID id);

    @PatchMapping("{id}")
    @Operation(summary = "Atualizar hotel por ID", description = "Atualiza as informações de um hotel específico com base no ID fornecido.")
    ResponseEntity<HoteisListResponse> atualizarHoteisPorId(@PathVariable UUID id, @RequestBody Map<String, Object> campos);

    @DeleteMapping("{id}")
    @Operation(summary = "Excluir hotel por ID", description = "Exclui um hotel específico com base no ID fornecido.")
    ResponseEntity<Void> excluirHoteis(@PathVariable UUID id);
}
