package top.oyoung.erp.entity.out;

/**
 * @Author: Yang Weixin
 * @Description:
 * @DateTime: 2018/7/12 下午2:52
 */
public class TokenResult {
    private String token;

    public TokenResult(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
