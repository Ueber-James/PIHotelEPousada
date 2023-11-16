package br.com.pihoteisepousadas.Projeto.domain.service;

import br.com.pihoteisepousadas.Projeto.domain.entity.Categoria;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.UUID;

public interface CategoriaService {
    Categoria criarCategoria(Categoria categoria);

    Page<Categoria> buscarCategoria(Pageable pageable);

    Categoria buscarCategoriaPorId(UUID id);

    Categoria atualizarCategoria(UUID id);

    void excluirCategoria(UUID id);
}
