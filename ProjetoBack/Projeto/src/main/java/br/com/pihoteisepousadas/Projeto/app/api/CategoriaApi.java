package br.com.pihoteisepousadas.Projeto.app.api;

import br.com.pihoteisepousadas.Projeto.app.api.dto.request.CreateCategoriaRequest;
import br.com.pihoteisepousadas.Projeto.app.api.dto.response.CategoriaListResponse;
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

@RequestMapping("v1/categorias")
@Tag(name = "Categoria", description = "Gerenciamento de Categorias")
@SecurityRequirement(name = "jwt_auth")
public interface CategoriaApi {

    @GetMapping
    @Operation(summary = "Buscar todas as categorias", description = "Obtém uma lista paginada de todas as categorias.")
    ResponseEntity<Page<CategoriaListResponse>> buscarCategoria(@PageableDefault Pageable pageable);

    @PostMapping
    @Operation(summary = "Criar uma nova categoria", description = "Cria uma nova categoria com base nos dados fornecidos.")
    ResponseEntity<CategoriaListResponse> criarCategoria(@RequestBody @Valid CreateCategoriaRequest request);

    @GetMapping("{id}")
    @Operation(summary = "Buscar categoria por ID", description = "Obtém as informações de uma categoria específica com base no ID fornecido.")
    ResponseEntity<CategoriaListResponse> buscarCategoriaPorId(@PathVariable UUID id);

    @PatchMapping("{id}")
    @Operation(summary = "Atualizar categoria por ID", description = "Atualiza as informações de uma categoria específica com base no ID fornecido.")
    ResponseEntity<CategoriaListResponse> atualizarCategoriaPorId(@PathVariable UUID id, @RequestBody Map<String, Object> campos);

    @DeleteMapping("{id}")
    @Operation(summary = "Excluir categoria por ID", description = "Exclui uma categoria específica com base no ID fornecido.")
    ResponseEntity<Void> excluirCategoria(@PathVariable UUID id);

}
