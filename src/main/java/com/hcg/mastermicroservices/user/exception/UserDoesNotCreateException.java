package com.hcg.mastermicroservices.user.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author hcguler
 */
@ResponseStatus(HttpStatus.BAD_REQUEST)
public class UserDoesNotCreateException extends RuntimeException {
    public UserDoesNotCreateException(String message) {
        super(message);
    }
}
