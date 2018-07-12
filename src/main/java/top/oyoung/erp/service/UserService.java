package top.oyoung.erp.service;

import top.oyoung.erp.entity.Role;
import top.oyoung.erp.entity.User;
import top.oyoung.erp.entity.UserRole;

import java.util.List;

/**
 * @Author: Yang Weixin
 * @Description:
 * @DateTime: 2018/7/11 上午11:42
 */
public interface UserService {

    User getUserByName(String username);

    User getUserById(Long id);

    int insertUser(User user);

    int addRole(UserRole userRole);

    List<Role> listRoles(UserRole userRole);
}
