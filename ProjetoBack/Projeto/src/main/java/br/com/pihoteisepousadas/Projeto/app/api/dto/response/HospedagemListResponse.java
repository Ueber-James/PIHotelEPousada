package br.com.pihoteisepousadas.Projeto.app.api.dto.response;

import br.com.pihoteisepousadas.Projeto.domain.entity.Hoteis;
import br.com.pihoteisepousadas.Projeto.domain.entity.Usuario;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.UUID;
@Getter
@Setter
@AllArgsConstructor
public class HospedagemListResponse {
    private UUID id;
    private LocalDate dataHospedagem;
    private Boolean cancelada;
    private String valor;
}
