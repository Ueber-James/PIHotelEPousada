package br.com.pihoteisepousadas.Projeto.domain.service;

import br.com.pihoteisepousadas.Projeto.domain.entity.Cidade;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.UUID;

public interface CidadeService {
    Cidade criarCidade(Cidade cidade);

    Page<Cidade> buscarCidade(Pageable pageable);

    Cidade buscarCidadePorId(UUID id);

    Cidade atualizarCidade(UUID id);

    void excluirCidade(UUID id);
}
