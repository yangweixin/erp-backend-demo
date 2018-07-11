package top.oyoung.erp.exception;

import org.springframework.http.HttpStatus;

import java.util.UUID;

/**
 * @Author: Yang Weixin
 * @Description:
 * @DateTime: 2018/7/11 下午6:48
 */
public class LocalException extends RuntimeException{

    private HttpStatus status;
    private String errorCode;
    private UUID uuid;

    public LocalException(HttpStatus status, String errorCode, String message){
        super(message);
        this.status = status;
        this.errorCode = errorCode;
        uuid = UUID.randomUUID();
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }
}
