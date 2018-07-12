package top.oyoung.erp.entity;

import org.apache.ibatis.type.Alias;

/**
 * @Author: Yang Weixin
 * @Description:
 * @DateTime: 2018/7/12 下午4:01
 */
@Alias("Role")
public class Role {

    private int id;
    private String role;
    private String description;
    private int status;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
