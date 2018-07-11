package top.oyoung.erp.exception;

import java.util.UUID;

/**
 * @Author: Yang Weixin
 * @Description:
 * @DateTime: 2018/7/11 下午6:48
 */
public class LocalException extends RuntimeException{

    private String errorCode;
    private UUID uuid;

    public LocalException(String errorCode, String message){
        super(message);
        this.errorCode = errorCode;
        uuid = UUID.randomUUID();
    }
}
