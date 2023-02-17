package com.dreamtree.api.exception;

import com.dreamtree.api.common.enums.CustomExceptionEnum;
import lombok.Getter;

//이승윤 ver0.1
@Getter
public class CustomException extends RuntimeException{
    CustomExceptionEnum errorEnum;

    public CustomException(CustomExceptionEnum error){
        super(error.getMsg());
        this.errorEnum = error;
    }
}
