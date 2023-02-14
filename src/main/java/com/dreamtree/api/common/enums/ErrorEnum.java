package com.dreamtree.api.common.enums;

import lombok.Getter;


//이승윤 ver0.1
@Getter
public enum ErrorEnum {

    //
    NO_CATEGORY(401,"no category", 1011),
    NO_PROGRAM_DETAIL(401, "no program details", 2021),
    POST_PROGRAM_FORM_FAIL(401, "post failed", 2031),
    POST_FILE_FORM_FAIL(401, "post failed", 2032),

    POST_LESSON_FORM_FAIL(401, "post failed", 2041);

    int code;

    int status;

    String msg;

    ErrorEnum(int status, String msg, int code){
        this.status = status;
        this.msg = msg;
        this.code = code;
    }

}
