package top.oyoung.erp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import top.oyoung.erp.dao.UserDao;
import top.oyoung.erp.entity.User;

@Service
public class TestService {

    @Autowired
    private UserDao userDao;

    @Cacheable(value = "user", key = "'user-'+#id")
    public User getUserById(int id){
        System.out.println("getUserById");
        return userDao.getUserById(id);
    }

    @CachePut(value = "user", key = "'user-'+#id")
    public User updateUserById(int id,String account){
        System.out.println("updateUserById");
        userDao.updateUserById(account,id );
        return userDao.getUserById(id);
    }

    @CacheEvict(value = "user", allEntries = true)
    @Scheduled(fixedDelay = 10000)
    public void deleteCache(){

    }
}
