package top.oyoung.erp.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import top.oyoung.erp.exception.LocalException;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * @Author: Yang Weixin
 * @Description:
 * @DateTime: 2018/7/11 下午6:27
 */
@RestControllerAdvice
public class ExceptionController {

    @ExceptionHandler(LocalException.class)
    public ResponseEntity handler(
        HttpServletRequest request,
        Exception e
    ) {

        Map<String, String> map = new HashMap<>();

        LocalException local = (LocalException)e;

        map.put("errorcode", local.getErrorCode());
        map.put("message", local.getMessage());
        return new ResponseEntity(map, local.getStatus());
    }
}
