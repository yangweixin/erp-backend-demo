package top.oyoung.erp;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import top.oyoung.erp.Constants.Constants;
import top.oyoung.erp.entity.User;

@Configuration
public class TestUser {

    @Bean
    public User generateUser(){
        User user = new User();
        user.setUsername("ya");
        user.setPassword("password");
        user.addAuthorities(new SimpleGrantedAuthority(Constants.SECURITY_ROLE_PREFIX+ "NOMAL"));

        return user;
    }
}
