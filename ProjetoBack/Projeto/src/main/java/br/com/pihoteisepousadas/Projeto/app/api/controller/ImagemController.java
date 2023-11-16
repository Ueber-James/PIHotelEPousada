package br.com.pihoteisepousadas.Projeto.app.api.controller;

import br.com.pihoteisepousadas.Projeto.app.api.ImagemApi;
import br.com.pihoteisepousadas.Projeto.app.api.dto.request.CreateImagemRequest;
import br.com.pihoteisepousadas.Projeto.app.api.dto.response.ImagemListResponse;
import br.com.pihoteisepousadas.Projeto.domain.entity.Imagem;
import br.com.pihoteisepousadas.Projeto.domain.service.ImagemService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.UUID;
@RestController
public class ImagemController implements ImagemApi {
    private final ImagemService imagemService;
    private final ObjectMapper mapper;
    @Autowired
    public ImagemController(ImagemService imagemService, ObjectMapper mapper) {
        this.imagemService = imagemService;
        this.mapper = mapper;
    }

    @Override
    public ResponseEntity<Page<ImagemListResponse>> buscarImagem(Pageable pageable) {
        Page<Imagem> imagemPage = imagemService.buscarImagem(pageable);

        Page<ImagemListResponse> response = imagemPage
                .map(imagem -> new ImagemListResponse(
                        imagem.getId(),
                        imagem.getTitulo(),
                        imagem.getUrl()
                ));
        return ResponseEntity.ok(response);
    }

    @Override
    public ResponseEntity<ImagemListResponse> criarImagem(CreateImagemRequest request) {
        Imagem imagem = mapper.convertValue(request, Imagem.class);
        Imagem imagemCriado = imagemService.criarImagem(imagem);
        ImagemListResponse imagemListResponse = imagemParaImagemListResponse(imagemCriado);
        return ResponseEntity.status(HttpStatus.CREATED).body(imagemListResponse);
    }

    @Override
    public ResponseEntity<ImagemListResponse> buscarImagemPorId(UUID id) {
        Imagem imagem = imagemService.buscarImagemPorId(id);
        ImagemListResponse imagemListResponse = imagemParaImagemListResponse(imagem);
        return ResponseEntity.ok(imagemListResponse);
    }

    @Override
    public ResponseEntity<ImagemListResponse> atualizarImagemPorId(UUID id, Map<String, Object> campos) {
        Imagem imagem = imagemService.atualizarImagem(id);
        ImagemListResponse imagemListResponse = imagemParaImagemListResponse(imagem);
        return ResponseEntity.accepted().body(imagemListResponse);
    }

    @Override
    public ResponseEntity<Void> excluirImagem(UUID id) {
        imagemService.excluirImagem(id);
        return ResponseEntity.noContent().build();
    }
    private ImagemListResponse imagemParaImagemListResponse(Imagem imagem) {
        return mapper.convertValue(imagem, ImagemListResponse.class);
    }
}
