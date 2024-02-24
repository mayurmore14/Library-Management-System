package com.infogalaxy.librarymanagementsystem.responses;

import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
public class Responses {

    private String message;

    private HttpStatus code;

    private Object object;



    public Responses(HttpStatus code, Object object) {
        this.code = code;
        this.object = object;
    }

    public Responses(String message, HttpStatus code, Object object) {
        this.message = message;
        this.code = code;
        this.object = object;
    }
}
