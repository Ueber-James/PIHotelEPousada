package br.com.pihoteisepousadas.Projeto.app.api;

import br.com.pihoteisepousadas.Projeto.app.api.dto.request.CreateCategoriaRequest;
import br.com.pihoteisepousadas.Projeto.app.api.dto.response.CategoriaListResponse;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.UUID;

@RequestMapping("v1/categorias")
public interface CategoriaApi {
    @GetMapping
    ResponseEntity<Page<CategoriaListResponse>> buscarCategoria(@PageableDefault Pageable pageable);
    @PostMapping
    ResponseEntity<CategoriaListResponse> criarCategoria(@RequestBody @Valid CreateCategoriaRequest request);
    @GetMapping("{id}")
    ResponseEntity<CategoriaListResponse> buscarCategoriaPorId(@PathVariable UUID id);
    @PatchMapping("{id}")
    ResponseEntity<CategoriaListResponse> atualizarCategoriaPorId(@PathVariable UUID Id, Map<String, Object> campos);
    @DeleteMapping("{id}")
    ResponseEntity<Void> excluirCategoria(@PathVariable UUID id);
}
