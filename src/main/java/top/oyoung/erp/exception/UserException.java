package top.oyoung.erp.exception;

import org.springframework.http.HttpStatus;
import top.oyoung.erp.Constants.ErrorCode;

public class UserException {

    public static class UserNotFoundException extends  LocalException{
        public UserNotFoundException(){
            super(HttpStatus.FORBIDDEN, ErrorCode.USER_LOGIN_USER_NOT_FOUND, "用户不存在");
        }
    }

    public static class PasswordErrorException extends  LocalException{
        public PasswordErrorException(){
            super(HttpStatus.FORBIDDEN, ErrorCode.USER_LOGIN_PASSWORD_ERROR, "密码错误");
        }
    }
}
