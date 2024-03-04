package com.infogalaxy.librarymanagementsystem.responses;

import lombok.Data;
import org.springframework.http.HttpStatus;


/***
 * Responses class is responsible to custom response object with response data
 */
@Data
public class Responses {

    private String message;

    private HttpStatus code;

    private Object object;



    public Responses(HttpStatus code, String message) {
        this.code = code;
        this.message = message;
    }

    public Responses(String message, HttpStatus code, Object object) {
        this.message = message;
        this.code = code;
        this.object = object;
    }
}
