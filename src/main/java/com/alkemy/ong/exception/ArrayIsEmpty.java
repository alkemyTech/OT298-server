package com.alkemy.ong.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ArrayIsEmpty extends RuntimeException {

    public ArrayIsEmpty (String message){
        super(message);
    }
}
