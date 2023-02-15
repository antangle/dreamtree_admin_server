package com.dreamtree.api.exception;

import com.dreamtree.api.common.enums.CustomExceptionEnum;

public class StudentException extends CustomException{
    public StudentException(CustomExceptionEnum error) {
        super(error);
    }

    @Override
    public CustomExceptionEnum getErrorEnum() {
        return super.getErrorEnum();
    }
}
