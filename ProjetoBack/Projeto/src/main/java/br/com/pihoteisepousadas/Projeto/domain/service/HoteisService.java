package br.com.pihoteisepousadas.Projeto.domain.service;

import br.com.pihoteisepousadas.Projeto.domain.entity.Hoteis;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.UUID;

public interface HoteisService {
    Hoteis criarHoteis(Hoteis hoteis);

    Page<Hoteis> buscarHoteis(Pageable pageable);

    Hoteis buscarHoteisPorId(UUID id);

    Hoteis atualizarHoteis(UUID id);

    void excluirHoteis(UUID id);
}
