package top.oyoung.erp.service.impl;

import org.springframework.stereotype.Service;
import top.oyoung.erp.dao.UserDao;
import top.oyoung.erp.entity.User;
import top.oyoung.erp.service.UserService;

import javax.annotation.Resource;

/**
 * @Author: Yang Weixin
 * @Description:
 * @DateTime: 2018/7/11 上午11:43
 */
@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserDao userDao;

    @Override
    public User getUserByName(String username) {
        return userDao.getByName(username);
    }

    @Override
    public User getUserById(Long id) {
        return userDao.getById(id);
    }
}
