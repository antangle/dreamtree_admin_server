package com.dreamtree.api.common.enums;


import lombok.Getter;

/*** 임성현 ver.0.1 ***/

@Getter
public enum StudentErrorEnum implements CustomExceptionEnum {

    //

    NO_COLLEGE(401, "no_college", 4121),
    NO_STUDENT_DETAIL(401, "no_student", 4122),
    POST_STUDENT_FORM_FAIL(401, "post failed", 4123),
    POST_STUDENT_FILE_FORM_FAIL(401, "post failed", 4124),
    DELETE_STUDENT_FAIL(401, "delete failed", 4125),
    MODIFY_STUDENT_FAIL(401, "update failed", 4126),
    POST_CERTIFICATE_FORM_FAIL(401, "post failed", 4127),
    NO_CERTIFICATE_DETAIL(401, "no_certificate", 4128),
    MODIFY_CERTIFICATE_FAIL(401, "update failed", 4129),
    DELETE_CERTIFICATE_FAIL(401, "delete failed", 4130),
    MODIFY_STUDENT_AUTH_FAIL(401, "modify failed", 4131);

    int code;

    int status;

    String msg;

    StudentErrorEnum(int status, String msg, int code){
        this.status = status;
        this.msg = msg;
        this.code = code;
    }

}
