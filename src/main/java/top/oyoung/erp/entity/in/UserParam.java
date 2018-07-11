package top.oyoung.erp.entity.in;

import javax.validation.constraints.NotBlank;

/**
 * @Author: Yang Weixin
 * @Description: 请求传入的User参数
 * @DateTime: 2018/7/11 下午5:52
 */
public class UserParam {

    @NotBlank
    private String username;
    @NotBlank
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
