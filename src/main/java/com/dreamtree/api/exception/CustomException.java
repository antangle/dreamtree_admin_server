package com.dreamtree.api.exception;

import com.dreamtree.api.common.enums.ErrorEnum;
import lombok.Getter;

//이승윤 ver0.1
@Getter
public class CustomException extends RuntimeException{
    ErrorEnum errorEnum;

    public CustomException(ErrorEnum error){
        super(error.name());
        this.errorEnum = error;
    }

}
