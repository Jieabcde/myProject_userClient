package com.example.bishe_.exception;

import com.example.bishe_.config.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
public class UnifiedExceptionHandler {

    @ExceptionHandler(value = Exception.class)
    public R handleException(Exception e) {
        log.error(e.getMessage(), e);
        return R.error(e.getMessage());
    }
}
