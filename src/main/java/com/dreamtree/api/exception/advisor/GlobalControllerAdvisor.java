package com.dreamtree.api.exception.advisor;

import com.dreamtree.api.exception.CustomException;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Map;

@RestControllerAdvice
@Log4j2
public class GlobalControllerAdvisor {
    @ExceptionHandler(CustomException.class)
    public ResponseEntity<Map<String, String>> AuthExceptionHandler(CustomException exception) {
        return ResponseEntity.status(exception.getErrorEnum().getStatus())
                .body(Map.of("exception", exception.getErrorEnum().getMsg(), "code", Integer.toString(exception.getErrorEnum().getCode())));

    }

}
