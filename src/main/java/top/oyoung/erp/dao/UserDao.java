package top.oyoung.erp.dao;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import top.oyoung.erp.entity.User;

public interface UserDao {

    @Select("select * from user where id=#{id}")
    User getById(Long id);

    @Select("select * from user where username=#{name}")
    User getByName(String name);

    @Insert({"insert user (username,password,address) value(#{username}, #{password}, #{address})}"})
    int insertOne(User user);

    @Update("update user set username=#{username},password=#{password},address=#{address} where id=#{id}")
    int updateById(Long id);

    @Delete("delete from user where id=#{id}")
    int deleteById(Long id);
}
