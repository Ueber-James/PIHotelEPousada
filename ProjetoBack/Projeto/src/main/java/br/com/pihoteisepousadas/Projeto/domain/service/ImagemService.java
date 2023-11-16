package br.com.pihoteisepousadas.Projeto.domain.service;

import br.com.pihoteisepousadas.Projeto.domain.entity.Imagem;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.UUID;

public interface ImagemService {
    Imagem criarImagem(Imagem imagem);

    Page<Imagem> buscarImagem(Pageable pageable);

    Imagem buscarImagemPorId(UUID id);

    Imagem atualizarImagem(UUID id);

    void excluirImagem(UUID id);
}
