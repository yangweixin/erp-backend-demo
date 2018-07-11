package top.oyoung.erp.filter;

import com.google.common.net.HttpHeaders;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;
import top.oyoung.erp.Constants.Constants;
import top.oyoung.erp.entity.User;
import top.oyoung.erp.util.JwtUtil;

import javax.annotation.Resource;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author: Yang Weixin
 * @Description:
 * @DateTime: 2018/7/11 下午3:22
 */
@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    @Resource
    private JwtUtil jwtUtil;
    @Resource
    private UserDetailsService userDetailsService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
        throws ServletException, IOException {

        String authorization = request.getHeader(HttpHeaders.AUTHORIZATION);
        if( !StringUtils.isEmpty(authorization) && authorization.startsWith( Constants.AUTHORIZATION_HEADER )){

            String authToken = authorization.substring(Constants.AUTHORIZATION_HEADER.length());
            String username = jwtUtil.getUsernameFromToken(authToken);
            if( !StringUtils.isEmpty(username) && SecurityContextHolder.getContext().getAuthentication() == null){

                UserDetails user = userDetailsService.loadUserByUsername(username);
                if( user != null ){
                    UsernamePasswordAuthenticationToken token =
                        new UsernamePasswordAuthenticationToken(user,user.getPassword(),user.getAuthorities());

                    token.setDetails(user);

                    SecurityContextHolder.getContext().setAuthentication(token);
                }
            }
        }

        chain.doFilter(request, response);
    }
}
