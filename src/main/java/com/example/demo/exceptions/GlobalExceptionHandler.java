package com.example.demo.exceptions;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {

  @ExceptionHandler(Throwable.class)
  @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
  public ModelAndView exception(final Throwable throwable) {
    log.error("experiencing outage!", throwable);
    ModelAndView modelAndView = new ModelAndView("/error");
    String errorMessage = (throwable != null ? throwable.toString() : "Error!");
    modelAndView.addObject("errorMessage", errorMessage);
    return modelAndView;
  }
}
