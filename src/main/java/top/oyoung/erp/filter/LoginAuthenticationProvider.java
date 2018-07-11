package top.oyoung.erp.filter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;
import top.oyoung.erp.entity.User;
import top.oyoung.erp.service.impl.LoginUserDetailServiceImpl;

import java.util.Optional;

/**
 * @Author: Yang Weixin
 * @Description:
 * @DateTime: 2018/5/15 下午4:33
 */
@Component
public class LoginAuthenticationProvider implements AuthenticationProvider {

    @Autowired
    private LoginUserDetailServiceImpl userService;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String username = authentication.getName();
        String passwrod = authentication.getCredentials().toString();

        User user = Optional.ofNullable(userService.loadUserByUsername(username))
                .map(o -> (User)o).orElse(null);

        if(user != null && passwrod.equals(user.getPassword())){
            return new UsernamePasswordAuthenticationToken(user,passwrod,user.getAuthorities());
        }else{
            throw new BadCredentialsException(("wrong password"));
        }
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return (UsernamePasswordAuthenticationToken.class.isAssignableFrom(aClass));
    }
}
