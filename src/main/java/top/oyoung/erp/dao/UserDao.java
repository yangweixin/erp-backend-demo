package top.oyoung.erp.dao;

import org.apache.ibatis.annotations.*;
import top.oyoung.erp.entity.User;

import java.util.List;
import java.util.Map;

public interface UserDao {

    public User getUser();

    @Select("select * from user where id=#{id}")
    public User getUserById(int id);

    @Select("select * from user where username=#{name}")
    public User getUserByName(String name);

    @Insert({"insert user (account,username,address) value(#{name}, #{name}, #{name})}"})
    public int insertUser(String name);

    @Insert("insert into user (account,username,address) value('sun','孙秘书','西安')")
    public void insert();

    @Update("update user set account='zhen' where id=2")
    public void update();

    @Update("update user set account=#{account} where id=#{id}")
    public void updateUserById(@Param("account") String account, @Param("id")int id);

    @Delete("delete from user where id=1")
    public void delete();

    @Select("select * from user")
    public List<Map<String, Object>> query();

    @Select("select * from user where account=#{account}")
    public User getUserByAccount(String account);
}
