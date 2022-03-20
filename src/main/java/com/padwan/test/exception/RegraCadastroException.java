package com.padwan.test.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.server.ResponseStatusException;

public class RegraCadastroException extends ResponseStatusException {

    public RegraCadastroException(ResponseEntity request, int id) {
        super(HttpStatus.valueOf(id));
    }
}
