package br.com.pihoteisepousadas.Projeto.domain.service.impl;

import br.com.pihoteisepousadas.Projeto.domain.entity.Hospedagem;
import br.com.pihoteisepousadas.Projeto.domain.exception.HospedagemNotFoundException;
import br.com.pihoteisepousadas.Projeto.domain.repository.HospedagemRepository;
import br.com.pihoteisepousadas.Projeto.domain.service.HospedagemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.UUID;
@Service
public class HospedagemServiceImpl implements HospedagemService {
    private  final HospedagemRepository hospedagemRepository;
    @Autowired
    public HospedagemServiceImpl(HospedagemRepository hospedagemRepository) {
        this.hospedagemRepository = hospedagemRepository;
    }

    @Override
    public Hospedagem criarHospedagem(Hospedagem hospedagem) {
        return hospedagemRepository.save(hospedagem);
    }

    @Override
    public Page<Hospedagem> buscarHospedagem(Pageable pageable) {
        return hospedagemRepository.findAll(pageable);
    }

    @Override
    public Hospedagem buscarHospedagemPorId(UUID id) {
        return hospedagemRepository.findById(id).orElseThrow(() ->
                new HospedagemNotFoundException(id));
    }

    @Override
    public Hospedagem atualizarHospedagem(UUID id) {
        return null;
    }

    @Override
    public void excluirHospedagem(UUID id) {
        Hospedagem hospedagem = hospedagemRepository.findById(id).orElseThrow(() ->
                new HospedagemNotFoundException(id));
        hospedagemRepository.delete(hospedagem);

    }
}
