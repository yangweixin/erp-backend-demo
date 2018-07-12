package top.oyoung.erp.service.impl;

import org.springframework.stereotype.Service;
import top.oyoung.erp.dao.UserDao;
import top.oyoung.erp.entity.Role;
import top.oyoung.erp.entity.User;
import top.oyoung.erp.entity.UserRole;
import top.oyoung.erp.service.UserService;

import javax.annotation.Resource;
import java.util.List;

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

    @Override
    public int insertUser(User user) {
        return userDao.insertOne(user);
    }

    @Override
    public int addRole(UserRole userRole) {
        return userDao.addRole(userRole);
    }

    @Override
    public List<Role> listRoles(UserRole userRole) {
        return userDao.listRoles(userRole);
    }
}
