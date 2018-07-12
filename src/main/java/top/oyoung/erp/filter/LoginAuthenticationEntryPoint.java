package top.oyoung.erp.filter;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;
import top.oyoung.erp.constants.ErrorCode;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: Yang Weixin
 * @Description:
 * @DateTime: 2018/5/16 下午5:14
 */
@Component
public class LoginAuthenticationEntryPoint implements AuthenticationEntryPoint {

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response,
                         AuthenticationException e) throws IOException {
        response.setStatus(HttpStatus.UNAUTHORIZED.value());
        Map<String, String> result = new HashMap<>();
        result.put("message", "未登录");
        result.put("errorCode", ErrorCode.USER_NOT_AUTHORIZATION);
        response.setCharacterEncoding("utf8");
        response.setContentType("application/json");
        response.getWriter().write(new ObjectMapper().writeValueAsString(result));
    }
}
