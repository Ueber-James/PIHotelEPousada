package br.com.pihoteisepousadas.Projeto.app.api.controller;

import br.com.pihoteisepousadas.Projeto.app.api.AcomodacaoApi;
import br.com.pihoteisepousadas.Projeto.app.api.dto.request.CreateAcomodacaoRequest;
import br.com.pihoteisepousadas.Projeto.app.api.dto.response.AcomodacaoListResponse;
import br.com.pihoteisepousadas.Projeto.domain.entity.Acomodacao;
import br.com.pihoteisepousadas.Projeto.domain.service.AcomodacaoService;
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
public class AcomodacaoController implements AcomodacaoApi {
    private final AcomodacaoService acomodacaoService;
    private final ObjectMapper mapper;
    @Autowired
    public AcomodacaoController(AcomodacaoService acomodacaoService, ObjectMapper mapper) {
        this.acomodacaoService = acomodacaoService;
        this.mapper = mapper;
    }
    @Override
    public ResponseEntity<Page<AcomodacaoListResponse>> buscarAcomodacao(Pageable pageable) {
        Page<Acomodacao> acomodacaoPage = acomodacaoService.buscarAcomodacao(pageable);

        Page<AcomodacaoListResponse> response = acomodacaoPage
                .map(acomodacao -> new AcomodacaoListResponse(acomodacao.getId(), acomodacao.getNome(), acomodacao.getCnpj()));
        return ResponseEntity.ok(response);
    }

    @Override
    public ResponseEntity<AcomodacaoListResponse> criarAcomodacao(CreateAcomodacaoRequest request) {
        Acomodacao acomodacao = mapper.convertValue(request, Acomodacao.class);
        Acomodacao acomodacaoCriado = acomodacaoService.criarAcomodacao(acomodacao);
        AcomodacaoListResponse acomodacaoListResponse = acomodacaoParaAcomodacaoListResponse(acomodacaoCriado);
        return ResponseEntity.status(HttpStatus.CREATED).body(acomodacaoListResponse);
    }

    @Override
    public ResponseEntity<AcomodacaoListResponse> buscarAcomodacaoPorId(UUID id) {
        Acomodacao acomodacao = acomodacaoService.buscarAcomodacaoPorId(id);
        AcomodacaoListResponse acomodacaoListResponse = acomodacaoParaAcomodacaoListResponse(acomodacao);
        return ResponseEntity.ok(acomodacaoListResponse);
    }

    @Override
    public ResponseEntity<AcomodacaoListResponse> atualizarAcomodacaoPorId(UUID id, Map<String, Object> campos) {
        Acomodacao acomodacao = acomodacaoService.atualizarAcomodacao(id);
        AcomodacaoListResponse acomodacaoListResponse = acomodacaoParaAcomodacaoListResponse(acomodacao);
        return ResponseEntity.accepted().body(acomodacaoListResponse);
    }

    @Override
    public ResponseEntity<Void> excluirAcomodacao(UUID id) {
        acomodacaoService.excluirAcomodacao(id);
        return ResponseEntity.noContent().build();
    }

    private AcomodacaoListResponse acomodacaoParaAcomodacaoListResponse(Acomodacao acomodacao){
        return mapper.convertValue(acomodacao, AcomodacaoListResponse.class);
    }

}
