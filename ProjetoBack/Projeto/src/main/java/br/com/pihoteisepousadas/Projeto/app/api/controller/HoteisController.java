package br.com.pihoteisepousadas.Projeto.app.api.controller;

import br.com.pihoteisepousadas.Projeto.app.api.HoteisApi;
import br.com.pihoteisepousadas.Projeto.app.api.dto.request.CreateHoteisRequest;
import br.com.pihoteisepousadas.Projeto.app.api.dto.response.HoteisListResponse;
import br.com.pihoteisepousadas.Projeto.domain.entity.Hoteis;
import br.com.pihoteisepousadas.Projeto.domain.entity.Produto;
import br.com.pihoteisepousadas.Projeto.domain.service.HoteisService;
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
public class HoteisController implements HoteisApi {
    private final HoteisService hoteisService;
    private final ObjectMapper mapper;
    @Autowired
    public HoteisController(HoteisService hoteisService, ObjectMapper mapper) {
        this.hoteisService = hoteisService;
        this.mapper = mapper;
    }
    @Override
    public ResponseEntity<Page<HoteisListResponse>> buscarHoteis(Pageable pageable) {
        Page<Hoteis> hoteisPage = hoteisService.buscarHoteis(pageable);

        Page<HoteisListResponse> response = hoteisPage
                .map(hoteis -> new HoteisListResponse(hoteis.getId(),
                        hoteis.getNome(),
                        hoteis.getCnpj(),
                        hoteis.getDescricao(),
                        hoteis.getRazaoSocial(),
                        hoteis.getProduto(),
                        hoteis.getRua(),
                        hoteis.getNumero(),
                        hoteis.getPais()
                ));
        return ResponseEntity.ok(response);
    }

    @Override
    public ResponseEntity<HoteisListResponse> criarHoteis(CreateHoteisRequest request) {
        Hoteis hoteis = mapper.convertValue(request, Hoteis.class);
        Hoteis hoteisCriado = hoteisService.criarHoteis(hoteis);
        HoteisListResponse hoteisListResponse = hoteisParaHoteisListResponse(hoteisCriado);
        return ResponseEntity.status(HttpStatus.CREATED).body(hoteisListResponse);
    }

    @Override
    public ResponseEntity<HoteisListResponse> buscarHoteisPorId(UUID id) {
        Hoteis hoteis = hoteisService.buscarHoteisPorId(id);
        HoteisListResponse hoteisListResponse = hoteisParaHoteisListResponse(hoteis);
        return ResponseEntity.ok(hoteisListResponse);
    }

    @Override
    public ResponseEntity<HoteisListResponse> atualizarHoteisPorId(UUID id, Map<String, Object> campos) {
        Hoteis hoteis = hoteisService.atualizarHoteis(id);
        HoteisListResponse hoteisListResponse = hoteisParaHoteisListResponse(hoteis);
        return ResponseEntity.accepted().body(hoteisListResponse);
    }

    @Override
    public ResponseEntity<Void> excluirHoteis(UUID id) {
        hoteisService.excluirHoteis(id);
        return ResponseEntity.noContent().build();
    }

    private HoteisListResponse hoteisParaHoteisListResponse(Hoteis acomodacao){
        return mapper.convertValue(acomodacao, HoteisListResponse.class);
    }

}
