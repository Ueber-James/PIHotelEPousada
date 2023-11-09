package br.com.pihoteisepousadas.Projeto.domain.service;

import br.com.pihoteisepousadas.Projeto.domain.entity.Acomodacao;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.UUID;

public interface AcomodacaoService {
    Acomodacao criarAcomodacao(Acomodacao acomodacao);

    Page<Acomodacao> buscarAcomodacao(Pageable pageable);

    Acomodacao buscarAcomodacaoPorId(UUID id);

    Acomodacao atualizarAcomodacao(UUID id);

    void excluirAcomodacao(UUID id);
}
