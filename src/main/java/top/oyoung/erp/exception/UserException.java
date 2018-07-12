package top.oyoung.erp.exception;

import org.springframework.http.HttpStatus;
import top.oyoung.erp.constants.ErrorCode;

public class UserException {

    public static class NotAuthorizationException extends LocalException{
        public NotAuthorizationException(){
            super(HttpStatus.UNAUTHORIZED, ErrorCode.USER_NOT_AUTHORIZATION, "未登录");
        }
    }

    public static class UserAccessDeniedException extends LocalException{
        public UserAccessDeniedException(){
            super(HttpStatus.FORBIDDEN, ErrorCode.USER_ACCESS_DENIED, "权限不足");
        }
    }

    public static class UserNotFoundException extends LocalException{
        public UserNotFoundException(){
            super(HttpStatus.FORBIDDEN, ErrorCode.USER_LOGIN_USER_NOT_FOUND, "用户不存在");
        }
    }

    public static class PasswordErrorException extends LocalException{
        public PasswordErrorException(){
            super(HttpStatus.FORBIDDEN, ErrorCode.USER_LOGIN_PASSWORD_ERROR, "密码错误");
        }
    }

    public static class ValidCodeErrorException extends LocalException{
        public ValidCodeErrorException(){
            super(HttpStatus.FORBIDDEN, ErrorCode.USER_REGISTE_VALIDCODE_ERROR, "验证码错误");
        }
    }
}
