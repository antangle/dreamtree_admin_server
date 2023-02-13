package com.dreamtree.api.common.enums;

import lombok.Getter;


@Getter
public enum ErrorEnum {

    //
    NO_CATEGORY(401,"no category", 1011);

    int code;

    int status;

    String msg;

    ErrorEnum(int status, String msg, int code){
        this.status = status;
        this.msg = msg;
        this.code = code;
    }

}
