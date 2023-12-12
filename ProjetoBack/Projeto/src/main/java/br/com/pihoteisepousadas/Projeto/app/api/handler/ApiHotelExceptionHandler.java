package br.com.pihoteisepousadas.Projeto.app.api.handler;

import br.com.pihoteisepousadas.Projeto.domain.exception.HoteisNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
@ControllerAdvice
public class ApiHotelExceptionHandler {
    @ExceptionHandler(HoteisNotFoundException.class)
    public ResponseEntity<?> hoteisNotFoundExceptionHandler(HoteisNotFoundException exception) {
        return ResponseEntity.badRequest().body(
                """
                {
                    "status" : 400,
                    "message" : "%s"
                }       \s
                """.formatted(exception.getMessage())
        );
    }
}
