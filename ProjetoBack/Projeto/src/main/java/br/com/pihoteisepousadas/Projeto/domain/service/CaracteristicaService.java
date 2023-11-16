package br.com.pihoteisepousadas.Projeto.domain.service;

import br.com.pihoteisepousadas.Projeto.domain.entity.Caracteristica;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.UUID;

public interface CaracteristicaService {
    Caracteristica criarCaracteristica(Caracteristica caracteristica);

    Page<Caracteristica> buscarCaracteristica(Pageable pageable);

    Caracteristica buscarCaracteristicaPorId(UUID id);

    Caracteristica atualizarCaracteristica(UUID id);

    void excluirCaracteristica(UUID id);
}
