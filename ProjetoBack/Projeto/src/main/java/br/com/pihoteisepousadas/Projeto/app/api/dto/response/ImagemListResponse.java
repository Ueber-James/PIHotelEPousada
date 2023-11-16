package br.com.pihoteisepousadas.Projeto.app.api.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
public class ImagemListResponse {
    private UUID id;
    private String titulo;
    private String url;
}
