package com.ZenPack.exception;

import com.ZenPack.common.APIResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.nio.file.AccessDeniedException;

@ControllerAdvice
class GlobalExceptionHandler {
    @ExceptionHandler
    public ResponseEntity handleAccessDeniedException(AccessDeniedException e){

        APIResponse apiResponse = new APIResponse();
        apiResponse.setStatus(HttpStatus.UNAUTHORIZED.value());

        return ResponseEntity.status(apiResponse.getStatus()).body(apiResponse);
    }
}
