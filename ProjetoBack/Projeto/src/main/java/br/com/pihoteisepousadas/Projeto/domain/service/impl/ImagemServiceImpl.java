package br.com.pihoteisepousadas.Projeto.domain.service.impl;

import br.com.pihoteisepousadas.Projeto.domain.entity.Imagem;
import br.com.pihoteisepousadas.Projeto.domain.exception.ImagemNotFoundException;
import br.com.pihoteisepousadas.Projeto.domain.repository.ImagemRepository;
import br.com.pihoteisepousadas.Projeto.domain.service.ImagemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.UUID;
@Service
public class ImagemServiceImpl implements ImagemService {
    private final ImagemRepository imagemRepository;
    @Autowired
    public ImagemServiceImpl(ImagemRepository imagemRepository) {
        this.imagemRepository = imagemRepository;
    }

    @Override
    public Imagem criarImagem(Imagem imagem) {
        return imagemRepository.save(imagem);
    }

    @Override
    public Page<Imagem> buscarImagem(Pageable pageable) {
        return imagemRepository.findAll(pageable);
    }

    @Override
    public Imagem buscarImagemPorId(UUID id) {
        return imagemRepository.findById(id).orElseThrow(()->
                new ImagemNotFoundException(id));
    }

    @Override
    public Imagem atualizarImagem(UUID id) {
        return null;
    }

    @Override
    public void excluirImagem(UUID id) {
        Imagem imagem = imagemRepository.findById(id).orElseThrow(() ->
                new ImagemNotFoundException(id));
        imagemRepository.delete(imagem);

    }
}
