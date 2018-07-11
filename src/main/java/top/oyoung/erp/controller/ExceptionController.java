package top.oyoung.erp.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import top.oyoung.erp.exception.LocalException;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author: Yang Weixin
 * @Description:
 * @DateTime: 2018/7/11 下午6:27
 */
@RestControllerAdvice
public class ExceptionController {

    @ExceptionHandler(Exception.class)
    public ResponseEntity handler(
        HttpServletRequest request,
        Exception e
    ){
        if( e instanceof LocalException){

        }else {

        }
    }
}
