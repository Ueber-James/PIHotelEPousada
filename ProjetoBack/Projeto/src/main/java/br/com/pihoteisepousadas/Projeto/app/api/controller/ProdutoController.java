package br.com.pihoteisepousadas.Projeto.app.api.controller;

import br.com.pihoteisepousadas.Projeto.app.api.ProdutoApi;
import br.com.pihoteisepousadas.Projeto.app.api.dto.request.CreateProdutoRequest;
import br.com.pihoteisepousadas.Projeto.app.api.dto.response.ProdutoListResponse;
import br.com.pihoteisepousadas.Projeto.domain.entity.Produto;
import br.com.pihoteisepousadas.Projeto.domain.service.ProdutoService;
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
public class ProdutoController implements ProdutoApi {
    private final ProdutoService produtoService;
    private final ObjectMapper mapper;
    @Autowired
    public ProdutoController(ProdutoService produtoService, ObjectMapper mapper) {
        this.produtoService = produtoService;
        this.mapper = mapper;
    }

    @Override
    public ResponseEntity<Page<ProdutoListResponse>> buscarProduto(Pageable pageable) {
        Page<Produto> produtoPage =produtoService.buscarProduto(pageable);

        Page<ProdutoListResponse> response = produtoPage
                .map(produto -> new ProdutoListResponse(
                        produto.getId(),
                        produto.getNome(),
                        produto.getDescricao()
                ));
        return ResponseEntity.ok(response);
    }

    @Override
    public ResponseEntity<ProdutoListResponse> criarProduto(CreateProdutoRequest request) {
        Produto produto = mapper.convertValue(request, Produto.class);
        Produto produtoCriado = produtoService.criarProduto(produto);
        ProdutoListResponse produtoListResponse = produtoParaProdutoListResponse(produtoCriado);
        return ResponseEntity.status(HttpStatus.CREATED).body(produtoListResponse);
    }

    @Override
    public ResponseEntity<ProdutoListResponse> buscarProdutoPorId(UUID id) {
        Produto produto = produtoService.buscarProdutoPorId(id);
        ProdutoListResponse produtoListResponse = produtoParaProdutoListResponse(produto);
        return ResponseEntity.ok(produtoListResponse);
    }

    @Override
    public ResponseEntity<ProdutoListResponse> atualizarProdutoPorId(UUID id, Map<String, Object> campos) {
        Produto produto = produtoService.buscarProdutoPorId(id);
        ProdutoListResponse produtoListResponse = produtoParaProdutoListResponse(produto);
        return ResponseEntity.accepted().body(produtoListResponse);
    }

    @Override
    public ResponseEntity<Void> excluirProduto(UUID id) {
        produtoService.excluirProduto(id);
        return ResponseEntity.noContent().build();
    }
    private ProdutoListResponse produtoParaProdutoListResponse(Produto produto) {
        return mapper.convertValue(produto, ProdutoListResponse.class);
    }
}
