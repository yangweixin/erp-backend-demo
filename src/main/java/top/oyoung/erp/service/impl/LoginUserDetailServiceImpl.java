package top.oyoung.erp.service.impl;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import top.oyoung.erp.Constants.Constants;
import top.oyoung.erp.dao.UserDao;
import top.oyoung.erp.entity.User;

import javax.annotation.Resource;

/**
 * @Author: Yang Weixin
 * @Description:
 * @DateTime: 2018/5/15 下午4:51
 */
@Service
public class LoginUserDetailServiceImpl implements UserDetailsService {

    @Resource
    private UserDao userDao;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userDao.getByName(username);
        if(user != null) {
            user.addAuthorities(new SimpleGrantedAuthority(Constants.SECURITY_ROLE_PREFIX + "NOMAL"));
        }
        return user;
    }
}
