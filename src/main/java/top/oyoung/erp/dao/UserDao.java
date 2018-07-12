package top.oyoung.erp.dao;

import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;
import top.oyoung.erp.entity.Role;
import top.oyoung.erp.entity.User;
import top.oyoung.erp.entity.UserRole;

import java.util.List;


public interface UserDao {

    @Select("select * from demo.user where id=#{id}")
    User getById(Long id);

    @Select("select * from demo.user where username=#{name}")
    User getByName(String name);

    int insertOne(User user);

    @Update("update demo.user set username=#{username},password=#{password},address=#{address} where id=#{id}")
    int updateById(Long id);

    @Delete("delete from demo.user where id=#{id}")
    int deleteById(Long id);

    int addRole(UserRole userRole);

    List<Role> listRoles(UserRole userRole);
}
