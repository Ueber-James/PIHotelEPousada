package br.com.pihoteisepousadas.Projeto.app.api.controller;

import br.com.pihoteisepousadas.Projeto.app.api.CategoriaApi;
import br.com.pihoteisepousadas.Projeto.app.api.dto.request.CreateCategoriaRequest;
import br.com.pihoteisepousadas.Projeto.app.api.dto.response.CategoriaListResponse;
import br.com.pihoteisepousadas.Projeto.domain.entity.Categoria;
import br.com.pihoteisepousadas.Projeto.domain.service.CategoriaService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.UUID;
@RestController
public class CategoriaController implements CategoriaApi {
    private final CategoriaService categoriaService;
    private final ObjectMapper mapper;
    @Autowired
    public CategoriaController(CategoriaService categoriaService, ObjectMapper mapper) {
        this.categoriaService = categoriaService;
        this.mapper = mapper;
    }

    @Override
    public ResponseEntity<Page<CategoriaListResponse>> buscarCategoria(Pageable pageable) {
        Page<Categoria> categoriaPage = categoriaService.buscarCategoria(pageable);

        Page<CategoriaListResponse> response = categoriaPage
                .map(categoria -> new CategoriaListResponse(
                        categoria.getId(),
                        categoria.getQualificacao(),
                        categoria.getDescricao(),
                        categoria.getUrlImagem()
                ));
        return ResponseEntity.ok(response);
    }

    @Override
    public ResponseEntity<CategoriaListResponse> criarCategoria(CreateCategoriaRequest request) {
        Categoria categoria = mapper.convertValue(request, Categoria.class);
        Categoria categoriaCriado = categoriaService.criarCategoria(categoria);
        CategoriaListResponse categoriaListResponse = categoriaParaCategoriaListResponse(categoriaCriado);
        return ResponseEntity.status(HttpStatus.CREATED).body(categoriaListResponse);
    }

    @Override
    public ResponseEntity<CategoriaListResponse> buscarCategoriaPorId(UUID id) {
        Categoria categoria = categoriaService.buscarCategoriaPorId(id);
        CategoriaListResponse categoriaListResponse = categoriaParaCategoriaListResponse(categoria);
        return ResponseEntity.ok(categoriaListResponse);
    }

    @Override
    public ResponseEntity<CategoriaListResponse> atualizarCategoriaPorId(UUID id, Map<String, Object> campos) {
        Categoria categoria = categoriaService.atualizarCategoria(id);
        CategoriaListResponse categoriaListResponse = categoriaParaCategoriaListResponse(categoria);
        return ResponseEntity.accepted().body(categoriaListResponse);
    }

    @Override
    public ResponseEntity<Void> excluirCategoria(UUID id) {
        categoriaService.excluirCategoria(id);
        return ResponseEntity.noContent().build();
    }

    private CategoriaListResponse categoriaParaCategoriaListResponse (Categoria categoria) {
        return mapper.convertValue(categoria, CategoriaListResponse.class);
    }
}
