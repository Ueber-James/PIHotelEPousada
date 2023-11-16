package br.com.pihoteisepousadas.Projeto.domain.service.impl;

import br.com.pihoteisepousadas.Projeto.domain.entity.Categoria;
import br.com.pihoteisepousadas.Projeto.domain.exception.CategoriaNotFoundException;
import br.com.pihoteisepousadas.Projeto.domain.repository.CategoriaRepository;
import br.com.pihoteisepousadas.Projeto.domain.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.UUID;
@Service
public class CategoriaServiceImpl implements CategoriaService {
    @Autowired
    private final CategoriaRepository categoriaRepository;

    public CategoriaServiceImpl(CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }

    @Override
    public Categoria criarCategoria(Categoria categoria) {
        return categoriaRepository.save(categoria);
    }

    @Override
    public Page<Categoria> buscarCategoria(Pageable pageable) {
        return categoriaRepository.findAll(pageable);
    }

    @Override
    public Categoria buscarCategoriaPorId(UUID id) {
        return categoriaRepository.findById(id).orElseThrow(()->
                new CategoriaNotFoundException(id));
    }
    @Override
    public Categoria atualizarCategoria(UUID id) {
        return null;
    }

    @Override
    public void excluirCategoria(UUID id) {
        Categoria categoria = categoriaRepository.findById(id).orElseThrow(() ->
                new CategoriaNotFoundException(id));
        categoriaRepository.delete(categoria);
    }
}
