package com.library.booktask.exception;

import com.library.booktask.response.APIErrorDTO;
import com.library.booktask.response.Data;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import javax.validation.ValidationException;


@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler({ValidationException.class})
    public ResponseEntity<Data<APIErrorDTO>> valid(ValidationException ex, WebRequest request) {
        APIErrorDTO path = APIErrorDTO.builder().developerMessage(ex.getStackTrace().toString()).message(ex.getMessage()).status(HttpStatus.CONFLICT.value()).path(request.getContextPath()).build();
        return new ResponseEntity<>(new Data<>(path), HttpStatus.OK);
    }

    @ExceptionHandler({NotFoundException.class})
    public ResponseEntity<Data<APIErrorDTO>> notFound(NotFoundException ex, WebRequest request) {
        APIErrorDTO path = APIErrorDTO.builder().developerMessage(ex.getMessage()).status(HttpStatus.NOT_FOUND.value()).path(request.getContextPath()).build();
        return new ResponseEntity<>(new Data<>(path), HttpStatus.OK);
    }

    @ExceptionHandler({RuntimeException.class})
    public ResponseEntity<Data<APIErrorDTO>> run(RuntimeException e, WebRequest request) {
        APIErrorDTO path = APIErrorDTO.builder().developerMessage(e.getMessage()).status(HttpStatus.NOT_FOUND.value()).path(request.getContextPath()).build();
        return new ResponseEntity<>(new Data<>(path), HttpStatus.OK);
    }

}
