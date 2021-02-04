package com.nhn.rookie8.sample.ticket;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public final class ArticleNotFoundException extends RuntimeException {
    public ArticleNotFoundException(Long seq){
        super(String.valueOf(seq));
    }
}
