package br.com.pihoteisepousadas.Projeto.domain.service.impl;

import br.com.pihoteisepousadas.Projeto.domain.entity.Produto;
import br.com.pihoteisepousadas.Projeto.domain.exception.ProdutoNotFoundException;
import br.com.pihoteisepousadas.Projeto.domain.repository.ProdutoRepository;
import br.com.pihoteisepousadas.Projeto.domain.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.UUID;
@Service
public class ProdutoServiceImpl implements ProdutoService {
    private final ProdutoRepository produtoRepository;
    @Autowired
    public ProdutoServiceImpl(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    @Override
    public Produto criarProduto(Produto produto) {
        return produtoRepository.save(produto);
    }

    @Override
    public Page<Produto> buscarProduto(Pageable pageable) {
        return produtoRepository.findAll(pageable);
    }

    @Override
    public Produto buscarProdutoPorId(UUID id) {
        return produtoRepository.findById(id).orElseThrow(()->
                new ProdutoNotFoundException(id));
    }

    @Override
    public Produto atualizarProduto(UUID id) {
        return null;
    }

    @Override
    public void excluirProduto(UUID id) {
        Produto produto = produtoRepository.findById(id).orElseThrow(() ->
                new ProdutoNotFoundException(id));
        produtoRepository.delete(produto);

    }
}
