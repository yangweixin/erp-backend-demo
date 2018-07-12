package top.oyoung.erp.entity;

import org.apache.ibatis.type.Alias;

/**
 * @Author: Yang Weixin
 * @Description:
 * @DateTime: 2018/7/12 下午3:31
 */
@Alias("UserRole")
public class UserRole {

    private int id;
    private int user;
    private int role;


    public UserRole(int user) {
        this.user = user;
    }

    public UserRole(int user, int role) {
        this.user = user;
        this.role = role;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUser() {
        return user;
    }

    public void setUser(int user) {
        this.user = user;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }
}
