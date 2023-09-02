package com.amadeus.ikramdagci.domain.model;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class ErrorResponse<T> {
    private final LocalDateTime timestamp = LocalDateTime.now();
    private final T message;

    public ErrorResponse(final T message) {
        this.message = message;
    }

    public static <T> ErrorResponse<T>  of(T message){
        return new ErrorResponse<>(message);
    }
}
