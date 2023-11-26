package br.com.pihoteisepousadas.Projeto.domain.service;

import br.com.pihoteisepousadas.Projeto.domain.entity.Hospedagem;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.UUID;

public interface HospedagemService {
   Hospedagem criarHospedagem(Hospedagem hospedagem);

    Page<Hospedagem> buscarHospedagem(Pageable pageable);

    Hospedagem buscarHospedagemPorId(UUID id);

    Hospedagem atualizarHospedagem(UUID id);

    void excluirHospedagem(UUID id);

}
