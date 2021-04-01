package br.com.zupacademy.ot3apirest.validation;

import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestControllerAdvice
public class ExceptionHandlerController {

    @ExceptionHandler(MethodArgumentNotValidException.class)  // trata todas excecoes com @Valid
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public List<?> gerarRespostaDeErro(MethodArgumentNotValidException exception){
        List<Map<String, String>> respostas = new ArrayList<>();
        exception.getBindingResult().getFieldErrors().forEach(FieldError -> {
            Map<String, String> erroDto = new HashMap<>();
            erroDto.put("campo", FieldError.getField());
            erroDto.put("mensagem", FieldError.getDefaultMessage());
            respostas.add(erroDto);
        });
        return respostas;

//        return exception.getBindingResult().getFieldErrors()
//                .stream()
//                .map(ErrosDto::new)
//                .collect(Collectors.toList());
    }
}
