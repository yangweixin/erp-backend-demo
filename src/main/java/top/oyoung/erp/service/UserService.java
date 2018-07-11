package top.oyoung.erp.service;

import top.oyoung.erp.entity.User;

/**
 * @Author: Yang Weixin
 * @Description:
 * @DateTime: 2018/7/11 上午11:42
 */
public interface UserService {

    User getUserByName(String username);

    User getUserById(Long id);
}
