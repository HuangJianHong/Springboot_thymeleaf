package com.example.demo.handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class ErrorExceptionHandler {
    private static final Logger LOG = LoggerFactory.getLogger(ErrorExceptionHandler.class);

    @ExceptionHandler
    @ResponseStatus(HttpStatus.OK)
    public ModelAndView processException(Exception e){
        LOG.info("--------自定义异常处理-exception-------");
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("ZyException", e.getMessage());
        modelAndView.setViewName("error/500");
        return  modelAndView;
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)   //可以直接定义返回的额错误码
    public ModelAndView processException(RuntimeException e){
        LOG.info("--运行时异常-runtimeexception--");
        ModelAndView m = new ModelAndView();
        m.addObject("ZyException", e.getMessage());
        m.setViewName("error/500");
        return m;
    }




}
