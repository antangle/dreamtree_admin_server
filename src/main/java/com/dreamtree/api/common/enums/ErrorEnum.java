package com.dreamtree.api.common.enums;

import lombok.Getter;


//이승윤 ver0.1
@Getter
public enum ErrorEnum implements CustomExceptionEnum {

    //
    NO_CATEGORY(401,"no category", 1011),
    NO_PROGRAM(401, "no program data exists", 1012),
    NO_PROGRAM_DETAIL(401, "no program details", 2021),
    POST_PROGRAM_FORM_FAIL(401, "post failed", 2031),
    POST_FILE_FORM_FAIL(401, "post failed", 2032),
    POST_LESSON_FORM_FAIL(401, "post failed", 2041),
    STUDENT_NO_PROGRAM(401, "no program data exists", 2051),

    ATTENDANCE_UPDATE_FAIL(401, "attendance update fail", 4041),

    //카카오페이
    KAKAO_PAY_READY_FAIL(401, "kakao pay ready error", 5011),
    KAKAO_PAY_CANCEL(401, "kakao pay cancel", 5012),
    KAKAO_PAY_FAIL(401, "kakao pay fail", 5013),
    ;

    int code;

    int status;

    String msg;

    ErrorEnum(int status, String msg, int code){
        this.status = status;
        this.msg = msg;
        this.code = code;
    }

}
