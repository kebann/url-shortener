package com.bobocode.controller;

import com.bobocode.dto.ErrorDto;
import com.bobocode.exception.InvalidUrlException;
import com.bobocode.exception.NoUrlFoundException;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ErrorHandlerController {

  @ExceptionHandler(NoUrlFoundException.class)
  public ResponseEntity<ErrorDto> handleNoUrlFoundException() {
    return ResponseEntity.notFound().build();
  }

  @Order(Ordered.HIGHEST_PRECEDENCE)
  @ExceptionHandler(InvalidUrlException.class)
  public ResponseEntity<ErrorDto> handleInvalidUrlException(InvalidUrlException e) {
    var error = new ErrorDto(e.getMessage());
    return ResponseEntity.badRequest().body(error);
  }

  @Order(Ordered.HIGHEST_PRECEDENCE)
  @ExceptionHandler(MethodArgumentNotValidException.class)
  public ResponseEntity<ErrorDto> handleMethodArgumentTypeMismatchException(
      MethodArgumentNotValidException e) {
    var fieldError = e.getFieldError();
    String errorMessage = "Field '%s' %s".formatted(fieldError.getField(),
        fieldError.getDefaultMessage());
    var error = new ErrorDto(errorMessage);
    return ResponseEntity.badRequest().body(error);
  }
}