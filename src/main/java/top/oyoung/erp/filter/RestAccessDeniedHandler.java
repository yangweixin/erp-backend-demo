package top.oyoung.erp.filter;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;
import top.oyoung.erp.constants.ErrorCode;
import top.oyoung.erp.exception.UserException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: Yang Weixin
 * @Description:
 * @DateTime: 2018/5/16 下午5:18
 */
@Component
public class RestAccessDeniedHandler implements AccessDeniedHandler {

    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response,
                       AccessDeniedException e) throws IOException{
        response.setStatus(HttpStatus.FORBIDDEN.value());
        Map<String, String> result = new HashMap<>();
        result.put("message", "未登录");
        result.put("errorCode", ErrorCode.USER_ACCESS_DENIED);
        response.setCharacterEncoding("utf8");
        response.setContentType("application/json");
        response.getWriter().write(new ObjectMapper().writeValueAsString(result));
    }
}
