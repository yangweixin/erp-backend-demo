package top.oyoung.erp.entity.out;

import org.springframework.security.core.GrantedAuthority;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Yang Weixin
 * @Description: 请求返回的User返回体
 * @DateTime: 2018/7/11 下午6:22
 */
public class UserResult {

    private int id ;
    private String username;
    private String address;
    private List<GrantedAuthority> authorities = new ArrayList<>();

    public UserResult(int id, String username, String address, List<GrantedAuthority> authorities) {
        this.id = id;
        this.username = username;
        this.address = address;
        this.authorities = authorities;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<GrantedAuthority> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(List<GrantedAuthority> authorities) {
        this.authorities = authorities;
    }
}
