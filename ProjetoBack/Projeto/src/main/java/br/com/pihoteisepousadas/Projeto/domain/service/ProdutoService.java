package br.com.pihoteisepousadas.Projeto.domain.service;

import br.com.pihoteisepousadas.Projeto.domain.entity.Produto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.UUID;

public interface ProdutoService {
    Produto criarProduto(Produto produto);

    Page<Produto> buscarProduto(Pageable pageable);

    Produto buscarProdutoPorId(UUID id);

    Produto atualizarProduto(UUID id);

    void excluirProduto(UUID id);
}
